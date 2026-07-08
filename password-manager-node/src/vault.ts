import crypto from 'node:crypto';
import fs from 'node:fs/promises';
import path from 'node:path';

const VAULT_PATH = path.join(process.cwd(), '.vault.enc');
const KEY_LEN = 32; // For AES-256
const SALT_LEN = 16;
const IV_LEN = 12; // Recommended for GCM

export class Vault {
  private masterKey: Buffer | null = null;

  async init(masterPassword: string): Promise<void> {
    const salt = crypto.randomBytes(SALT_LEN);
    const key = this.deriveKey(masterPassword, salt);
    
    // Structure: salt + iv + authTag + encryptedData
    const data = JSON.stringify({ passwords: [] });
    const iv = crypto.randomBytes(IV_LEN);
    const cipher = crypto.createCipheriv('aes-256-gcm', key, iv);
    
    const encrypted = Buffer.concat([cipher.update(data, 'utf8'), cipher.final()]);
    const authTag = cipher.getAuthTag();
    
    const vaultContent = Buffer.concat([salt, iv, authTag, encrypted]);
    await fs.writeFile(VAULT_PATH, vaultContent);
  }

  private deriveKey(password: string, salt: Buffer): Buffer {
    return crypto.scryptSync(password, salt, KEY_LEN);
  }

  private async loadVault(password: string): Promise<any> {
    const fileContent = await fs.readFile(VAULT_PATH);
    const salt = fileContent.subarray(0, SALT_LEN);
    const iv = fileContent.subarray(SALT_LEN, SALT_LEN + IV_LEN);
    const authTag = fileContent.subarray(SALT_LEN + IV_LEN, SALT_LEN + IV_LEN + 16);
    const encryptedData = fileContent.subarray(SALT_LEN + IV_LEN + 16);

    const key = this.deriveKey(password, salt);
    const decipher = crypto.createDecipheriv('aes-256-gcm', key, iv);
    decipher.setAuthTag(authTag);
    
    const decrypted = Buffer.concat([decipher.update(encryptedData), decipher.final()]);
    return JSON.parse(decrypted.toString('utf8'));
  }

  async addEntry(password: string, service: string, username: string, entryPass: string): Promise<void> {
    const vaultData = await this.loadVault(password);
    vaultData.passwords.push({ service, username, password: entryPass });
    await this.saveVault(password, vaultData);
  }

  async getEntries(password: string): Promise<any[]> {
    const vaultData = await this.loadVault(password);
    return vaultData.passwords;
  }

  async getAllEntries(password: string): Promise<string[]> {
    const vaultData = await this.loadVault(password);
    return vaultData.passwords.map((e: any) => e.service);
  }

  private async saveVault(password: string, data: any): Promise<void> {
    const salt = crypto.randomBytes(SALT_LEN);
    const iv = crypto.randomBytes(IV_LEN);
    const key = this.deriveKey(password, salt);
    const cipher = crypto.createCipheriv('aes-256-gcm', key, iv);

    const encrypted = Buffer.concat([cipher.update(JSON.stringify(data), 'utf8'), cipher.final()]);
    const authTag = cipher.getAuthTag();
    
    const vaultContent = Buffer.concat([salt, iv, authTag, encrypted]);
    await fs.writeFile(VAULT_PATH, vaultContent);
  }
}

#!/usr/bin/env node
import { Command } from 'commander';
import prompts from 'prompts';
import crypto from 'node:crypto';
import { Vault } from './vault.js';

const program = new Command();
const vault = new Vault();

program
  .version('1.0.0')
  .description('A simple CLI Password Manager');

program
  .command('init')
  .description('Initialize the password vault')
  .action(async () => {
    const response = await prompts({
      type: 'password',
      name: 'password',
      message: 'Set your master password:'
    });

    if (response.password) {
      await vault.init(response.password);
      console.log('Vault initialized successfully!');
    }
  });

program
  .command('add')
  .description('Add a new password')
  .action(async () => {
    const response = await prompts([
      { type: 'password', name: 'masterPassword', message: 'Enter master password:' },
      { type: 'text', name: 'service', message: 'Service name:' },
      { type: 'text', name: 'username', message: 'Username:' },
      { type: 'password', name: 'password', message: 'Password to store:' }
    ]);

    if (response.masterPassword && response.service && response.username && response.password) {
      await vault.addEntry(response.masterPassword, response.service, response.username, response.password);
      console.log('Entry added successfully!');
    }
  });

program
  .command('list')
  .description('List all services')
  .action(async () => {
    const response = await prompts({ type: 'password', name: 'masterPassword', message: 'Enter master password:' });
    if (response.masterPassword) {
      const services = await vault.getAllEntries(response.masterPassword);
      console.log('Services:', services.join(', '));
    }
  });

program
  .command('get')
  .description('Get password for a service')
  .action(async () => {
    const response = await prompts([
      { type: 'password', name: 'masterPassword', message: 'Enter master password:' },
      { type: 'text', name: 'service', message: 'Service name:' }
    ]);
    if (response.masterPassword && response.service) {
      const entries = await vault.getEntries(response.masterPassword);
      const entry = entries.find(e => e.service === response.service);
      if (entry) {
        console.log(`Username: ${entry.username}, Password: ${entry.password}`);
      } else {
        console.log('Entry not found.');
      }
    }
  });

program
  .command('gen')
  .description('Generate a secure password')
  .action(() => {
    const password = crypto.randomBytes(16).toString('hex');
    console.log('Generated password:', password);
  });

program.parse(process.argv);

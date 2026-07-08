# Secure CLI Password Manager

A secure, local-only command-line interface (CLI) password manager designed for efficiency and high security. It enables users to securely generate, store, and retrieve passwords for various services, with all data protected locally using industry-standard AES-256-GCM encryption.

## 1. Project Overview
A secure, local-only command-line interface (CLI) password manager designed for efficiency and high security. It enables users to securely generate, store, and retrieve passwords for various services, with all data protected locally using industry-standard AES-256-GCM encryption.

## 2. Design Philosophy
*   **Security First:** The application prioritizes local-only storage to minimize attack vectors. Master passwords are never stored; they are used only to derive an encryption key via `scrypt`.
*   **Minimalism:** The CLI is built for rapid interaction, ensuring that common tasks (adding, retrieving, listing) require minimal keystrokes.
*   **Robustness:** TypeScript is utilized to ensure type safety, and `tsx` is used for reliable execution in a modern ES Module environment.

## 3. Technology Stack
*   **Runtime:** Node.js
*   **Language:** TypeScript
*   **CLI Framework:** `commander`
*   **Encryption:** Node.js built-in `crypto` module (AES-256-GCM, `scrypt` for key derivation).
*   **Interactive UI:** `prompts` for secure input handling.
*   **Execution:** `tsx` for high-performance TypeScript execution.

## 4. Current State
The application is fully functional for an MVP (Minimum Viable Product) and supports the following features:
*   **Vault Initialization (`init`):** Securely creates the encrypted `.vault.enc` storage file.
*   **Add Credentials (`add`):** Interactively adds service, username, and password entries.
*   **List Services (`list`):** Lists all service entries currently stored.
*   **Retrieve Credentials (`get`):** Securely decrypts and displays credentials for a specific service.
*   **Password Generator (`gen`):** Generates cryptographically secure random passwords.

## 5. Development Progress
1.  **Phase 1 (Scaffolding):** Project setup, TypeScript configuration, ESM migration, and `commander` setup.
2.  **Phase 2 (Security):** Implementation of encryption logic (AES-256-GCM + scrypt) and vault initialization.
3.  **Phase 3 (Core Operations):** Implementation of `add`, `get`, and `list` operations with re-encryption logic on every update.
4.  **Phase 4 (Final Features):** Implementation of the `gen` command and final polish of the user interface.

## 6. AI Model Used
This project was developed in collaboration with **Gemini**, an advanced AI model. Gemini acted as a senior software architect and pair programmer, providing technical guidance, design patterns, debugging assistance, and implementation logic throughout the development lifecycle.

## 7. Further Needs & Future Roadmap
While the MVP is functional, the following features would enhance the application:
*   **Error Handling:** Implement robust validation for decryption failures (e.g., incorrect master password).
*   **Password Strength Check:** Add a feature to audit the strength of stored passwords.
*   **Import/Export:** Allow importing/exporting of vault entries (e.g., CSV/JSON format).
*   **CLI Polish:** Integrate color-coding (`chalk`) for better readability in terminal output.
*   **Unit Testing:** Implement comprehensive test coverage using `vitest` or `jest`.

## 8. Getting Started

### Prerequisites
*   Node.js (v20+)

### Setup
```bash
cd password-manager-node
npm install
```

### Usage
Run commands via `npm`:
```bash
npm run start -- init
npm run start -- add
npm run start -- list
npm run start -- get
npm run start -- gen
```

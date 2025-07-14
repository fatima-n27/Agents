# Overview
This is an object-oriented Java project developed for the my Programming II coursework. It simulates a secure communication system between  agents, and implements features such as agent identification, messaging, inbox management, message encoding/encryption, and clearance-based communication restrictions.

Note: This project was developed without advanced Java features like inheritance (except in Stage 8), exception handling, or external libraries, as per coursework restrictions.

# Features
- Standard program testing in Java
- Added an enumeration with levels
- Stores messages in a linked list
- Store contents as an encoded array of ASCII integers.
- Encryption & Decryption implemented:
  - encrypt: Caesar cipher on encoded message content.
  - decrypt: Reverse cipher to decode.
- Encrypts and delivers the message to each individual agent's inbox.

# Example Usage
Instantiate Agents, create messages, encode, encrypt, send via SecretAgent, and decrypt using appropriate keys.

# Future Enhancements
- Implement robust exception handling (if coursework restrictions lifted).
- Develop a GUI for agent communication.
- Implement more complex encryption methods beyond Caesar cipher.
- Add persistent storage for agents and messages.


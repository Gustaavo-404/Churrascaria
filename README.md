# Churrascaria Stock Control Application

This project is a stock management application designed for a churrascaria (Brazilian steakhouse). It includes functionality to manage inventory, events, users, and equipment. The application also features a user login system to ensure secure access.

## Features

### **Inventory Management**
- **Meat (Carne):** Add, update, and monitor the stock of meats, including quantity and price.
- **Beverages (Bebida):** Manage stock of drinks with detailed pricing and quantity.
- **Additional Foods (Adicional):** Track additional portioned foods, such as side dishes, with quantity and pricing.
- **Equipment (Diversos):** Maintain a registry of equipment with information on quantity and condition.

### **Event Management**
- Plan and organize events with details like event name, description, date, start time, and end time.

### **User Management**
- Add and manage user accounts with secure login functionality.

### **User Login**
- Authenticate users to ensure that only authorized personnel can access the system.

---

## Database Setup

To use this application, create the following database and tables in MySQL:

```sql
CREATE DATABASE bdChurrascaria;

USE bdChurrascaria;

CREATE TABLE Usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    NomeUsuario VARCHAR(100),
    Senha VARCHAR(100)
);

CREATE TABLE Carne (
    idCarne INT PRIMARY KEY AUTO_INCREMENT,
    NomeCarne VARCHAR(100),
    Quantidade DOUBLE,
    Preco DOUBLE
);

CREATE TABLE Bebida (
    idBebida INT PRIMARY KEY AUTO_INCREMENT,
    NomeBebida VARCHAR(100),
    Quantidade DOUBLE,
    Preco DOUBLE
);

CREATE TABLE Evento (
    idEvento INT PRIMARY KEY AUTO_INCREMENT,
    NomeEvento VARCHAR(100),
    Descricao VARCHAR(500),
    DataEvento DATE,
    HorarioInicio TIME,
    HorarioTermino TIME
);

CREATE TABLE Adicional (
    idAdicional INT PRIMARY KEY AUTO_INCREMENT,
    NomeAdicional VARCHAR(100),
    Quantidade DOUBLE,
    Preco DOUBLE
);

CREATE TABLE Diverso (
    idDiverso INT PRIMARY KEY AUTO_INCREMENT,
    NomeDiverso VARCHAR(100),
    Quantidade INT,
    Estado VARCHAR(45)
);

# Library Management System

## Project Overview
The Library Management System is a simple Java-based application that helps manage library books. It allows users to add books, display available books, borrow books, and return books.

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- ArrayList Collection
- Scanner Class

## OOP Concepts Implemented

### 1. Encapsulation
Private variables are used in the LibraryItem class, and public getter methods provide access to them.

### 2. Inheritance
The Book class extends the abstract LibraryItem class and inherits its properties.

### 3. Polymorphism
Method overriding is implemented through the displayDetails() method.

### 4. Abstraction
LibraryItem is an abstract class containing the abstract displayDetails() method.

### 5. Interface
LibraryOperations defines the operations that the Library class must implement.

## Features
1. Add new books.
2. Display all books.
3. Borrow books.
4. Return books.
5. Check book availability.

## How to Run

1. Install Java JDK.
2. Download or clone this repository.
3. Open the project in VS Code, Eclipse, or IntelliJ IDEA.
4. Compile the program:

   `javac LibraryManagementSystem.java`

5. Run the program:

   `java LibraryManagementSystem`

## Project Structure

LibraryManagementSystem/
- LibraryManagementSystem.java
- README.md

## Author
Your Name

## Conclusion
This project demonstrates the practical implementation of Java OOP concepts such as encapsulation, inheritance, polymorphism, abstraction, and interfaces through a simple Library Management System.
# Design a Library Management System 📚
Problem Statement: Design a system for managing books and members in a library.

# Functional Requirements:

The library has a collection of books. Each book has a unique ID, title, author, and subject.

The system should be able to add new books or remove existing ones.

It should support registering new members and deactivating existing ones.

A member can search for books by title, author, or subject.

A member can borrow a book. A member has a limit on the number of books they can borrow at any given time (e.g., 5 books).

A member can return a book.

The system should keep track of which books are borrowed by which member and their due dates.

The system should be able to identify overdue books.

# Non-Functional Requirements:

The code should be well-structured with clear separation of concerns (e.g., models for Book, Member, Loan).

Ensure proper encapsulation to protect the internal state of the objects.
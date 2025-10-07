Design a Vending Machine 🍫
Problem Statement:
Design a simulation of a Vending Machine that dispenses items and handles money.

Functional Requirements:
The vending machine should have an inventory of items, each with a name, price, and quantity.
A user can select an item.
A user can insert coins of different denominations (e.g., 1, 5, 10, 25 cents).
The machine should validate the inserted money. If it's sufficient, it should dispense the item and return any change. If not, it should prompt for more money.
Users should be able to cancel a transaction and get a full refund of the money inserted in that transaction.
The machine should handle "out of stock" and "insufficient change" scenarios gracefully.
The owner should be able to reset the machine or refill the inventory.

Non-Functional Requirements:
The design should be state-driven (e.g., IdleState, AcceptingCoinState, DispensingState). Using the State Design Pattern is recommended.
The system should be easily extensible to support new types of payment (e.g., credit cards).
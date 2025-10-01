1. Design a Parking Lot 🚗
Problem Statement:
Design a system to manage a multi-level parking lot. The parking lot has different types of parking spots (e.g., for motorcycles, cars, trucks) on each floor.
Functional Requirements:
The system should support different types of vehicles: Motorcycle, Car, and Truck.
The parking lot has multiple floors, and each floor has a specific number of spots for each vehicle type.
A vehicle should be assigned the smallest available spot that fits it (e.g., a car can fit in a car spot or a truck spot, but not a motorcycle spot).
The system must provide a mechanism to find the first available parking spot for a given vehicle.
When a vehicle exits, the system should generate a ticket with a fee. The fee is calculated based on the duration of the stay. Implement a simple hourly rate pricing model.
The system should be able to show the number of free spots per floor for each spot type.
Non-Functional Requirements:
The code should be extensible to easily add new vehicle types or pricing models in the future.
Follow SOLID principles.


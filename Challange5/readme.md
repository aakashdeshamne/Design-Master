# Design a Single Elevator System 🏢
Problem Statement: Design a system to simulate the operation of a single elevator in a building with multiple floors.

# Functional Requirements:

The building has 'N' number of floors.

The elevator can move up or down.

A user can request the elevator from any floor (external request) to go in a specific direction (up or down).

A user inside the elevator can press a floor number (internal request) to be taken to that destination.

The elevator should process requests in an efficient manner (e.g., continue moving in the same direction to service all requests in that direction before changing direction).

The system should show the current floor and direction of the elevator.

The elevator doors should open when it arrives at a requested floor and close before it starts moving.

# Non-Functional Requirements:

The logic for picking the next floor should be separated from the elevator's core state (e.g., use a strategy pattern for the dispatching algorithm).

The solution should be modular and easy to understand.
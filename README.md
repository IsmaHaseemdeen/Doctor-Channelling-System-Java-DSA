# Doctor Channelling System | Java Data Structures & Algorithms

## Project Overview

The Doctor Channelling System is a Java-based, console-driven appointment management application developed as an academic project for **Unit 19: Data Structures and Algorithms**.

The project explores how fundamental data structures and algorithms can support patient registration, doctor management, appointment scheduling, cancellations, rescheduling, and waiting-list management.

The application uses object-oriented programming, linked lists, FIFO queues, arrays, and custom node structures to demonstrate dynamic record management and algorithmic problem-solving.

**Project Type:** Academic Java Console Application  
**Programming Language:** Java  
**Core Focus:** Data Structures, Algorithms, Object-Oriented Programming, and Complexity Analysis  
**Project Status:** Local academic prototype — not a deployed healthcare application

---

## Business Problem

Healthcare appointment management requires efficient handling of patient records, doctor availability, appointment scheduling, and waiting lists.

Manual appointment management can introduce scheduling conflicts, inefficient record handling, and difficulties managing appointment cancellations and rescheduling.

This project demonstrates how data structures and algorithms can be applied to a simplified doctor appointment management scenario.

## Application Features

The Java console application provides the following functionality:

- Patient registration and record display
- Doctor registration and availability management
- Searching for doctors by ID
- Appointment booking using available time slots
- Waiting-list management when appointment slots are full
- Appointment cancellation
- Reassignment of available appointment slots to waiting patients
- Appointment rescheduling
- Displaying scheduled appointments
- Input validation and error messages

The project demonstrates application behaviour through a command-line interface rather than a graphical or web-based interface.

## Data Structures Implemented

### Linked Lists

Custom linked list structures are used to manage dynamic collections of patients and appointments.

Linked lists allow new records to be inserted without requiring fixed-size storage.

### FIFO Queues

First-In-First-Out (FIFO) queue principles are used for handling registration sequences, appointments, and waiting lists.

The approach supports ordered processing of appointment requests.

### Arrays

Arrays are used to represent doctor appointment time slots and track whether each slot has been allocated.

### Nodes

The generic `Node<T>` class provides a reusable building block for linked data structures.

### Stack and Abstract Data Type Analysis

The accompanying academic report also examines stack operations, abstract data types, encapsulation, information hiding, and function-call management.

These topics form part of the project's theoretical and algorithmic analysis.

---

## Algorithms and Analysis

The academic report explores:

- Sorting patient records by age
- Bubble Sort and comparative sorting analysis
- Graph structures and shortest-path algorithms
- Dijkstra's Algorithm
- Floyd–Warshall Algorithm
- Iterative and recursive approaches
- Asymptotic analysis
- Big-O, Big-Omega, and Big-Theta notation
- Time and space complexity
- Abstract Data Type implementation trade-offs

Shortest-path algorithms are analysed as part of a proposed doctor home-visit routing scenario; they are not presented as features of the main appointment booking menu.

## Algorithmic Complexity

| Operation | Data Structure | Typical Complexity |
|---|---|---|
| Patient/Doctor Registration | Linked list | O(n) including duplicate-ID search |
| Doctor Search | Linked list | O(n) |
| Appointment Booking | Linked list and array | O(n) for patient/doctor lookup |
| Waiting-List Insertion | Linked list with tail pointer | O(1) |
| Waiting-List Reassignment | Linked list | O(w) for searching |
| Appointment Cancellation | Linked list | O(m) |
| Record Display | Linked list | O(n) |

Here, `n` represents the relevant patient/doctor count, `m` the number of appointments, and `w` the number of waiting patients. These values are analytical estimates based on the data structures used, not measured benchmarks.

## Object-Oriented Design

The implementation uses Java classes to model real-world entities and separate major responsibilities.

Examples include:

- `Patient` — patient data and display functionality
- `Doctor` — doctor information and appointment slot management
- `Appointment` — appointment records and relationships
- `Node<T>` — generic linked list node
- `PQueue` — patient registration and lookup
- `DQueue` — doctor registration and lookup
- `AQueue` — appointment and waiting-list management
- `DoctorChannellingSystem` — command-line interface and menu handling

The project demonstrates encapsulation, class design, data abstraction, and modular programming concepts.

## Error Handling and Testing

The academic report includes a test plan, test cases, error-handling discussions, and an evaluation of test results.

Relevant testing scenarios include:

- Empty or invalid user inputs
- Duplicate patient or doctor identifiers
- Searching for nonexistent doctors
- Appointment booking with available slots
- Appointment booking with fully occupied slots
- Cancellation of scheduled appointments
- Appointment rescheduling
- Displaying registered records

These represent the documented testing scope. Full runtime verification of the published source code should be performed separately.

## Project Structure

```text
Doctor-Channelling-System-Java-DSA/
├── src/
│   ├── DoctorChannellingSystem.java
│   ├── Patient.java
│   ├── Doctor.java
│   ├── Appointment.java
│   ├── Node.java
│   └── PQueue.java
├── images/
├── docs/
├── README.md
└── .gitignore
```

## How to Run

**Prerequisite:** Install a Java Development Kit (JDK).

Clone or download this GitHub repository.

Open a terminal in the `src` folder.

Compile the Java source files:

```bash
javac *.java
```

Run the console application:

```bash
java DoctorChannellingSystem
```

Follow the menu instructions to explore patient registration, doctor management, appointment booking, and scheduling operations.

Use fictional demonstration data only.

## Skills Demonstrated

### Programming
- Java Programming
- Object-Oriented Programming
- Console Application Development
- Input Validation
- Exception Handling
- Debugging

### Data Structures and Algorithms
- Linked Lists
- FIFO Queues
- Stack and Abstract Data Type Concepts
- Generic Node Structures
- Sorting Algorithms
- Graph and Shortest-Path Analysis
- Algorithm Complexity Evaluation
- Time and Space Optimization

### Software Engineering
- Problem-Solving
- Data Structure Selection
- Technical Documentation
- Test Case Design
- Software Testing
- Algorithm Evaluation

## Academic Context

This project was developed for **Unit 19: Data Structures and Algorithms**, within the Pearson BTEC Higher National Diploma in Computing.

It combines practical Java programming with theoretical evaluation of data structures, algorithms, abstract data types, efficiency, and software design decisions.

## Disclaimer

This is an academic software prototype developed for educational and portfolio purposes.

It is not a production healthcare system and should not be used for storing genuine patient information or making real medical appointments.

The additional `PQueue.java` class was introduced during repository preparation to complete a missing dependency in the original source archive.

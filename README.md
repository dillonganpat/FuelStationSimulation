# Fuel Station Simulation

**FuelStationSimulation** is a Java-based project that simulates operations at a fuel station.  
The program manages multiple drivers and vehicles, assigns vehicles randomly to drivers, and models fuel dispensing while tracking fuel inventory and sales.  

---

## **Features**

- Manages vehicles with unique IDs, fuel types, tank capacities, and classifications.  
- Assigns vehicles randomly to drivers (up to 2 vehicles per driver).  
- Simulates fuel dispensing from a fuel station with inventory and sales tracking.  
- Supports multiple fuel types (e.g., Regular, Diesel).  
- Outputs detailed driver and vehicle information.  

---

## **Project Structure**

src/
FuelStationSimulation/
Vehicle.java # Vehicle class with tank, type, and classification
FuelStation.java # FuelStation class handling fuel inventory and sales
Driver.java # Driver class managing drivers and vehicle assignment
Tester.java # Main tester for FuelStation operations
resources/
Vehicles.txt # Input file containing vehicle data
.gitignore # Ensures compiled/IDE files are ignored
README.md # This file


---

## **How to Run**

1. Make sure you have **Java JDK 17+** installed.  
2. Compile the Java files:  

```bash
javac -d out src/FuelStationSimulation/*.java
Run the main program:

java -cp out FuelStationSimulation.Driver
The program will read Vehicles.txt, assign vehicles to drivers randomly, and print driver/vehicle information.

Technologies Used
Java (OOP principles)

ArrayLists and data structures

Randomization and file I/O

Author
Dillon Ganpat

Email: dillonganpat@gmail.com

GitHub: https://github.com/dillonganpat

LinkedIn: https://www.linkedin.com/in/dillonganpat/

Notes
Make sure Vehicles.txt is in the resources/ folder so the program can read it correctly.

This project is suitable as a learning exercise for object-oriented programming, file handling, and simulation in Java.

# BookMyStay – Hotel Booking Management System

BookMyStay is a console-based hotel booking system built using **Core Java and Java Collections Framework**.
The project demonstrates how real-world systems manage **room inventory, reservations, services, and booking history** using proper data structures and object-oriented design.

---

## UC1 – Room Inventory Setup & Management

This module allows the admin to initialize and manage hotel room inventory.
Room types, their available counts, and prices are stored using **HashMap** for fast lookup.
It acts as the central source of truth for all room availability data.

---

## UC2 – Room Search & Availability Check

Guests can view available room types and check their prices without modifying the inventory.
The system performs read-only lookups on the inventory to ensure accurate availability information.
This prevents booking of rooms that are already unavailable.

---

## UC3 – Booking Request Queue

Booking requests are placed into a **Queue (LinkedList)** to maintain fairness.
Requests are processed in **FIFO (First Come First Served)** order.
This ensures predictable and fair handling of multiple booking requests.

---

## UC4 – Reservation Confirmation & Room Allocation

When a booking request is processed, the system confirms the reservation and assigns a **unique room ID**.
A **HashSet** ensures that room IDs are never duplicated.
The inventory is updated immediately to prevent double booking.

---

## UC5 – Add-On Service Selection

Guests can enhance their reservations with optional services such as **breakfast, airport pickup, or spa**.
Services are attached to reservations using a **Map of reservation IDs to service lists**.
The system can calculate the total additional cost of selected services.

---

## UC6 – Booking History & Reporting

All confirmed reservations are stored in a **List** to maintain booking history.
Admins can view past reservations, generate simple reports, and cancel bookings if needed.
This provides an audit trail of all booking activities.

---

## Technologies Used

* Java (Core Java)
* Eclipse IDE
* Java Collections Framework (HashMap, HashSet, ArrayList, Queue)

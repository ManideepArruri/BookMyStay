package com.bookmystay.inventory;

import java.util.Scanner;

public class InventoryApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RoomInventoryService inventory = new RoomInventoryService();

        int choice;

        do {

            System.out.println("\n--- Room Inventory Management ---");
            System.out.println("1. Add Room Type");
            System.out.println("2. Update Room Count");
            System.out.println("3. Update Room Price");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:
                System.out.print("Room Type: ");
                String type = scanner.nextLine();

                System.out.print("Room Count: ");
                int count = scanner.nextInt();

                System.out.print("Price per Night: ");
                double price = scanner.nextDouble();

                inventory.addRoomType(type, count, price);
                break;

            case 2:
                System.out.print("Room Type: ");
                type = scanner.nextLine();

                System.out.print("New Count: ");
                count = scanner.nextInt();

                inventory.updateRoomCount(type, count);
                break;

            case 3:
                System.out.print("Room Type: ");
                type = scanner.nextLine();

                System.out.print("New Price: ");
                price = scanner.nextDouble();

                inventory.updateRoomPrice(type, price);
                break;

            case 4:
                inventory.displayInventory();
                break;

            }

        } while (choice != 5);

        scanner.close();
    }
}
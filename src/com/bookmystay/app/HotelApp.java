package com.bookmystay.app;

import java.util.Scanner;

import com.bookmystay.inventory.RoomInventoryService;
import com.bookmystay.search.RoomSearchService;

public class HotelApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RoomInventoryService inventory = new RoomInventoryService();

        // Initial room setup
        inventory.addRoomType("Single", 10, 2000);
        inventory.addRoomType("Double", 5, 3500);
        inventory.addRoomType("Suite", 2, 7000);

        RoomSearchService searchService =
                new RoomSearchService(
                        inventory.getRoomInventory(),
                        inventory.getRoomPrice());

        int choice;

        do {

            System.out.println("\n--- Guest Menu ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Check Room Availability");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:
                searchService.showAvailableRooms();
                break;

            case 2:
                System.out.print("Enter room type: ");
                String type = scanner.nextLine();
                searchService.checkAvailability(type);
                break;

            }

        } while (choice != 3);

        scanner.close();
    }
}
package com.bookmystay.search;

import java.util.Map;

public class RoomSearchService {

    private Map<String, Integer> roomInventory;
    private Map<String, Double> roomPrice;

    public RoomSearchService(Map<String, Integer> roomInventory,
                             Map<String, Double> roomPrice) {

        this.roomInventory = roomInventory;
        this.roomPrice = roomPrice;
    }

    // Display all available rooms
    public void showAvailableRooms() {

        System.out.println("\nAvailable Rooms:");

        for (String type : roomInventory.keySet()) {

            int count = roomInventory.get(type);

            if (count > 0) {
                System.out.println(
                        type + " | Available: " + count +
                        " | Price: " + roomPrice.get(type));
            }
        }
    }

    // Check availability of a specific room
    public boolean checkAvailability(String type) {

        if (!roomInventory.containsKey(type)) {
            System.out.println("Room type does not exist.");
            return false;
        }

        if (roomInventory.get(type) <= 0) {
            System.out.println("Room not available.");
            return false;
        }

        System.out.println(type + " room is available.");
        return true;
    }
}
package com.bookmystay.inventory;

import java.util.HashMap;
import java.util.Map;

public class RoomInventoryService {

    private Map<String, Integer> roomInventory;
    private Map<String, Double> roomPrice;

    public Map<String, Integer> getRoomInventory() {
        return roomInventory;
    }

    public Map<String, Double> getRoomPrice() {
        return roomPrice;
    }
    
    public RoomInventoryService() {
        roomInventory = new HashMap<>();
        roomPrice = new HashMap<>();
    }

    // Add new room type
    public void addRoomType(String type, int count, double price) {
        roomInventory.put(type, count);
        roomPrice.put(type, price);

        System.out.println(type + " rooms added successfully.");
    }

    // Update room count
    public void updateRoomCount(String type, int newCount) {
        if (roomInventory.containsKey(type)) {
            roomInventory.put(type, newCount);
        } else {
            System.out.println("Room type not found.");
        }
    }

    // Update room price
    public void updateRoomPrice(String type, double price) {
        if (roomPrice.containsKey(type)) {
            roomPrice.put(type, price);
        } else {
            System.out.println("Room type not found.");
        }
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("\nRoom Inventory:");

        for (String type : roomInventory.keySet()) {
            int count = roomInventory.get(type);
            double price = roomPrice.get(type);

            System.out.println(type + " | Available: " + count + " | Price: " + price);
        }
    }
}
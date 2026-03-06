package com.bookmystay.allocation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.bookmystay.booking.Reservation;
import com.bookmystay.booking.BookingQueueService;
import com.bookmystay.inventory.RoomInventoryService;

public class RoomAllocationService {

    private Set<String> bookedRoomIds;
    private Map<String, Set<String>> roomAllocations;

    private RoomInventoryService inventoryService;
    private BookingQueueService bookingService;

    public RoomAllocationService(RoomInventoryService inventoryService,
                                 BookingQueueService bookingService) {

        this.inventoryService = inventoryService;
        this.bookingService = bookingService;

        bookedRoomIds = new HashSet<>();
        roomAllocations = new HashMap<>();
    }

    // Confirm booking and allocate room
    public void confirmReservation() {

        Reservation reservation = bookingService.processNextBooking();

        if (reservation == null) {
            return;
        }

        String roomType = reservation.getRoomType();

        Map<String, Integer> inventory = inventoryService.getRoomInventory();

        if (!inventory.containsKey(roomType) || inventory.get(roomType) == 0) {
            System.out.println("No available rooms for type: " + roomType);
            return;
        }

        String roomId = generateRoomId(roomType);

        bookedRoomIds.add(roomId);

        roomAllocations.putIfAbsent(roomType, new HashSet<>());
        roomAllocations.get(roomType).add(roomId);

        inventory.put(roomType, inventory.get(roomType) - 1);

        System.out.println("Reservation Confirmed!");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Type: " + roomType);
        System.out.println("Assigned Room ID: " + roomId);
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {

        int number = bookedRoomIds.size() + 101;

        String prefix = roomType.substring(0, 1).toUpperCase();

        String roomId = prefix + number;

        while (bookedRoomIds.contains(roomId)) {
            number++;
            roomId = prefix + number;
        }

        return roomId;
    }

    // Display allocations
    public void showRoomAllocations() {

        System.out.println("\nRoom Allocations:");

        for (String type : roomAllocations.keySet()) {

            System.out.println(type + " → " + roomAllocations.get(type));
        }
    }
}
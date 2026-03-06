package com.bookmystay.booking;

import java.util.LinkedList;
import java.util.Queue;

public class BookingQueueService {

    private Queue<Reservation> bookingQueue;

    public BookingQueueService() {
        bookingQueue = new LinkedList<>();
    }

    // Add booking request
    public void addBookingRequest(String guestName, String roomType) {

        Reservation reservation = new Reservation(guestName, roomType);
        bookingQueue.offer(reservation);

        System.out.println("Booking request added to queue.");
    }

    // Process booking request
    public Reservation processNextBooking() {

        if (bookingQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return null;
        }

        Reservation reservation = bookingQueue.poll();

        System.out.println("Processing booking for: " + reservation);

        return reservation;
    }

    // View queue
    public void viewQueue() {

        if (bookingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\nBooking Queue:");

        for (Reservation r : bookingQueue) {
            System.out.println(r);
        }
    }
}
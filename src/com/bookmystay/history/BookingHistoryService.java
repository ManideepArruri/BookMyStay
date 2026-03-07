package com.bookmystay.history;

import java.util.ArrayList;
import java.util.List;

import com.bookmystay.booking.Reservation;

public class BookingHistoryService {

    private List<Reservation> reservationHistory;

    public BookingHistoryService() {
        reservationHistory = new ArrayList<>();
    }

    // Add reservation to history
    public void addReservation(Reservation reservation) {

        reservationHistory.add(reservation);

        System.out.println("Reservation added to history.");
    }

    // Show all reservations
    public void showBookingHistory() {

        if(reservationHistory.isEmpty())
        {
            System.out.println("No reservations found.");
            return;
        }

        System.out.println("\nBooking History:");

        for(Reservation r : reservationHistory)
        {
            System.out.println(r);
        }
    }

    // Cancel reservation
    public void cancelReservation(String guestName)
    {
        Reservation found = null;

        for(Reservation r : reservationHistory)
        {
            if(r.getGuestName().equalsIgnoreCase(guestName))
            {
                found = r;
                break;
            }
        }

        if(found != null)
        {
            reservationHistory.remove(found);
            System.out.println("Reservation cancelled for " + guestName);
        }
        else
        {
            System.out.println("Reservation not found.");
        }
    }
}
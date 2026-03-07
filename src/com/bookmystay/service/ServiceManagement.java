package com.bookmystay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceManagement {

    private Map<String, List<Service>> reservationServices;

    public ServiceManagement() {
        reservationServices = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, Service service) {

        reservationServices.putIfAbsent(reservationId, new ArrayList<>());

        reservationServices.get(reservationId).add(service);

        System.out.println("Service added to reservation " + reservationId);
    }

    // Display services
    public void showServices(String reservationId) {

        if (!reservationServices.containsKey(reservationId)) {
            System.out.println("No services added.");
            return;
        }

        List<Service> services = reservationServices.get(reservationId);

        double total = 0;

        System.out.println("\nServices for Reservation " + reservationId);

        for (Service s : services) {
            System.out.println(s);
            total += s.getPrice();
        }

        System.out.println("Total Service Cost: ₹" + total);
    }
}
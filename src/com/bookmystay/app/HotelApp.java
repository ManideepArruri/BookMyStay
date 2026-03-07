package com.bookmystay.app;

import java.util.Scanner;

import com.bookmystay.allocation.RoomAllocationService;
import com.bookmystay.booking.BookingQueueService;
import com.bookmystay.inventory.RoomInventoryService;
import com.bookmystay.search.RoomSearchService;
import com.bookmystay.service.Service;
import com.bookmystay.service.ServiceManagement;
import com.bookmystay.history.BookingHistoryService;

public class HotelApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RoomInventoryService inventoryService = new RoomInventoryService();

        RoomSearchService searchService =
                new RoomSearchService(
                        inventoryService.getRoomInventory(),
                        inventoryService.getRoomPrice());
        BookingQueueService bookingService = new BookingQueueService();
        BookingHistoryService historyService = new BookingHistoryService();
        RoomAllocationService allocationService =
                new RoomAllocationService(inventoryService, bookingService,historyService);
        ServiceManagement serviceManagement = new ServiceManagement();

        int choice = 0;

        while (choice != 16) {

            System.out.println("\n====== BookMyStay Menu ======");
            System.out.println("1. Add Room Type (Admin)");
            System.out.println("2. Update Room Count (Admin)");
            System.out.println("3. Update Room Price (Admin)");
            System.out.println("4. Display Inventory (Admin)");
            System.out.println("5. View Available Rooms (Guest)");
            System.out.println("6. Check Room Availability (Guest)");
            System.out.println("7 Add Booking Request");
            System.out.println("8 Process Next Booking");
            System.out.println("9 View Booking Queue");
            System.out.println("10 Confirm Reservation");
            System.out.println("11 Show Room Allocations");
            System.out.println("12 Add Service to Reservation");
            System.out.println("13 View Reservation Services");
            System.out.println("14 View Booking History");
            System.out.println("15 Cancel Reservation");
            System.out.println("16 Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Room Type: ");
                    String type = scanner.nextLine();

                    System.out.print("Enter Room Count: ");
                    int count = scanner.nextInt();

                    System.out.print("Enter Price per Night: ");
                    double price = scanner.nextDouble();

                    inventoryService.addRoomType(type, count, price);
                    break;

                case 2:
                    System.out.print("Enter Room Type: ");
                    type = scanner.nextLine();

                    System.out.print("Enter New Room Count: ");
                    count = scanner.nextInt();

                    inventoryService.updateRoomCount(type, count);
                    break;

                case 3:
                    System.out.print("Enter Room Type: ");
                    type = scanner.nextLine();

                    System.out.print("Enter New Price: ");
                    price = scanner.nextDouble();

                    inventoryService.updateRoomPrice(type, price);
                    break;

                case 4:
                    inventoryService.displayInventory();
                    break;

                case 5:
                    searchService.showAvailableRooms();
                    break;

                case 6:
                    System.out.print("Enter Room Type: ");
                    type = scanner.nextLine();
                    searchService.checkAvailability(type);
                    break;
                case 7:

                    System.out.print("Enter Guest Name: ");
                    String guestName = scanner.nextLine();

                    System.out.print("Enter Room Type: ");
                    String roomType = scanner.nextLine();

                    bookingService.addBookingRequest(guestName, roomType);
                    break;

                case 8:

                    bookingService.processNextBooking();
                    break;

                case 9:

                    bookingService.viewQueue();
                    break;
                case 10:

                    allocationService.confirmReservation();
                    break;

                case 11:

                    allocationService.showRoomAllocations();
                    break;
                case 12:

                    System.out.print("Enter Reservation ID: ");
                    String reservationId = scanner.nextLine();

                    System.out.println("Select Service");
                    System.out.println("1 Breakfast (₹500)");
                    System.out.println("2 Airport Pickup (₹1200)");
                    System.out.println("3 Spa (₹2000)");

                    int serviceChoice = scanner.nextInt();
                    scanner.nextLine();

                    Service service = null;

                    switch(serviceChoice)
                    {
                        case 1:
                            service = new Service("Breakfast",500);
                            break;

                        case 2:
                            service = new Service("Airport Pickup",1200);
                            break;

                        case 3:
                            service = new Service("Spa",2000);
                            break;
                    }

                    serviceManagement.addService(reservationId, service);
                    break;

                case 13:

                    System.out.print("Enter Reservation ID: ");
                    reservationId = scanner.nextLine();

                    serviceManagement.showServices(reservationId);
                    break;
                case 14:

                    historyService.showBookingHistory();
                    break;

                case 15:

                    System.out.print("Enter Guest Name: ");
                    String guest = scanner.nextLine();

                    historyService.cancelReservation(guest);
                    break;
                case 16:
                    System.out.println("Exiting BookMyStay...");
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
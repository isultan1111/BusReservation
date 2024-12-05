package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BusManagement {
    private List<Bus> busList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBus() {
        try {
            System.out.print("Enter Bus Number: ");
            String busNumber = scanner.nextLine();
            System.out.print("Enter Source: ");
            String source = scanner.nextLine();
            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Enter Departure Time: ");
            String departureTime = scanner.nextLine();
            System.out.print("Enter Arrival Time: ");
            String arrivalTime = scanner.nextLine();
            System.out.print("Enter Total Seats: ");
            int totalSeats = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            Bus bus = new Bus(busNumber, source, destination, departureTime, arrivalTime, totalSeats);
            busList.add(bus);
            System.out.println("Bus added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine();  // Clear the invalid input
        }
    }

    public void removeBus() {
        try {
            System.out.print("Enter Bus Number to remove: ");
            String busNumber = scanner.nextLine();
            Bus busToRemove = null;
            for (Bus bus : busList) {
                if (bus.getBusNumber().equals(busNumber)) {
                    busToRemove = bus;
                    break;
                }
            }
            if (busToRemove != null) {
                busList.remove(busToRemove);
                System.out.println("Bus removed successfully.");
            } else {
                System.out.println("Bus not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid bus number.");
            scanner.nextLine();  // Clear the invalid input
        }
    }

    public void updateBus() {
        try {
            System.out.print("Enter Bus Number to update: ");
            String busNumber = scanner.nextLine();
            Bus busToUpdate = null;
            for (Bus bus : busList) {
                if (bus.getBusNumber().equals(busNumber)) {
                    busToUpdate = bus;
                    break;
                }
            }
            if (busToUpdate != null) {
                System.out.print("Enter new Source: ");
                String source = scanner.nextLine();
                System.out.print("Enter new Destination: ");
                String destination = scanner.nextLine();
                System.out.print("Enter new Departure Time: ");
                String departureTime = scanner.nextLine();
                System.out.print("Enter new Arrival Time: ");
                String arrivalTime = scanner.nextLine();
                System.out.print("Enter new Total Seats: ");
                int totalSeats = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                busToUpdate.setSource(source);
                busToUpdate.setDestination(destination);
                busToUpdate.setDepartureTime(departureTime);
                busToUpdate.setArrivalTime(arrivalTime);
                busToUpdate.setTotalSeats(totalSeats);
                busToUpdate.setAvailableSeats(totalSeats);  // Assuming available seats are reset
                System.out.println("Bus updated successfully.");
            } else {
                System.out.println("Bus not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine();  // Clear the invalid input
        }
    }

    public void displayBuses() {
        if (busList.isEmpty()) {
            System.out.println("No buses available.");
        } else {
            for (Bus bus : busList) {
                System.out.println(bus);
            }
        }
    }
}

package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String USERNAME = "user1";
    private static final String PASSWORD = "****";
    private static Scanner scanner = new Scanner(System.in);
    private static BusManagement busManagement = new BusManagement();

    public static void main(String[] args) {
        boolean check = true;
        while (check) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            try {
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        loginUser();
                        break;
                    case 2:
                        System.out.println("Exiting...");
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); 
            }
        }
    }

    private static void loginUser() {
        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            
            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                System.out.println("Login successful.");
                adminMenu();
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during login. Please try again.");
        }
    }

    private static void adminMenu() {
        boolean adminCheck = true;
        while (adminCheck) {
            System.out.println("1. Add Bus");
            System.out.println("2. Remove Bus");
            System.out.println("3. Update Bus");
            System.out.println("4. Display Buses");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            try {
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        busManagement.addBus();
                        break;
                    case 2:
                        busManagement.removeBus();
                        break;
                    case 3:
                        busManagement.updateBus();
                        break;
                    case 4:
                        busManagement.displayBuses();
                        break;
                    case 5:
                        System.out.println("Logging out...");
                        adminCheck = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }
    }
}

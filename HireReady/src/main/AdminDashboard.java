package main;

import java.util.Scanner;

public class AdminDashboard {

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Admin Dashboard =====");
            System.out.println("1 Student Management");
            System.out.println("2 Company Management");
            System.out.println("3 Placement Drives");
            System.out.println("4 View Applications");
            System.out.println("5 Logout");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    StudentMenu.main(null);
                    break;

                case 2:
                    CompanyMenu.main(null);
                    break;

                case 3:
                    PlacementDriveMenu.menu();
                    break;

                case 4:
                    ApplicationMenu.menu();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
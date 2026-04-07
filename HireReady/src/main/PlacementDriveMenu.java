package main;

import java.util.Scanner;
import dao.PlacementDriveDAO;

public class PlacementDriveMenu {

    public static void menu() {

        Scanner sc = new Scanner(System.in);
        PlacementDriveDAO dao = new PlacementDriveDAO();

        while (true) {

            System.out.println("\n===== Placement Drive Module =====");
            System.out.println("1 Create Drive");
            System.out.println("2 View Drives");
            System.out.println("3 Delete Drive");
            System.out.println("4 Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dao.createDrive();
                    break;

                case 2:
                    dao.viewDrives();
                    break;

                case 3:
                    dao.deleteDrive();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
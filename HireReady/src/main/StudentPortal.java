package main;

import java.util.Scanner;
import dao.StudentPortalDAO;

public class StudentPortal {

    public static void menu() {

        Scanner sc = new Scanner(System.in);
        StudentPortalDAO dao = new StudentPortalDAO();

        while (true) {

            System.out.println("\n===== Student Portal =====");
            System.out.println("1 View Placement Drives");
            System.out.println("2 Apply for Drive");
            System.out.println("3 View Application Status");
            System.out.println("4 Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dao.viewDrives();
                    break;

                case 2:
                    dao.applyForDrive();
                    break;

                case 3:
                    dao.viewApplications();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
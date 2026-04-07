package main;

import java.util.Scanner;
import dao.StudentPortalDAO;

public class ApplicationMenu {

    public static void menu() {

        Scanner sc = new Scanner(System.in);
        StudentPortalDAO dao = new StudentPortalDAO();

        while(true){

            System.out.println("\n===== Application Module =====");
            System.out.println("1 View Applications");
            System.out.println("2 Back");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    dao.viewApplications();
                    break;

                case 2:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
package main;

import java.util.Scanner;

public class AdminLogin {

    public static void login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== Admin Login =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {

            System.out.println("Login Successful!");
            AdminDashboard.menu();

        } else {

            System.out.println("Invalid Credentials");
        }
    }
}
package main;

import java.util.Scanner;
import dao.CompanyDAO;

public class CompanyMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CompanyDAO dao = new CompanyDAO();

        while (true) {

            System.out.println("\n===== Company Module =====");
            System.out.println("1 Add Company");
            System.out.println("2 View Companies");
            System.out.println("3 Update Company");
            System.out.println("4 Delete Company");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dao.addCompany();
                    break;

                case 2:
                    dao.viewCompanies();
                    break;

                case 3:
                    dao.updateCompany();
                    break;

                case 4:
                    dao.deleteCompany();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;

public class CompanyDAO {

    Scanner sc = new Scanner(System.in);

    // ADD COMPANY
    public void addCompany() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Company ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Company Name:");
            String name = sc.nextLine();

            System.out.println("Enter HR Name:");
            String hr = sc.nextLine();

            System.out.println("Enter Email:");
            String email = sc.nextLine();

            System.out.println("Enter Phone:");
            String phone = sc.nextLine();

            System.out.println("Enter Location:");
            String location = sc.nextLine();

            String query = "INSERT INTO company VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, hr);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, location);
            ps.setString(7, "pass");

            ps.executeUpdate();

            System.out.println("Company Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW COMPANIES
    public void viewCompanies() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM company";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-----------------------");
                System.out.println("ID: " + rs.getInt("company_id"));
                System.out.println("Name: " + rs.getString("company_name"));
                System.out.println("HR: " + rs.getString("hr_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Location: " + rs.getString("location"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE COMPANY
    public void updateCompany() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Company ID to update:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter New Location:");
            String location = sc.nextLine();

            String query = "UPDATE company SET location=? WHERE company_id=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, location);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Company Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE COMPANY
    public void deleteCompany() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Company ID to delete:");
            int id = sc.nextInt();

            String query = "DELETE FROM company WHERE company_id=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Company Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
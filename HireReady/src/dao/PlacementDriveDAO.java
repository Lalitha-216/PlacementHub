package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;

public class PlacementDriveDAO {

    Scanner sc = new Scanner(System.in);

    // CREATE DRIVE
    public void createDrive() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Drive ID:");
            int driveId = sc.nextInt();

            System.out.println("Enter Company ID:");
            int companyId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Drive Title:");
            String title = sc.nextLine();

            System.out.println("Enter Job Role:");
            String role = sc.nextLine();

            System.out.println("Enter Package (LPA):");
            double packageLpa = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter Drive Date (YYYY-MM-DD):");
            String date = sc.nextLine();

            System.out.println("Enter Last Date to Apply:");
            String lastDate = sc.nextLine();

            System.out.println("Enter Venue:");
            String venue = sc.nextLine();

            System.out.println("Enter Description:");
            String desc = sc.nextLine();

            String query = "INSERT INTO placement_drive VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, driveId);
            ps.setInt(2, companyId);
            ps.setString(3, title);
            ps.setString(4, role);
            ps.setDouble(5, packageLpa);
            ps.setString(6, date);
            ps.setString(7, lastDate);
            ps.setString(8, venue);
            ps.setString(9, desc);

            ps.executeUpdate();

            System.out.println("Placement Drive Created!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW DRIVES
    public void viewDrives() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM placement_drive";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("----------------------------");

                System.out.println("Drive ID: " + rs.getInt("drive_id"));
                System.out.println("Company ID: " + rs.getInt("company_id"));
                System.out.println("Title: " + rs.getString("drive_title"));
                System.out.println("Role: " + rs.getString("job_role"));
                System.out.println("Package: " + rs.getDouble("package_lpa"));
                System.out.println("Drive Date: " + rs.getString("drive_date"));
                System.out.println("Last Date: " + rs.getString("last_date_apply"));
                System.out.println("Venue: " + rs.getString("venue"));
                System.out.println("Description: " + rs.getString("description"));
            }

            if (!found) {
                System.out.println("No placement drives available.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE DRIVE
    public void deleteDrive() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Drive ID to delete:");
            int id = sc.nextInt();

            String query = "DELETE FROM placement_drive WHERE drive_id=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Drive Deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
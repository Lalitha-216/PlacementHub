package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;

public class StudentPortalDAO {

    Scanner sc = new Scanner(System.in);

    // VIEW DRIVES
    public void viewDrives() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM placement_drive";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("---------------------------");
                System.out.println("Drive ID: " + rs.getInt("drive_id"));
                System.out.println("Company ID: " + rs.getInt("company_id"));
                System.out.println("Title: " + rs.getString("drive_title"));
                System.out.println("Role: " + rs.getString("job_role"));
                System.out.println("Package: " + rs.getDouble("package_lpa"));
                System.out.println("Drive Date: " + rs.getString("drive_date"));
                System.out.println("Last Date: " + rs.getString("last_date_apply"));
                System.out.println("Venue: " + rs.getString("venue"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // APPLY FOR DRIVE
    public void applyForDrive() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Application ID:");
            int appId = sc.nextInt();

            System.out.println("Enter Student ID:");
            int studentId = sc.nextInt();

            System.out.println("Enter Drive ID:");
            int driveId = sc.nextInt();
            String check = "SELECT * FROM application WHERE student_id=? AND drive_id=?";

            PreparedStatement checkPs = conn.prepareStatement(check);
            checkPs.setInt(1, studentId);
            checkPs.setInt(2, driveId);

            ResultSet rs = checkPs.executeQuery();

            if(rs.next()){
                System.out.println("You already applied for this drive.");
                return;
            }

            sc.nextLine();

            String query = "INSERT INTO application VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, appId);
            ps.setInt(2, studentId);
            ps.setInt(3, driveId);
            ps.setString(4, "2026-03-10");
            ps.setString(5, "Eligible");
            ps.setString(6, "Applied");

            ps.executeUpdate();

            System.out.println("Application Submitted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW APPLICATIONS
    public void viewApplications() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM application";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("---------------------------");

                System.out.println("Application ID: " + rs.getInt("application_id"));
                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Drive ID: " + rs.getInt("drive_id"));
                System.out.println("Applied Date: " + rs.getString("applied_date"));
                System.out.println("Eligibility: " + rs.getString("eligibility_status"));
                System.out.println("Status: " + rs.getString("application_status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
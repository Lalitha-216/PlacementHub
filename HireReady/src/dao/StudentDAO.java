package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;

public class StudentDAO {

    Scanner sc = new Scanner(System.in);

    // ADD STUDENT
    public void addStudent() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Student ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Full Name:");
            String name = sc.nextLine();

            System.out.println("Enter Roll Number:");
            String roll = sc.nextLine();

            System.out.println("Enter Email:");
            String email = sc.nextLine();

            System.out.println("Enter Phone:");
            String phone = sc.nextLine();

            System.out.println("Enter Branch:");
            String branch = sc.nextLine();

            System.out.println("Enter Section:");
            String section = sc.nextLine();

            System.out.println("Enter Batch Year:");
            int batchYear = sc.nextInt();

            System.out.println("Enter CGPA:");
            double cgpa = sc.nextDouble();

            System.out.println("Enter Backlogs:");
            int backlogs = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Skills:");
            String skills = sc.nextLine();

            String query = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, roll);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, branch);
            ps.setString(7, section);
            ps.setInt(8, batchYear);
            ps.setDouble(9, cgpa);
            ps.setInt(10, backlogs);
            ps.setString(11, skills);
            ps.setString(12, "pass");

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW STUDENTS
    public void viewStudents() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM student";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("--------------------------------");

                System.out.println("ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("full_name"));
                System.out.println("Roll No: " + rs.getString("roll_no"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Branch: " + rs.getString("branch"));
                System.out.println("Section: " + rs.getString("section"));
                System.out.println("Batch Year: " + rs.getInt("batch_year"));
                System.out.println("CGPA: " + rs.getDouble("cgpa"));
                System.out.println("Backlogs: " + rs.getInt("backlogs"));
                System.out.println("Skills: " + rs.getString("skills"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public void updateStudent() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Student ID to update:");
            int id = sc.nextInt();

            System.out.println("Enter New CGPA:");
            double cgpa = sc.nextDouble();

            String query = "UPDATE student SET cgpa=? WHERE student_id=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setDouble(1, cgpa);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Student Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent() {

        try {

            Connection conn = DBConnection.getConnection();

            System.out.println("Enter Student ID to delete:");
            int id = sc.nextInt();

            String query = "DELETE FROM student WHERE student_id=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Student Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
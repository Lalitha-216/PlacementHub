package model;

public class Student {

    private int studentId;
    private String fullName;
    private String rollNo;
    private String email;
    private String phone;
    private String branch;
    private double cgpa;
    private int backlogs;
    private String skills;

    public Student(int studentId, String fullName, String rollNo, String email,
                   String phone, String branch, double cgpa, int backlogs, String skills) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.rollNo = rollNo;
        this.email = email;
        this.phone = phone;
        this.branch = branch;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
        this.skills = skills;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBranch() {
        return branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public String getSkills() {
        return skills;
    }
}
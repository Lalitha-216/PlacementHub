package model;

public class Company {

    private int companyId;
    private String companyName;
    private String hrName;
    private String email;
    private String phone;
    private String location;

    public Company(int companyId, String companyName, String hrName,
                   String email, String phone, String location) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.hrName = hrName;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public int getCompanyId() { return companyId; }
    public String getCompanyName() { return companyName; }
    public String getHrName() { return hrName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getLocation() { return location; }
}
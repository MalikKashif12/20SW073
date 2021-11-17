package Employeee;

import java.sql.*;

public class Database {
    public static Connection connect() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/employee_management_system";
        String username = "root";
        String password = "Mysql+root+pass+96";

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("[INFO] Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void createTable() {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        try {
            String query = "create table employee(name VARCHAR(24), age VARCHAR(24), address VARCHAR(24), email VARCHAR(40), post VARCHAR(24), id VARCHAR(24), fName VARCHAR(24), dob VARCHAR(24), phone VARCHAR(24), education VARCHAR(24), cnic VARCHAR(24))";
            ps = conn.prepareStatement(query);
            ps.execute();
            System.out.println("Table Created Successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteTable() {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        try {
            String query = "DROP TABLE account";
            ps = conn.prepareStatement(query);
//            ps.setString();
            ps.execute();
            System.out.println("Table Deleted Successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static boolean login(String username, String password) {
        boolean found = false;
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM account WHERE username = ? AND password = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                found = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return found;
    }

    public static void addEmployee(String name, String age, String address, String email, String post, String id, String fName, String dob, String phone, String education, String cnic) {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, age);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.setString(5, post);
            ps.setString(6, id);
            ps.setString(7, fName);
            ps.setString(8, dob);
            ps.setString(9, phone);
            ps.setString(10, education);
            ps.setString(11, cnic);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void removeEmployee(String id) {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM employee WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void updateEmployee(String iid, String name, String address, String email, String post, String id, String fName, String phone, String education, String cnic) {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        try {
            String query = "UPDATE employee SET name = ?, address = ?, email = ?, post = ?, id = ?, fName = ?, phone = ?, education = ?, cnic = ? WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, email);
            ps.setString(4, post);
            ps.setString(5, id);
            ps.setString(6, fName);
            ps.setString(7, phone);
            ps.setString(8, education);
            ps.setString(9, cnic);
            ps.setString(10, iid);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static String getName(String id) {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        ResultSet rs;
        String name = "";
        try {
            String query = "SELECT name FROM employee WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return name;
    }

    public static String getPhone(String id) {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        ResultSet rs;
        String name = "";
        try {
            String query = "SELECT phone FROM employee WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                name = rs.getString("phone");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return name;
    }
    public static String getEmail(String id) {
        Connection conn = Database.connect();
        PreparedStatement ps = null;
        ResultSet rs;
        String name = "";
        try {
            String query = "SELECT email FROM employee WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                name = rs.getString("email");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return name;
    }
}

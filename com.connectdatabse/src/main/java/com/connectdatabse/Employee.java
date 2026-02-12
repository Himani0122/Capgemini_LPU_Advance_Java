package com.connectdatabse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
	public static void main(String[] args) {
		//Load the driver class
		String url = "jdbc:postgresql://localhost:5432/college";
		String un = "postgres";
		String pwd = "root";
		try {
			Class.forName("org.postgresql.Driver");

			// to establish Connection
			Connection connect = DriverManager.getConnection(url, un, pwd);
			insert(connect);
            fetch(connect);
            update(connect);
            del(connect);

            connect.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert(Connection connect) throws SQLException{
		String sql = "insert into employee values (104,'Ayush',30000)";
		Statement stmt = connect.createStatement();
		stmt.execute(sql);
		System.out.println("Data Inserted");
	}
	public static void fetch(Connection connect) throws SQLException{
		String sql = "select * from employee";
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("Employee Records:");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
	}
	public static void update(Connection connect) throws SQLException{
		String sql = "update employee set salary = 500000 where id = 104";
        Statement stmt = connect.createStatement();
        int rows = stmt.executeUpdate(sql);
        System.out.println(rows + " Record Updated");
	}
	public static void del(Connection connect) throws SQLException{
		String sql = "delete from employee where id = 104";
        Statement stmt = connect.createStatement();
        int rows = stmt.executeUpdate(sql);
        System.out.println(rows + " Record Deleted");
	}
}

package com.connectdatabse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;

public class ReaddatafromEmployee {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/college";
		String un="postgres";
		String pwd = "root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection(url,un,pwd);
			//addEmployee(connect);
			//Deleteempbyid(connect);
			//updateEmpbyid(connect);
			findempbyid(connect);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void addEmployee(Connection connect) throws SQLException{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		System.out.print("Enter name: ");
		String name = sc.next();
		System.out.println("Enter Sal: ");
		int sal = sc.nextInt();
		String sql = "insert into Employee values(?,?,?)";
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setInt(3, sal);
		stmt.execute();
		System.out.println("Values Inserted..");
	}
	public static void Deleteempbyid(Connection connect) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		String sql = "delete from Employee  where emp_id = ?";
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		System.out.println("Id deleted");
	}
	public static void updateEmpbyid(Connection connect) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		System.out.println("Enter Sal: ");
		int sal = sc.nextInt();
		String sql = "update employee set sal = ? where emp_id = ?";
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.setInt(2, sal);
		stmt.execute();
		System.out.println("Updated");
	}
	public static void findempbyid(Connection connect) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		String sql = "Select * from Employee where emp_id = ?";
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet res = stmt.executeQuery();
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3));
		}
	}
}

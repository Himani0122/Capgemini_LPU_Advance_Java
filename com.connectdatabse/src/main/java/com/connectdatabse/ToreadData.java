package com.connectdatabse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ToreadData {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/college";
		String un="postgres";
		String pwd = "root";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id: ");
		int id = sc.nextInt();
		System.out.print("Enter name: ");
		String name = sc.next();
		System.out.print("Enter branch: ");
		String branch = sc.next();
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect =DriverManager.getConnection(url, un, pwd);
			
			String sql = "insert into student values (?,?,?)";
			PreparedStatement stmt = connect.prepareStatement(sql);
			
			System.out.println("Reading Data");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, branch);
			
			connect.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

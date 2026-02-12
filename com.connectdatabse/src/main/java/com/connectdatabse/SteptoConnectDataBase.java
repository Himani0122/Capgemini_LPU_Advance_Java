package com.connectdatabse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SteptoConnectDataBase {
	public static void main(String[] args) {
		//Load the driver class
		String url="jdbc:postgresql://localhost:5432/college";
		String un="postgres";
		String pwd = "root";
		try {
			Class.forName("org.postgresql.Driver");
			
			//to establish Connection
			Connection connect =DriverManager.getConnection(url, un, pwd);
			String sql = "insert into student values (3,'Miller','CSE')";
			//create statement
			Statement stmt = connect.createStatement();
			//Execute query
			stmt.execute(sql);
			
			connect.close();
			System.out.println("data inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

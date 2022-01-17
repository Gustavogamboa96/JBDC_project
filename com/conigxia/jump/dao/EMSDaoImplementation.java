package com.conigxia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.ConnectionManager;

public class EMSDaoImplementation implements EMSDao {
	ConnectionManager mng = new ConnectionManager();
	Connection connection = mng.getConnection();

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> result = new ArrayList<Employee>();
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM employees");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("ALL EMPLOYEES:");
			while(rs.next()) {
				Employee temp =  new Employee(rs.getInt("employee_id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
				result.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Employee getEmployee(int employee_id) {
		// TODO Auto-generated method stub
		Employee result = null;
		try {
			
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
			pstmt.setInt(1, employee_id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result =  new Employee(rs.getInt("employee_id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
			}
		return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;                                            
	}

	@Override
	public void addEmployee(Employee newbie) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO employees (fname, lname, email) VALUES (?, ?, ?)");
			pstmt.setString(1, newbie.getFname());
			pstmt.setString(2, newbie.getLname());
			pstmt.setString(3, newbie.getEmail());
			
			pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int employee_id, int option, String newinfo) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt;
			switch(option) {
			case 1:
				pstmt = connection.prepareStatement("UPDATE employees SET fname = ? WHERE employee_id = ?");
				pstmt.setString(1, newinfo);
				pstmt.setInt(2, employee_id);
				pstmt.executeUpdate();
				break;
			case 2:
				pstmt = connection.prepareStatement("UPDATE employees SET lname = ? WHERE employee_id = ?");
				pstmt.setString(1, newinfo);
				pstmt.setInt(2, employee_id);
				pstmt.executeUpdate();
				break;
			case 3:
				pstmt = connection.prepareStatement("UPDATE employees SET email = ? WHERE employee_id = ?");
				pstmt.setString(1, newinfo);
				pstmt.setInt(2, employee_id);
				pstmt.executeUpdate();
				break;
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteEmployee(int employee_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("DELETE FROM employees WHERE employee_id = ?");
			pstmt.setInt(1, employee_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}

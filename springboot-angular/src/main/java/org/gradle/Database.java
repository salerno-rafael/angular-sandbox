package org.gradle;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {

	private final String DRIVER = "com.mysql.jdbc.Driver";


	private java.sql.Connection getConnection() {
		try {
			Class.forName(DRIVER).newInstance();
			try {
				return DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> list() {
		List<Employee> lista = new ArrayList<Employee>();
		try {
			PreparedStatement st = getConnection().prepareStatement("SELECT * from emp_details ORDER BY emp_id ASC");
			ResultSet rs = st.executeQuery();

			while (rs.next())
				lista.add(new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getString("emp_email"),rs.getString("emp_gender"),rs.getString("emp_address")));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void delete(Employee emp){
		try {
			PreparedStatement st = getConnection().prepareStatement("delete from emp_details where emp_id=?");
			st.setInt(1, emp.getEmp_id());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Employee emp){
		try {
			String updateTableSQL = "UPDATE emp_details SET emp_name = ?,emp_email =?,emp_gender=?,emp_address=? WHERE emp_id = ?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(updateTableSQL);
			preparedStatement.setString(1, emp.getEmp_name());
			preparedStatement.setString(2, emp.getEmp_email());
			preparedStatement.setString(3, emp.getEmp_gender());
			preparedStatement.setString(4, emp.getEmp_address());
			preparedStatement.setInt(5, emp.getEmp_id());
			preparedStatement .executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Employee emp){
		String insertTableSQL = "INSERT INTO emp_details(emp_name, emp_email, emp_gender,emp_address) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = getConnection().prepareStatement(insertTableSQL);
			preparedStatement.setString(1, emp.getEmp_name());
			preparedStatement.setString(2, emp.getEmp_email());
			preparedStatement.setString(3, emp.getEmp_gender());
			preparedStatement.setString(4, emp.getEmp_address());
			preparedStatement .executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}

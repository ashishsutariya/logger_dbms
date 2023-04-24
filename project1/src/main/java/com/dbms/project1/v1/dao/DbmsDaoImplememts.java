package com.dbms.project1.v1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbms.project1.v1.model.Student;

import oracle.jdbc.pool.OracleDataSource;

public class DbmsDaoImplememts implements DbmsDaoInterface{

	@Override
	public List<Student> findallstudents() throws SQLException {
		 List<Student> students = new ArrayList<>();

		   
	 	OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
	 	ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:ACAD111");
//	 	Connection conn = ds.getConnection("asutari1", "as979752");
	 	Connection conn = ds.getConnection("vborra", "Deadpool2210");

	 	try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM Students");
	 	     ResultSet resultSet = statement.executeQuery()) {
	 	    while (resultSet.next()) {
	 	        String bNumber = resultSet.getString("B#");
	 	        String firstName = resultSet.getString("first_name");
	 	        String lastName = resultSet.getString("last_name");
	 	        String level = resultSet.getString("st_level");
	 	        Double gpa = resultSet.getDouble("gpa");
	 	        String email = resultSet.getString("email");
	 	        Date birthDate = resultSet.getDate("bdate");

	 	        Student student = new Student(bNumber, firstName, lastName, level, gpa, email, birthDate);
	 	        System.out.println(student.toString());
	 	        students.add(student);
	 	    }
	 	} catch (SQLException e) {
	 	    // handle exception
	 	    System.out.println("Sorry, Could not find students, please try after some time;");
	 	} finally {
	 	    conn.close();
	 	}

	 return students;
	}
	@Override
	public String deletestudents(String bNumber) throws SQLException {
	    OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
	    ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:ACAD111");
	    Connection conn = ds.getConnection("vborra", "Deadpool2210");
//	    Connection conn = ds.getConnection("asutari1", "as979752");

	    try (PreparedStatement statement = conn.prepareStatement("DELETE FROM students WHERE B# like ?");
	         ){
	        statement.setString(1, bNumber);
	      
	        System.out.println("query for deletestudents : " + statement.toString());
	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted == 0) {
	            System.out.println("No student with B# " + bNumber + " found in the database.");
	        } else {
	            System.out.println("Student with B# " + bNumber + " has been deleted from the database.");
	        }
	    } catch (SQLException e) {

	    	System.out.println(e.getMessage());
	        // handle exception
	        System.out.println("Sorry, could not delete student, please try after some time.");
	    	return e.getMessage();
	    	} finally {
	        conn.close();
	    }
		return bNumber;
	
	}


	
}

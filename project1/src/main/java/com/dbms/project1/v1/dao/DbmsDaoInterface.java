package com.dbms.project1.v1.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbms.project1.v1.model.Student;

@Repository
public interface DbmsDaoInterface {
	public List<Student> findallstudents() throws SQLException;
	public String deletestudents(String bNumber) throws SQLException;

}

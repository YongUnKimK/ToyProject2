package edu.kh.toyProject.dao;

import java.sql.Connection;

import java.util.List;

import edu.kh.toyProject.dto.Student;

public interface ToyProjectDAO {

	List<Student> toyProjectFullView(Connection conn)  throws Exception;

}
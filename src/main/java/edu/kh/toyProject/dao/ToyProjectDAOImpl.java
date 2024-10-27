package edu.kh.toyProject.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.toyProject.dto.Student;
import static edu.kh.toyProject.common.JDBCTemplate.*;

public class ToyProjectDAOImpl implements ToyProjectDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public ToyProjectDAOImpl() {

		try {

			String filePath = ToyProjectDAOImpl.class.getResource("/xml/sql.xml").getPath();

			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();

		}
	}

	@Override
	public List<Student> toyProjectFullView(Connection conn) throws Exception {
		
		List<Student> toyProject = new ArrayList<Student>();

		try {
			String sql = prop.getProperty("toyProjectFullView");

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// Builder 패턴 : 특정 값으로 초기화된 객체를 쉽게 만드는 방법
				// -> Lombok에서 제공하는 @Builder 어노테이션을 DTO에 작성해두면
				// 사용 가능한 패턴
				
				Student student = Student.builder()
						.stuNo(rs.getInt("STU_NO"))
						.stuName(rs.getString("STU_NAME"))
						.stuAge(rs.getInt("STU_AGE"))
						.gender("GENDER")
						.score("SCORE").build();

				toyProject.add(student);

			}

		} finally {
			close(rs);
			close(stmt);
		}

		return toyProject;
	}

		
	}


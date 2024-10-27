package edu.kh.toyProject.service;
import static edu.kh.toyProject.common.JDBCTemplate.getConnection;


import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.toyProject.dao.ToyProjectDAO;
import edu.kh.toyProject.dao.ToyProjectDAOImpl;
import edu.kh.toyProject.dto.Student;

public class ToyProjectServiceImpl implements ToyProjectService {
	
	private ToyProjectDAO dao = new ToyProjectDAOImpl();
	
	@Override
	public Map<String, Object> toyProjectFullView()  throws Exception{
		// 커넥션 생성
		Connection conn = getConnection();
		
		// 할 일 목록 얻어오기 (dao 호출 및 반환 받기)
		List<Student> toyProject = dao.toyProjectFullView(conn);
		
		
		// 메서드에서 반환은 하나의 값 또는 객체밖에 할 수 없기 때문에
		// Map 이라는 컬렉션을 이용해 여러 값을 한번에 묶어서 반환
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("toyProject", toyProject);
		
				
				
		return map;
	}

}

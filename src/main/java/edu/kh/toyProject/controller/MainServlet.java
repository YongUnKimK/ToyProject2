package edu.kh.toyProject.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.toyProject.dto.Student;
import edu.kh.toyProject.service.ToyProjectService;
import edu.kh.toyProject.service.ToyProjectServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		try {
			ToyProjectService service = new ToyProjectServiceImpl();
			
			Map<String, Object> map = service.toyProjectFullView();
			
			List<Student> toyProject = (List<Student>)map.get("toyProject");
			
			req.setAttribute("toyProject", toyProject);
		
			String path = "/WEB-INF/views/main.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}

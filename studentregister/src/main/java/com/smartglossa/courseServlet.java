package com.smartglossa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public courseServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation=request.getParameter("operation");
		if (operation.equals("add")) {
	    JSONObject res = new JSONObject();
		int courseId=Integer.parseInt(request.getParameter("courseId"));
		String name = request.getParameter("name");
		String duration = request.getParameter("duration");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
					"root");
			Statement statement = connection.createStatement();
			String query="insert into course(courseId,name,duration)values("+courseId+",'"
					+ name+ "','" + duration+ "')";
			statement.execute(query);
			res.put("status", "1");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		response.getWriter().println(res);
	}
	}

}
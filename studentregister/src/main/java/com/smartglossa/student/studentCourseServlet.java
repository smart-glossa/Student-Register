package com.smartglossa.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


public class studentCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public studentCourseServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operation=request.getParameter("operation");
		if (operation.equals("add")) {
	    JSONObject res = new JSONObject();
	    int sId=Integer.parseInt(request.getParameter("sId"));
		int courseId=Integer.parseInt(request.getParameter("courseId"));
				try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
					"root");
			Statement statement = connection.createStatement();
			String query="insert into studentcourse( sId,courseId)values("+sId+","
					+ courseId+ ")";
			statement.execute(query);
			res.put("status", "1");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		response.getWriter().println(res);
	}else if (operation.equals("getAll")) {
		JSONArray  re = new JSONArray();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			Statement statement = connection.createStatement();
			String query = "select * from studentcourse";
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()){
				JSONObject result12 = new JSONObject();
				result12.put("sId",rs.getString(1));
				result12.put("courseId", rs.getString(2));
			
				re.put(result12);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		response.getWriter().print(re);
		
	}
		
	}

}

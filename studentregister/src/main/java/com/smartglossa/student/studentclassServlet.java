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

public class studentclassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public studentclassServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject result = new JSONObject();
		String operation = request.getParameter("operation");
		if (operation.equals("student")) {
			int classId = Integer.parseInt(request.getParameter("classId"));
			int sid=Integer.parseInt(request.getParameter("sId"));
			String className = request.getParameter("className");
			String Duration = request.getParameter("Duration");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "insert into studentclass (classId,sId,className,Duration)values(" + classId + ","+sid+",'"
						+ className + "','" + Duration + "')";
				statement.execute(query);
				result.put("status", "1");
			} catch (Exception e) {

				e.printStackTrace();
			}
			response.getWriter().println(result);
		}
		else if(operation.equals("getAll")){
			JSONArray set = new JSONArray();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement statement = conn.createStatement();
				String query = "select * from studentclass";
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()){
					JSONObject result1 = new JSONObject();
					result1.put("classId",rs.getInt(1));
					result1.put("sId", rs.getInt(2));
					result1.put("className", rs.getString(3));
					result1.put("Duration", rs.getString(4));
					
					set.put(result1);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			response.getWriter().println(set);
		}

	}
}

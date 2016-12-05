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


public class attendencsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public attendencsServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String operation=request.getParameter("operation");
		if (operation.equals("add")) {
			JSONObject result = new JSONObject();
		int aId=Integer.parseInt(request.getParameter("aId"));
		String classId = request.getParameter("classId");
		String date = request.getParameter("date");
		String attendence = request.getParameter("attendence");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
					"root");
			Statement statement = connection.createStatement();
			String query="insert into attendence(aId,classId,date,attendence) values("+aId+",'"
					+ classId + "','" + date + "','"+attendence+"')";
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
				String query = "select * from attendence";
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()){
					JSONObject result1 = new JSONObject();
					result1.put("aId",rs.getInt("aId"));
					result1.put("classId", rs.getInt("classId"));
					result1.put("date", rs.getString("date"));
					result1.put("attendence", rs.getString("attendence"));
					set.put(result1);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			response.getWriter().println(set);
		}

}
}
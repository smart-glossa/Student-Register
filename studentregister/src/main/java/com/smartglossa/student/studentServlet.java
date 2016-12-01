package com.smartglossa.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public studentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     JSONObject  object= new JSONObject();
		String operation = request.getParameter("operation");
		if (operation.equals("register")) {
		
			int sId = Integer.parseInt(request.getParameter("sId"));
			String studentName = request.getParameter("studentName");
			String Gender = request.getParameter("Gender");
			String Address = request.getParameter("Address");
			String contactNumber = request.getParameter("contactNumber");
			String joinDate = request.getParameter("joinDate");
			String Dob = request.getParameter("DOB");
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
					Statement statement = conn.createStatement();
					String query = "insert into studentdetails(sId,studentName,Address,contactNumber,Gender,joinDate,DOB)values("
							+ sId + ",'" + studentName + "','" + Gender + "','" + Address + "','" + contactNumber + "','" + joinDate + "','" + Dob+"')";
					statement.execute(query);
					object.put("status", "1");
				} catch (Exception e) {
                  		
					object.put("status", "0");
					e.printStackTrace();
				}
 
				response.getWriter().println(object);

		}
		else if(operation.equals("getAll")){
			JSONArray set = new JSONArray();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement statement = conn.createStatement();
				String query = "select * from studentdetails";
				ResultSet result = statement.executeQuery(query);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			response.getWriter().println(set);
		}
	}
}


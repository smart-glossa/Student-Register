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
import org.omg.CORBA.Request;

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
				while (result.next()) {
					JSONObject obj = new JSONObject();
					obj.put("sId", result.getInt("sId"));
					obj.put("studentName", result.getString("studentName"));
					obj.put("Address", result.getString("Address"));
					obj.put("contactNumber", result.getString("contactNumber"));
					obj.put("Gender", result.getString("Gender"));
					obj.put("DOB", result.getString("DOB"));
					obj.put("joinDate", result.getString("joinDate"));

					set.put(obj);
				}

			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			response.getWriter().println(set);
		}
		else if (operation.equals("getone")) {
			int sId = Integer.parseInt(request.getParameter("sId"));
			JSONObject ob = new JSONObject();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement statement = conn.createStatement();
				String query = "select * from  studentdetails where sId=" + sId;
				ResultSet set = statement.executeQuery(query);
				if (set.next()) {
					ob.put("studentName", set.getString("studentName"));
					ob.put("Address", set.getString("Address"));
					ob.put("contactNumber", set.getString("contactNumber"));
					ob.put("Gender", set.getString("Gender"));
					ob.put("DOB", set.getString("DOB"));
					ob.put("joinDate", set.getString("joinDate"));
				}

			} catch (Exception e) {
			

				e.printStackTrace();
			}
			response.getWriter().println(ob);
		}

	}
}	


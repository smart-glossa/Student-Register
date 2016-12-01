package com.smartglossa.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		JSONObject object = new JSONObject();
		String operation = request.getParameter("operation");
		if (operation.equals("register")) {
			int RollNo = Integer.parseInt(request.getParameter("RollNo"));
			String Name = request.getParameter("Name");
			int Age = Integer.parseInt(request.getParameter("Age"));
			String Gender = request.getParameter("Gender");
			String MotherName = request.getParameter("MotherName");
			String FatherName = request.getParameter("FatherName");
			String Address = request.getParameter("Address");
			int MobileNumber = Integer.parseInt(request.getParameter("MobileNumber"));
			String BloodGroup = request.getParameter("BloodGroup");
			int JoinDate = Integer.parseInt(request.getParameter("JoinDate"));
			String JoinClass = request.getParameter("JoinClass");
			int Dob = Integer.parseInt(request.getParameter("DOB"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
				Statement statement = conn.createStatement();
				String query = "insert into studentdetails(RollNo,Name,Age,Gender,MotherName,FatherName,Address,MobileNumber,BloodGroup,JoinDate,JoinClass,DOB)values("
						+ RollNo + ",'" + Name + "'," + Age + ",'" + Gender + "','" + MotherName + "','" + FatherName
						+ "','" + Address + "'," + MobileNumber + ",'" + BloodGroup + "'," + JoinDate + ",'" + JoinClass
						+ "'," + Dob + ")";
				statement.execute(query);
				object.put("status", "1");
			} catch (Exception e) {

				e.printStackTrace();

			}
			response.getWriter().println(object);

		}

	}
}

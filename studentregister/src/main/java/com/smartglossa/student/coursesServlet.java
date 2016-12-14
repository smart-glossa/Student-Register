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

public class coursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public coursesServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");
		if (operation.equals("add")) {
			JSONObject res = new JSONObject();
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			String name = request.getParameter("name");
			String duration = request.getParameter("duration");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "insert into course(courseId,name,duration)values(" + courseId + ",'" + name + "','"
						+ duration + "')";
				statement.execute(query);
				res.put("status", "1");

			} catch (Exception e) {

				e.printStackTrace();
			}
			response.getWriter().println(res);
		} else if (operation.equals("getAll")) {
			JSONArray re = new JSONArray();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "select * from course";
				ResultSet rs = statement.executeQuery(query);

				while (rs.next()) {
					JSONObject result1 = new JSONObject();
					result1.put("courseId", rs.getInt(1));
					result1.put("name", rs.getString(2));
					result1.put("duration", rs.getString(3));
					re.put(result1);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			response.getWriter().print(re);

		}

	}

}

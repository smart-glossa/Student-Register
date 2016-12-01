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
		if (operation.equals("Class")) {
			int classId = Integer.parseInt(request.getParameter("classId"));
			String className = request.getParameter("className");
			String Duration = request.getParameter("Duration");
			int sId=Integer.parseInt(request.getParameter("sId"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root",
						"root");
				Statement statement = connection.createStatement();
				String query = "insert into studentclass (classId,className,Duration,sId)values(" + classId + ",'"
						+ className + "','" + Duration + "',"+sId+")";
				statement.execute(query);
				result.put("status", "1");
			} catch (Exception e) {

				e.printStackTrace();
			}
			response.getWriter().println(result);
		}

	}
}

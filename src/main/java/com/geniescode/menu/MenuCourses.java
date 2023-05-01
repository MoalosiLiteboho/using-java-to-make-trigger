package com.geniescode.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MenuCourses", value = "/menu-course")
public class MenuCourses extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<h4>Course</h4>");
        out.println("<div class=\"table-panel\">");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>#</th>");
        out.println("<th>Course Name</th>");
        out.println("<th>Instructor Name</th>");
        out.println("<th>Description</th>");
        out.println("<th>Type</th>");
        out.println("<th>Creation Date</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");


        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }
}

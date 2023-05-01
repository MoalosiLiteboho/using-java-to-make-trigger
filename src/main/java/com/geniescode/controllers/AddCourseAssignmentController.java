package com.geniescode.controllers;

import com.geniescode.id.IdGenerator;
import com.geniescode.models.Assignment;
import com.geniescode.services.CourseService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "addCourseAssignmentController", value = "/add-course-assignment")
public class AddCourseAssignmentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CourseService service = new CourseService();
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String assignmentName = request.getParameter("name");
        LocalDate deadline = LocalDate.parse(request.getParameter("deadline"));

        service.addCourseAssignment(new Assignment(
                new IdGenerator().apply(service.getAllAssignmentIds()),
                courseId,
                assignmentName,
                deadline
        ));
        response.sendRedirect("Dashboard.jsp");
    }
}

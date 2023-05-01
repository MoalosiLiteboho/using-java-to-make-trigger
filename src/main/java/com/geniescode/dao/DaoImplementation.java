package com.geniescode.dao;

import com.geniescode.database.CloseDatabaseConnection;
import com.geniescode.database.GetDatabaseConnection;
import com.geniescode.models.Assignment;
import com.geniescode.models.Course;
import com.geniescode.models.Grades;
import com.geniescode.models.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoImplementation implements Dao {
    private final CloseDatabaseConnection closeDatabaseConnection;
    private final GetDatabaseConnection getDatabaseConnection;

    public DaoImplementation() {
        closeDatabaseConnection = new CloseDatabaseConnection();
        getDatabaseConnection = new GetDatabaseConnection();
    }


    public List<Course> findAllCourses() {
        List<Course> courseList = new ArrayList<>();
        Connection connection = getDatabaseConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from Triggers.Course");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                courseList.add(new Course(
                        result.getInt("Id"),
                        result.getString("Name"),
                        LocalDate.parse(result.getString("Retire"))
                ));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }finally {
            closeDatabaseConnection.accept(connection);
        }
        return courseList;
    }

    public List<Student> findAllStudents() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = getDatabaseConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from Triggers.Students");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                studentList.add(new Student(
                        result.getInt("Id"),
                        result.getInt("CourseId"),
                        result.getString("Name"),
                        result.getString("Surname")
                ));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }finally {
            closeDatabaseConnection.accept(connection);
        }
        return studentList;
    }

    public List<Grades> findAllGrades() {
        List<Grades> gradesList = new ArrayList<>();
        Connection connection = getDatabaseConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from Triggers.StudentGrades");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                gradesList.add(new Grades(
                        result.getInt("Id"),
                        result.getInt("StudentId"),
                        result.getString("Grade"),
                        result.getInt("Mark"),
                        result.getBoolean("Submitted")
                ));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }finally {
            closeDatabaseConnection.accept(connection);
        }
        return gradesList;
    }

    public List<Assignment> findAllAssignment() {
        List<Assignment> assignmentList = new ArrayList<>();
        Connection connection = getDatabaseConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from Triggers.CourseAssignment");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                assignmentList.add(new Assignment(
                        result.getInt("Id"),
                        result.getInt("CourseId"),
                        result.getString("Name"),
                        LocalDate.parse(result.getString("Deadline"))
                ));
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }finally {
            closeDatabaseConnection.accept(connection);
        }
        return assignmentList;
    }

    public void addAssignment(Assignment assignment) {
        Connection connection = getDatabaseConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into Triggers.CourseAssignment(CourseId, Name, Deadline) values (?, ?, ?)");
            statement.setInt(1, assignment.courseId());
            statement.setString(2, assignment.name());
            statement.setDate(3, Date.valueOf(assignment.deadline()));
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeDatabaseConnection.accept(connection);
        }
    }

    public void addAssignmentsOnStudentGrades(Grades grades) {
        Connection connection = getDatabaseConnection.get();

        try {
            PreparedStatement statement = connection.prepareStatement("insert into Triggers.StudentGrades(StudentId, Grade, Mark) values (?, ?, ?)");
            statement.setInt(1, grades.studentId());
            statement.setString(2, grades.grade());
            statement.setInt(3, grades.mark());
            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            closeDatabaseConnection.accept(connection);
        }
    }
}

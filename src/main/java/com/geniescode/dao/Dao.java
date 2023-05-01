package com.geniescode.dao;

import com.geniescode.models.Assignment;
import com.geniescode.models.Course;
import com.geniescode.models.Grades;
import com.geniescode.models.Student;

import java.util.List;

public interface Dao {
    List<Course> findAllCourses();
    List<Student> findAllStudents();
    List<Grades> findAllGrades();
    List<Assignment> findAllAssignment();
    void addAssignment(Assignment assignment);
    void addAssignmentsOnStudentGrades(Grades grades);
}

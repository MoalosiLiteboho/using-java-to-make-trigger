package com.geniescode.services;

import com.geniescode.dao.DaoImplementation;
import com.geniescode.models.Grades;
import com.geniescode.models.Student;

import java.util.List;

public class StudentService {
    private final DaoImplementation dao;

    public StudentService() {
        dao = new DaoImplementation();
    }

    public List<Student> getAllStudents() {
        return dao.findAllStudents();
    }

    public List<Integer> getStudentIdByCourseId(int courseId) {
        return getAllStudents().stream()
                .filter(student -> student.courseId() == courseId)
                .map(Student::id)
                .toList();
    }
    public List<Grades> getAllStudentGrades() {
        return dao.findAllGrades();
    }

    public List<Integer> getStudentGradesIdList() {
        return getAllStudentGrades().stream()
                .map(Grades::id)
                .toList();
    }
}

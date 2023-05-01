package com.geniescode.services;

import com.geniescode.dao.DaoImplementation;
import com.geniescode.id.IdGenerator;
import com.geniescode.models.Assignment;
import com.geniescode.models.Grades;

import java.util.List;

public class CourseService {
    private final DaoImplementation dao;
    private final StudentService studentService;
    private final IdGenerator idGenerator;

    public CourseService() {
        dao = new DaoImplementation();
        studentService = new StudentService();
        idGenerator = new IdGenerator();
    }

    public List<Assignment> getAssignmentList() {
        return dao.findAllAssignment();
    }

    public List<Integer> getAllAssignmentIds() {
        return getAssignmentList().stream()
                .map(Assignment::id)
                .toList();
    }

    public void addCourseAssignment(Assignment assignment) {
        dao.addAssignment(assignment);

        studentService.getStudentIdByCourseId(assignment.courseId())
                .forEach(studentId -> dao.addAssignmentsOnStudentGrades(
                        new Grades(
                                idGenerator.apply(studentService.getStudentGradesIdList()),
                                studentId,
                                "Null",
                                0,
                                false
                        )
                ));
    }
}

package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StudentService {

    Student addNewStudent(Student newStudent);
    Iterable<Student> getAllStudent();
    Page<Student> getAllStudentsPaged(int pageNo);
    Optional <Student> getStudentById(Long studentId);
    void deleteStudentById(Long studentId);
    Student updateStudent(Student student);
}

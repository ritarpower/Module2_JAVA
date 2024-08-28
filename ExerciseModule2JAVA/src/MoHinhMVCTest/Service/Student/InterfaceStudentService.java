package MoHinhMVCTest.Service.Student;

import MoHinhMVCTest.Model.Student;

import java.util.List;

public interface InterfaceStudentService {
    List<Student> findAll();

    void addStudent(Student student);

    void removeStudent(String code);

    Student findByCode(String code);

    void updateStudent(Student student);
}

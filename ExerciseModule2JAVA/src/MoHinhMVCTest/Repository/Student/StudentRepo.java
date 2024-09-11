package MoHinhMVCTest.Repository.Student;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.common.IOStudentFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements InterfaceStudentRepo {

    @Override
    public List<Student> findAll() {
        return IOStudentFile.readFromStudentFile();
    }

    @Override
    public void addStudent(Student student) {
        IOStudentFile.writeToStudentFile(student);
    }

    @Override
    public void updateStudent(Student student) {
        IOStudentFile.updateStudent(student);
    }

    @Override
    public Student findStudentByCode(String code) {
        return IOStudentFile.findStudentByCode(code);
    }

    @Override
    public void deleteStudent(Student student) {
        IOStudentFile.deleteStudent(student);
    }
}

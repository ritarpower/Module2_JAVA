package MoHinhMVCTest.Service.Student;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.Repository.Student.InterfaceStudentRepo;
import MoHinhMVCTest.Repository.Student.StudentRepo;

import java.util.List;
import java.util.Scanner;

public class StudentService implements InterfaceStudentService {
    private static final Scanner sc = new Scanner(System.in);
    private InterfaceStudentRepo studentRepo = new StudentRepo();

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepo.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }

    @Override
    public Student findStudentByCode(String code) {
        return studentRepo.findStudentByCode(code);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepo.deleteStudent(student);
    }


}

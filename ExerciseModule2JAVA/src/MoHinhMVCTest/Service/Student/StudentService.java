package MoHinhMVCTest.Service.Student;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.Repository.Student.InterfaceStudentRepo;
import MoHinhMVCTest.Repository.Student.StudentRepo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements InterfaceStudentService {
    private static final Scanner sc = new Scanner(System.in);
    private InterfaceStudentRepo interfaceStudentRepo = new StudentRepo();

    @Override
    public List<Student> findAll() {
        return interfaceStudentRepo.findAll();
    }

    @Override
    public void addStudent(Student student) {
        interfaceStudentRepo.addStudent(student);
    }

    @Override
    public void removeStudent(String code) {
        interfaceStudentRepo.removeStudent(code);
    }

    @Override
    public Student findByCode(String code) {
        return interfaceStudentRepo.findByCode(code);
    }

    @Override
    public void updateStudent(Student student) {
        interfaceStudentRepo.updateStudent(student);
    }


}

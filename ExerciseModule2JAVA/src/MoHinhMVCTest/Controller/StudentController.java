package MoHinhMVCTest.Controller;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.Service.Student.InterfaceStudentService;
import MoHinhMVCTest.Service.Student.StudentService;

public class StudentController {
    private InterfaceStudentService interfaceStudentService = new StudentService();

    public void getListStudent() {
        Student[] students = interfaceStudentService.findAll();
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            } else {
                return;
            }
        }
    }
}

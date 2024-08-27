package MoHinhMVCTest.Service.Student;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.Repository.Student.InterfaceStudentRepo;
import MoHinhMVCTest.Repository.Student.StudentRepo;

public class StudentService  implements InterfaceStudentService{
    private InterfaceStudentRepo interfaceStudentRepo = new StudentRepo();

    @Override
    public Student[] findAll() {
        return interfaceStudentRepo.findAll();
    }
}

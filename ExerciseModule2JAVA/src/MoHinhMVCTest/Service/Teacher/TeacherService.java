package MoHinhMVCTest.Service.Teacher;

import MoHinhMVCTest.Model.Teacher;
import MoHinhMVCTest.Repository.Teacher.InterfaceTeacherRepo;
import MoHinhMVCTest.Repository.Teacher.TeacherRepo;

import java.util.Collections;
import java.util.List;

public class TeacherService implements InterfaceTeacherService {
    private InterfaceTeacherRepo interfaceTeacherRepo = new TeacherRepo();

    @Override
    public List<Teacher> findAll() {
        return interfaceTeacherRepo.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        interfaceTeacherRepo.add(teacher);
    }

    @Override
    public void removeTeacher(String code) {
        interfaceTeacherRepo.removeTeacher(code);
    }

    @Override
    public Teacher findByCode(String code) {
        return interfaceTeacherRepo.findByCode(code);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        interfaceTeacherRepo.updateTeacher(teacher);
    }
}

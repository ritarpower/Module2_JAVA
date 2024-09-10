package MoHinhMVCTest.Service.Teacher;

import MoHinhMVCTest.Model.Teacher;
import MoHinhMVCTest.Repository.Teacher.InterfaceTeacherRepo;
import MoHinhMVCTest.Repository.Teacher.TeacherRepo;

import java.util.List;

public class TeacherService implements InterfaceTeacherService {
    private InterfaceTeacherRepo teacherRepo = new TeacherRepo();

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepo.addTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepo.deleteTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByCode(String code) {
        return teacherRepo.findTeacherByCode(code);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepo.updateTeacher(teacher);
    }
}

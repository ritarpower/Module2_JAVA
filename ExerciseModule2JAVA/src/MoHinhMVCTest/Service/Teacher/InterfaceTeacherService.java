package MoHinhMVCTest.Service.Teacher;

import MoHinhMVCTest.Model.Teacher;

import java.util.List;

public interface InterfaceTeacherService {
    List<Teacher> findAll();

    void addTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher findTeacherByCode(String code);

    void updateTeacher(Teacher teacher);
}

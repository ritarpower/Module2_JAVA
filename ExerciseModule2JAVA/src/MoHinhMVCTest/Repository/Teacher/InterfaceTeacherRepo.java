package MoHinhMVCTest.Repository.Teacher;

import MoHinhMVCTest.Model.Teacher;

import java.util.List;

public interface InterfaceTeacherRepo {
    List<Teacher> findAll();

    void add(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher findTeacherByCode(String code);

    void updateTeacher(Teacher teacher);
}

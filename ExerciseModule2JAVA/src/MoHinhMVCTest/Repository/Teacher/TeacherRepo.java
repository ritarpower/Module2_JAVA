package MoHinhMVCTest.Repository.Teacher;

import MoHinhMVCTest.Model.Teacher;
import MoHinhMVCTest.common.IOTeacherFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements InterfaceTeacherRepo {

    @Override
    public List<Teacher> findAll() {
        return IOTeacherFile.readTeacherFile();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        IOTeacherFile.writeTeacherFile(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        IOTeacherFile.deleteTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByCode(String code) {
        return IOTeacherFile.findTeacherByCode(code);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        IOTeacherFile.updateTeacher(teacher);
    }
}

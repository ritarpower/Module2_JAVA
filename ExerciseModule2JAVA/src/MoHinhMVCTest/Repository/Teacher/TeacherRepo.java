package MoHinhMVCTest.Repository.Teacher;

import MoHinhMVCTest.Model.Teacher;
import MoHinhMVCTest.common.IOTeacherFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements InterfaceTeacherRepo {
    private static final List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher("GV-001", "Thanh Công", LocalDate.parse("1992-01-01"), "cong.nguyen@gmail.com", 1000));
        teachers.add(new Teacher("GV-002", "Đức Phương", LocalDate.parse("1999-01-01"), "phuong.tran@gmail.com", 900));
    }


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

package MoHinhMVCTest.Repository.Teacher;

import MoHinhMVCTest.Model.Teacher;

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
        return teachers;
    }

    @Override
    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    @Override
    public Teacher findTeacherByCode(String code) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getCode().equals(code)) {
                return teachers.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            teachers.set(i, teacher);
            return;
        }
    }

}

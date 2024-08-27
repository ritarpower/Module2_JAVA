package MoHinhMVCTest.Repository.Student;

import MoHinhMVCTest.Model.Student;

import java.time.LocalDate;

public class StudentRepo implements InterfaceStudentRepo{
    private static Student[] students;
    static {
        students = new Student[10];
        students[0]= new Student("Phúc", LocalDate.parse("1999-04-12"),"123","phuc.cao@gmail.com","C0524M1");
        students[1]= new Student("Hoàng", LocalDate.parse("2005-12-12"),"999","hoang.nguyen@gmail.com","C0524M1");
    }

    @Override
    public Student[] findAll() {
        return students;
    }
}

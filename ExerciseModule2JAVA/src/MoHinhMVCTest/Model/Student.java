package MoHinhMVCTest.Model;

import java.time.LocalDate;

public class Student extends Person {
    private String classCode;

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Student(String code, String name, LocalDate birthDate, String email, String classCode) {
        super(code, name, birthDate, email);
        this.classCode = classCode;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "," + " classCode='" + classCode + '\'' +
                '}';
    }
}

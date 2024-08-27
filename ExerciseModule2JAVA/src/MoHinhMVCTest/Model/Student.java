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

    public Student(String name, LocalDate birthDate, String code, String email, String classCode) {
        super(name, birthDate, code, email);
        this.classCode = classCode;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "," + " salary='" + classCode + '\'' +
                '}';
    }
}

package MoHinhMVCTest.common;

import MoHinhMVCTest.Model.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOStudentFile {
    private static final String STUDENT_PATH = "src/MoHinhMVCTest/data/student.csv";

    public static void writeToStudentFile(Student student) {
        try {
            FileWriter fileWriter = new FileWriter(STUDENT_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = student.getCode() + "," + student.getName() + "," + student.getBirthDate() + "," +
                    student.getEmail() + "," + student.getClassCode();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readFromStudentFile() {
        List<Student> students = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(STUDENT_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) {
                    break;
                }
                String[] dataArray = data.split(",");
                Student student = new Student(dataArray[0], dataArray[1], LocalDate.parse(dataArray[2]), dataArray[3], dataArray[4]);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static Student findStudentByCode(String code) {
        List<Student> studentList = readFromStudentFile();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                return studentList.get(i);
            }
        }
        return null;
    }
    
    public static void updateStudent(Student student) {
        List<Student> studentList = readFromStudentFile();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(student.getCode())) {
                studentList.set(i, student);
                writeListToStudentFile(studentList);
                return;
            }
        }
    }

    public static void writeListToStudentFile(List<Student> students) {
        try {
            FileWriter fileWriter = new FileWriter(STUDENT_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < students.size(); i++) {
                bufferedWriter.write(students.get(i).getCode() + "," + students.get(i).getName() + "," + students.get(i).getBirthDate() + "," +
                        students.get(i).getEmail() + "," + students.get(i).getClassCode());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteStudent(Student student) {
        List<Student> studentList = readFromStudentFile();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(student.getCode())) {
                studentList.remove(i);
                writeListToStudentFile(studentList);
                return;
            }
        }
    }
}

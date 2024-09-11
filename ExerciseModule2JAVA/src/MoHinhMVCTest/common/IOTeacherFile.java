package MoHinhMVCTest.common;

import MoHinhMVCTest.Model.Student;
import MoHinhMVCTest.Model.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOTeacherFile {
    private static final String TEACHER_FILE = "src/MoHinhMVCTest/data/teacher.csv";

    public static void writeTeacherFile(Teacher teacher) {
        try {
            FileWriter fileWriter = new FileWriter(TEACHER_FILE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = teacher.getCode() + "," + teacher.getName() + "," + teacher.getBirthDate() + "," +
                    teacher.getEmail() + "," + teacher.getSalary();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Teacher> readTeacherFile() {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(TEACHER_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) {
                    break;
                }
                String[] arrayTeacher = data.split(",");
                Teacher teacher = new Teacher(arrayTeacher[0], arrayTeacher[1], LocalDate.parse(arrayTeacher[2]), arrayTeacher[3], Double.parseDouble(arrayTeacher[4]));
                teacherList.add(teacher);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teacherList;
    }

    public static void writeListToTeacherFile(List<Teacher> teachers) {
        try {
            FileWriter fileWriter = new FileWriter(TEACHER_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < teachers.size(); i++) {
                bufferedWriter.write(teachers.get(i).getCode() + "," + teachers.get(i).getName() + "," + teachers.get(i).getBirthDate() + "," +
                        teachers.get(i).getEmail() + "," + teachers.get(i).getSalary());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Teacher findTeacherByCode(String code) {
        List<Teacher> teachers = readTeacherFile();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getCode().equals(code)) {
                return teachers.get(i);
            }
        }
        return null;
    }

    public static void updateTeacher(Teacher teacher) {
        List<Teacher> teacherList = readTeacherFile();
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(teacher.getCode())) {
                teacherList.set(i, teacher);
                writeListToTeacherFile(teacherList);
                return;
            }
        }
    }

    public static void deleteTeacher(Teacher teacher) {
        List<Teacher> teachers = readTeacherFile();
        for (int i = 0; i < teachers.size(); i++) {
            if (teacher.getCode().equals(teachers.get(i).getCode())) {
                teachers.remove(i);
                writeListToTeacherFile(teachers);
                return;
            }
        }
    }
}

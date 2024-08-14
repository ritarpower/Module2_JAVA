import LoopAndArray.GopMang.MergedArraysTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    String name;
    int age;

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Test test = new Test("Phuc",25);
        System.out.println(test);
    }
}


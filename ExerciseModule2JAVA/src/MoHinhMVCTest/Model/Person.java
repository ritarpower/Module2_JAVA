package MoHinhMVCTest.Model;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;
    private String code;
    private String email;

    public Person(String name, LocalDate birthDate, String code, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.code = code;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", code='" + code + '\'' +
                ", email='" + email + '\'';
    }
}

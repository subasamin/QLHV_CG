package QLHV.model;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;

    public Person(String name, LocalDate birthday, String email, String phoneNumber) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract void say();

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", dateOfBirth = " + birthday +
                ", email = '" + email + '\'' +
                ", phoneNumber = '" + phoneNumber + '\'' +
                '}';
    }

}

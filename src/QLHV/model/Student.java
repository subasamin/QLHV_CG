package QLHV.model;

import java.time.LocalDate;

public class Student extends Person {
    private int id;
    private String className;

    public Student(String name, LocalDate dateOfBirth, String email, String phoneNumber, int id, String className) {
        super(name, dateOfBirth, email, phoneNumber);
        this.id = id;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public void say() {
        System.out.println("Student say: Hello");
    }

    @Override
    public String toString() {
        return "Student: " +  super.toString()+
                "id = " + id +
                ", className = '" + className + '\''
                 ;
    }
}

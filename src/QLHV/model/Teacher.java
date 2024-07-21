package QLHV.model;

import java.time.LocalDate;

public class Teacher extends Person {
    private int id;
    private String position;

    public Teacher(int id, String name, LocalDate dateOfBirth, String email, String phoneNumber, String position) {
        super(name, dateOfBirth, email, phoneNumber);
        this.id = id;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void say() {
        System.out.println("I am a teacher");
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString()+
                "id=" + id +
                ", className='" + position + '\'' +
                '}' ;
    }
}

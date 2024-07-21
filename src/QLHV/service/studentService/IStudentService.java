package QLHV.service.studentService;

import QLHV.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    void add(Student student);
    void update(Student student);
    boolean delete(int id);
    int getNextId();
}
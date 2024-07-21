package QLHV.repository.studentRepository;

import QLHV.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void add(Student student);

    boolean exists(String id);

    boolean exists(int id);

    void update(Student student);

    void delete(int id);

    Student findById(int id);
}

package QLHV.service.teacherService;

import QLHV.model.Teacher;

import java.util.LinkedList;

public interface ITeacherService {
    LinkedList<Teacher> findAll();
    void add(Teacher teacher);
    boolean exists(int id);
    void edit(Teacher teacher);
    void delete(int id);
    Teacher findById(int id);
}

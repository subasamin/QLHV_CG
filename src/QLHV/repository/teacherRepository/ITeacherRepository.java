package QLHV.repository.teacherRepository;

import QLHV.model.Teacher;

import java.util.List;

public interface ITeacherRepository {
    List<Teacher> findAll();

    void add(Teacher teacher);

    Teacher delete(int id);

    void update(int index, Teacher teacher);

    boolean isEmpty(int id);

    int getIndex(int id);

    void updateData();
}

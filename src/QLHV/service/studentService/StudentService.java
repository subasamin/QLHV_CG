package QLHV.service.studentService;

import QLHV.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    private Map<Integer, Student> studentMap = new HashMap<>();
    private int currentId = 1;

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void add(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public boolean delete(int id) {
        return studentMap.remove(id) != null;
    }

    @Override
    public int getNextId() {
        return currentId++;
    }
}

package QLHV.service.teacherService;

import QLHV.model.Teacher;
import QLHV.repository.teacherRepository.ITeacherRepository;

import java.util.LinkedList;

public class TeacherService implements ITeacherService {
    private ITeacherRepository teacherRepository;

    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void add(Teacher teacher) {
        if (teacher != null) {
            teacherRepository.add(teacher);
        } else {
            throw new IllegalArgumentException("Teacher cannot be null");
        }
    }

    @Override
    public LinkedList<Teacher> findAll() {
        return (LinkedList<Teacher>) teacherRepository.findAll();
    }

    @Override
    public boolean exists(int id) {
        return !teacherRepository.isEmpty(id);
    }

    @Override
    public void edit(Teacher teacher) {
        if (teacher != null) {
            int id = teacher.getId();
            if (exists(id)) {
                int index = teacherRepository.getIndex(id);
                teacherRepository.update(index, teacher);
            } else {
                throw new IllegalArgumentException("Teacher with ID " + id + " does not exist.");
            }
        } else {
            throw new IllegalArgumentException("Teacher cannot be null");
        }
    }

    @Override
    public void delete(int id) {
        if (exists(id)) {
            teacherRepository.delete(id);
        } else {
            throw new IllegalArgumentException("Teacher with ID " + id + " does not exist.");
        }
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findAll().stream()
                .filter(teacher -> teacher.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

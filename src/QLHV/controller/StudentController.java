package QLHV.controller;

import QLHV.model.Student;
import QLHV.service.studentService.IStudentService;
import QLHV.service.studentService.StudentService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private static IStudentService iStudentService = new StudentService();
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter Date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void displayStudent() {
        int choice;
        do {
            System.out.println("QUẢN LÝ HỌC VIÊN\n" +
                    "1. Hiển thị học viên\n" +
                    "2. Thêm mới học viên\n" +
                    "3. Chỉnh sửa thông tin\n" +
                    "4. Xoá học viên\n" +
                    "5. Trở về trang chủ\n" +
                    "Nhập lựa chọn của bạn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (true);
    }

    public static void displayStudents() {
        List<Student> students = iStudentService.findAll();
        if (students.isEmpty()) {
            System.out.println("Danh sách học viên trống.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void addStudent() {
        System.out.println("Nhập tên học sinh:");
        String name = scanner.nextLine();
        LocalDate birthday = promptForDate("Nhập ngày tháng năm sinh học viên (định dạng: yyyy-MM-dd):");
        System.out.println("Nhập email học viên:");
        String email = scanner.nextLine();
        System.out.println("Nhập số điện thoại học viên:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập lớp của học viên:");
        String className = scanner.nextLine();

        int id = iStudentService.getNextId();

        Student student = new Student(name, birthday, email, phoneNumber, id, className);
        iStudentService.add(student);

        System.out.println("Thêm học viên thành công với ID: " + id);
    }

    public static void updateStudent() {
        System.out.println("Nhập ID của học viên cần chỉnh sửa:");
        int id = parseInt();

        Student student = iStudentService.findById(id);

        if (student == null) {
            System.out.println("Học viên không tồn tại với ID: " + id);
            return;
        }

        System.out.println("Nhập tên học sinh mới (hiện tại: " + student.getName() + "):");
        String name = scanner.nextLine();
        LocalDate birthday = promptForDate("Nhập ngày tháng năm sinh học viên mới (hiện tại: " + student.getBirthday() + "):");
        System.out.println("Nhập email học viên mới (hiện tại: " + student.getEmail() + "):");
        String email = scanner.nextLine();
        System.out.println("Nhập số điện thoại học viên mới (hiện tại: " + student.getPhoneNumber() + "):");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập lớp của học viên mới (hiện tại: " + student.getClassName() + "):");
        String className = scanner.nextLine();

        student.setName(name);
        student.setBirthday(birthday);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setClassName(className);

        iStudentService.update(student);

        System.out.println("Cập nhật học viên thành công với ID: " + id);
    }

    public static void deleteStudent() {
        System.out.println("Nhập ID của học viên cần xoá:");
        int id = parseInt();

        if (iStudentService.delete(id)) {
            System.out.println("Xoá học viên thành công với ID: " + id);
        } else {
            System.out.println("Học viên không tồn tại với ID: " + id);
        }
    }

    private static int parseInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ ");
            }
        }
    }
    private static LocalDate promptForDate(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return LocalDate.parse(scanner.nextLine(), Date);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày tháng không hợp lệ. Vui lòng nhập lại ");
            }
        }
    }
}

package QLHV.view;

import QLHV.controller.StudentController;
import QLHV.controller.TeacherController;
import java.util.Scanner;

public class CodegymManagement {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Quản lý Codegym:\n" +
                    "1. Quản lý học viên\n" +
                    "2. Quản lý giảng viên\n" +
                    "3. Thoát chương trình\n" +
                    "Nhập lựa chọn của bạn:");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentController.displayStudents();
                    break;
                case 2:
                    TeacherController.displayTeacher();
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println(" Vui lòng chọn lại.");
            }
        } while (true);
    }
}

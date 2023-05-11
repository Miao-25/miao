import student.StudentManagementSystem;

import java.util.Scanner;

public class Main {

    // 显示主菜单
    private static void displayMainMenu() {
        System.out.println("1. 学生信息管理");
        System.out.println("2. 学生课程成绩管理");
        System.out.println("3. 退出");
    }

    // 显示学生信息管理菜单
    private static void displayStudentMenu() {
        System.out.println("1. 添加学生");
        System.out.println("2. 删除学生");
        System.out.println("3. 修改学生信息");
        System.out.println("4. 查询学生信息");
        System.out.println("5. 导出学生信息到文件");
        System.out.println("6. 返回上一级菜单");
    }

    // 显示学生课程成绩管理菜单
    private static void displayScoreMenu() {
        System.out.println("1. 添加课程成绩");
        System.out.println("2. 删除课程成绩");
        System.out.println("3. 修改课程成绩");
        System.out.println("4. 查询课程成绩");
        System.out.println("5. 按总成绩排序学生");
        System.out.println("6. 显示所有学生信息");
        System.out.println("7. 显示所有课程信息");
        System.out.println("8. 显示所有学生的课程成绩信息");
        System.out.println("9. 返回上一级菜单");
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMainMenu();
            System.out.print("请选择操作：");
            //为了增加容错率，choice改为String
            String choice = scanner.next();
            switch (choice) {
                //1.学生信息管理
                case "1":
                    sms.studentMenu();
                    break;
                //2.成绩管理
                case "2":
                    sms.scoreMenu();
                    break;
                //3.退出
                case "3":
                    System.out.println("谢谢使用！");
                    return;//直接使用return结束，不用break loop这么麻烦！！
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }
}

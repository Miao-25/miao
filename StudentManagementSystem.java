package student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    //储存学生信息和课程信息
    private List<Student> students; // 学生列表
    private List<Course> courses; // 课程列表

    //其他方法可以通过访问 students 和 courses 成员变量来实现对学生和课程的增删改查等操作。
    public StudentManagementSystem() {
        students = new ArrayList<Student>();
        courses = new ArrayList<Course>();
    }

    // 添加学生
    public void addStudent(String id, String name, String gender, String birth) {
        Student student = new Student(id, name, gender, birth);
        students.add(student);//将学生信息添加到学生信息列表
    }

    // 删除学生
    public void removeStudent(String targetId) {
        for (int i = 0; i < students.size(); i++) {
            Student student2 = students.get(i);
            if (student2.getId() == targetId) {
                students.remove(i);////将学生信息从学生信息列表删除
                break; // 删除第一个匹配项并停止循环
            }
        }

    }

    // 修改学生信息
    public void modifyStudent(Student student, String id, String name, String gender, String birth) {
        student.setId(id);
        student.setName(name);
        student.setGender(gender);
        student.setBirth(birth);
    }

    // 查询学生信息
    public Student queryStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null; // 未找到该学生
    }

    // 导出学生信息到文件
    public void exportStudentInfo(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Student student : students) {
                writer.write("学号：" + student.getId() + " 姓名：" + student.getName() + " 性别：" + student.getGender()
                        + " 出生日期：" + student.getBirth() + " 总成绩：" + student.getTotalScore() + "\n");
            }
            writer.close();
            System.out.println("学生信息已导出到文件 " + fileName);
        } catch (IOException e) {
            System.out.println("导出学生信息失败：" + e.getMessage());
        }
    }

    // 添加课程
    public void addCourse(String id, String name, String teacher, int credit) {
        Course course = new Course(id, name, teacher, credit);
        courses.add(course);
    }

    // 删除课程
    public void removeCourse(Course course) {
        courses.remove(course);
        // 从所有学生的课程列表中删除该课程
        for (Student student : students) {
            student.removeCourse(course);
        }
    }

    // 修改课程信息
    public void modifyCourse(Course course, String id, String name, String teacher, int credit) {
        course.setId(id);
        course.setName(name);
        course.setTeacher(teacher);
        course.setCredit(credit);
    }

    // 查询课程信息
    public Course queryCourse(String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null; // 未找到该课程
    }

    // 导出课程信息到文件
    public void exportCourseInfo(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Course course : courses) {
                writer.write("课程编号：" + course.getId() + " 课程名称：" + course.getName() + " 任课教师：" + course.getTeacher()
                        + " 学分：" + course.getCredit() + "\n");
            }
            writer.close();
            System.out.println("课程信息已导出到文件 " + fileName);
        } catch (IOException e) {
            System.out.println("导出课程信息失败：" + e.getMessage());
        }
    }

    // 添加学生课程成绩
    public void addScore(Student student, Course course, int score) {
        student.addScore(course, score);
    }

    // 删除学生课程成绩
    public void removeScore(Student student, Course course) {
        student.removeScore(course);
    }

    // 修改学生课程成绩
    public void modifyScore(Student student, Course course, int score) {
        student.modifyScore(course, score);
    }

    // 查询学生课程成绩
    public int queryScore(Student student, Course course) {
        return student.queryScore(course);
    }

    // 排序学生课程成绩
    public void sortScores() {
        for (Student student : students) {
            student.calculateTotalScore();
        }
        Collections.sort(students, new StudentComparator());
    }

    // 显示学生信息
    public void displayStudents() {
        //打印表头信息
        System.out.println("学号\t\t姓名\t\t性别\t\t出生日期\t\t总成绩");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 显示课程信息
    public void displayCourses() {
        System.out.println("课程编号\t\t课程名称\t\t任课教师\t\t学分");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // 显示学生课程成绩
    public void displayScores(Student student) {
        System.out.println(student.getName() + " 的课程成绩：");
        System.out.println("课程编号\t\t课程名称\t\t任课教师\t\t学分\t\t成绩");
        List<Course> courseList = student.getCourses();
        for (Course course : courseList) {
            System.out.println(course + "\t\t" + student.queryScore(course));
        }
    }

    // 显示主菜单
    public void displayMainMenu() {
        System.out.println("1. 学生信息管理");
        System.out.println("2. 课程信息管理");
        System.out.println("3. 学生课程成绩管理");
        System.out.println("4. 退出");
    }

    // 显示学生信息管理菜单
    public void displayStudentMenu() {
        System.out.println("1. 添加学生");
        System.out.println("2. 删除学生");
        System.out.println("3. 修改学生信息");
        System.out.println("4. 查询学生信息");
        System.out.println("5. 导出学生信息到文件");
        System.out.println("6. 显示所有学生信息");
        System.out.println("7. 返回上级菜单");
    }
    // 显示课程信息管理菜单
    public void displayCourseMenu() {
        System.out.println("1. 添加课程");
        System.out.println("2. 删除课程");
        System.out.println("3. 修改课程信息");
        System.out.println("4. 查询课程信息");
        System.out.println("5. 导出课程信息到文件");
        System.out.println("6. 显示所有课程信息");
        System.out.println("7. 返回上级菜单");
    }

    // 显示学生课程成绩管理菜单
    public void displayScoreMenu() {
        System.out.println("1. 添加课程成绩");
        System.out.println("2. 删除课程成绩");
        System.out.println("3. 修改课程成绩");
        System.out.println("4. 查询课程成绩");
        System.out.println("5. 排序学生总成绩");
        System.out.println("6. 显示学生信息");
        System.out.println("7. 显示课程信息");
        System.out.println("8. 显示学生课程成绩");
        System.out.println("9. 返回上级菜单");
    }

    // 主菜单
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMainMenu();
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 3:
                    scoreMenu();
                    break;
                case 4:
                    System.out.println("谢谢使用！");
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }

    // 学生信息管理菜单
    public void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayStudentMenu();
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1://添加学生
                    String id="2222222222";
                    //boolean flag=true;
                    //while(flag) {
                        System.out.print("请输入学生学号:");
                        scanner.nextLine(); // 清除输入缓冲区中的空白字符
                        id = scanner.nextLine();
                        //判断学号是否重复
                       // for (int i = 0; i < students.size(); i++) {
                         //   Student student = students.get(i);
                            // 对每个学生执行一些操作
                           // if (student.getId() == id) {
                             //   System.out.print("学生已存在，请重新输入!");
                            //} else {
                            //    flag=false;
                            //    break;
                          //  }
                       // }
                    //}
                    System.out.print("请输入学生姓名：");
                    String name=scanner.nextLine();
                    System.out.print("请输入学生姓别：");
                    String gender=scanner.nextLine();
                    System.out.print("请输入学生出生日期：");
                    String birth=scanner.nextLine();
                    addStudent(id,name,gender,birth);
                    break;
                case 2:
                    System.out.print("请输入想要删除的学生的学号：");
                    String id2;
                    id2=scanner.nextLine();
                    removeStudent(id2);
                    break;
                case 3:
                    System.out.println("请输入要修改的学生ID：");
                    String id3 = scanner.nextLine();
                    Student studentToModify = students.get(0);
                    for (int i = 0; i < students.size(); i++) {
                        Student student = students.get(i);
                        if (student.getId().equals(id3)) {
                            studentToModify = student;
                            break;
                        }
                    }
                    if (studentToModify != null) {
                        System.out.println("请输入新的姓名：");
                        String name3 = scanner.nextLine();

                        System.out.println("请输入新的性别：");
                        String gender3 = scanner.nextLine();

                        System.out.println("请输入新的出生日期：");
                        String birth3 = scanner.nextLine();

                        modifyStudent(studentToModify, id3, name3, gender3, birth3);
                        System.out.println("学生信息修改成功！");
                    } else {
                        System.out.println("未找到该学生！");
                    }
                    break;
                case 4:
                    System.out.print("请输入想要查询的学生的学号");
                    String id4;
                    id4=scanner.nextLine();
                    queryStudent(id4);
                    break;
                case 5:
                    exportStudentInfo("student_info.txt");
                    break;
                case 6:
                    displayStudents();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }



    // 课程信息管理菜单
    public void courseMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayCourseMenu();
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("请输入课程编号");
                    String id1=scanner.nextLine();
                    System.out.print("请输入课程名称");
                    String name1=scanner.nextLine();
                    System.out.print("请输入课程老师");
                    String teacher1=scanner.nextLine();
                    System.out.print("请输入课程学分");
                    int credit1;
                    credit1=scanner.nextInt();
                    addCourse(id1,name1,teacher1,credit1);
                    break;
                case 2:
                    Course courseToRemove = courses.get(0);
                    System.out.print("请输入想要删除的课程的编号");
                    String id2;
                    id2=scanner.nextLine();
                    for (int i = 0; i < courses.size(); i++) {
                        Course course = courses.get(i);
                        if (course.getId().equals(id2)) {
                            courseToRemove = course;
                            break;
                        }
                    }
                    removeCourse( courseToRemove);
                    break;
                case 3:
                    System.out.println("请输入要修改的课程编号：");
                    String id3 = scanner.nextLine();
                    Course courseToModify = courses.get(0);
                    for (int i = 0; i < courses.size(); i++) {
                        Course course = courses.get(i);
                        if (course.getId().equals(id3)) {
                            courseToModify = course;
                            break;
                        }
                    }
                    if (courseToModify != null) {
                        System.out.println("请输入新的课程名称：");
                        String name3 = scanner.nextLine();

                        System.out.println("请输入新的课程老师：");
                        String teacher3 = scanner.nextLine();

                        System.out.println("请输入新的课程学分：");
                        int credit3;
                        credit3= scanner.nextInt();

                        modifyCourse(courseToModify, id3, name3, teacher3, credit3);
                        System.out.println("学生信息修改成功！");
                    } else {
                        System.out.println("未找到该学生！");
                    }
                    break;
                case 4:
                    System.out.print("请输入想要查询的课程的编号");
                    String id4;
                    id4=scanner.nextLine();
                    queryCourse(id4);
                    break;
                case 5:
                    exportCourseInfo("course_info.txt");
                    break;
                case 6:
                    displayCourses();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }

    // 学生课程成绩管理菜单
    public void scoreMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayScoreMenu();
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            System.out.println("Select a student:");
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i+1) + ". " + students.get(i).getName());
            }
            int studentIndex = scanner.nextInt() - 1;
            Student selectedStudent = students.get(studentIndex);

            System.out.println("Select a course:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i+1) + ". " + courses.get(i).getName());
            }
            int courseIndex = scanner.nextInt() - 1;
            Course selectedCourse = courses.get(courseIndex);
            switch (choice) {
                case 1:
                    int score1;
                    score1=scanner.nextInt();
                    addScore(selectedStudent,selectedCourse,score1);
                    break;
                case 2:
                    removeScore(selectedStudent,selectedCourse);
                    break;
                case 3:
                    int score3;
                    score3=scanner.nextInt();
                    modifyScore(selectedStudent,selectedCourse,score3);
                    break;
                case 4:
                    queryScore(selectedStudent,selectedCourse);
                    break;
                case 5:
                    sortScores();
                    break;
                case 6:
                    displayStudents();
                    break;
                case 7:
                    displayCourses();
                    break;
                case 8:
                    displayScores(selectedStudent);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }

    public void StudentMainInterface() {
    }
}






import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentGradeManagementSystem {

    // 定义一个学生类
    static class Student {
        String id;  // 学号
        String name;  // 姓名
        String gender;  // 性别
        String birthday;  // 出生年月
        ArrayList<CourseGrade> courses;  // 修过的课程成绩列表

        public Student(String id, String name, String gender, String birthday) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.birthday = birthday;
            this.courses = new ArrayList<CourseGrade>();
        }

        // 添加一门成绩
        public void addCourseGrade(String courseId, String courseName, String teacher, int credit, int grade) {
            CourseGrade courseGrade = new CourseGrade(courseId, courseName, teacher, credit, grade);
            courses.add(courseGrade);
        }

        // 删除一门成绩
        public void removeCourseGrade(String courseId) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).courseId.equals(courseId)) {
                    courses.remove(i);
                    break;
                }
            }
        }

        // 修改一门成绩
        public void updateCourseGrade(String courseId, int grade) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).courseId.equals(courseId)) {
                    courses.get(i).grade = grade;
                    break;
                }
            }
        }

        // 获取总成绩
        public int getTotalGrade() {
            int total = 0;
            for (CourseGrade course : courses) {
                total += course.grade * course.credit;
            }
            return total;
        }

        // 导出成绩单
        public String exportGradeReport() {
            StringBuilder sb = new StringBuilder();
            sb.append("学号：").append(id).append("\n");
            sb.append("姓名：").append(name).append("\n");
            sb.append("性别：").append(gender).append("\n");
            sb.append("出生年月：").append(birthday).append("\n");
            sb.append("成绩单：\n");
            for (CourseGrade course : courses) {
                sb.append(course.courseId).append("\t");
                sb.append(course.courseName).append("\t");
                sb.append(course.teacher).append("\t");
                sb.append(course.credit).append("学分\t");
                sb.append(course.grade).append("\n");
            }
            sb.append("总成绩：").append(getTotalGrade()).append("\n");
            return sb.toString();
        }
    }

    // 定义一个课程成绩类
    static class CourseGrade {
        String courseId;  // 课程编号
        String courseName;  // 课程名称
        String teacher;  // 任课老师
        int credit;  // 学分
        int grade;

        public CourseGrade(String courseId, String courseName, String teacher, int credit, int grade) {
            this.courseId = courseId;
            this.courseName = courseName;
            this.teacher = teacher;
            this.credit = credit;
            this.grade = grade;
        }
    }

    // 定义一个课程类
    static class Course {
        String id;  // 课程编号
        String name;  // 课程名称
        String teacher;  // 任课老师
        int credit;  // 学分

        public Course(String id, String name, String teacher, int credit) {
            this.id = id;
            this.name = name;
            this.teacher = teacher;
            this.credit = credit;
        }
    }

    // 存储学生和课程信息的列表
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public StudentGradeManagementSystem() {
        students = new ArrayList<Student>();
        courses = new ArrayList<Course>();
    }

    // 添加学生
    public void addStudent(String id, String name, String gender, String birthday) {
        Student student = new Student(id, name, gender, birthday);
        students.add(student);
    }

    // 删除学生
    public void removeStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals(id)) {
                students.remove(i);
                break;
            }
        }
    }

    // 修改学生信息
    public void updateStudent(String id, String name, String gender, String birthday) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals(id)) {
                students.get(i).name = name;
                students.get(i).gender = gender;
                students.get(i).birthday = birthday;
                break;
            }
        }
    }

    // 查询学生信息
    public Student findStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals(id)) {
                return students.get(i);
            }
        }
        return null;
    }

    // 导出学生信息
    public String exportStudentInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("学生信息：\n");
        for (Student student : students) {
            sb.append(student.id).append("\t");
            sb.append(student.name).append("\t");
            sb.append(student.gender).append("\t");
            sb.append(student.birthday).append("\n");
        }
        return sb.toString();
    }

    // 添加课程
    public void addCourse(String id, String name, String teacher, int credit) {
        Course course = new Course(id, name, teacher, credit);
        courses.add(course);
    }

    // 删除课程
    public void removeCourse(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).id.equals(id)) {
                courses.remove(i);
                break;
            }
        }
    }

    // 修改课程信息
    public void updateCourse(String id, String name, String teacher, int credit) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).id.equals(id)) {
                courses.get(i).name = name;
                courses.get(i).teacher = teacher;
                courses.get(i).credit = credit;

                break;
            }
        }
    }

    // 查询课程信息
    public Course findCourse(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).id.equals(id)) {
                return courses.get(i);
            }
        }
        return null;
    }

    // 导出课程信息
    public String exportCourseInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("课程信息：\n");
        for (Course course : courses) {
            sb.append(course.id).append("\t");
            sb.append(course.name).append("\t");
            sb.append(course.teacher).append("\t");
            sb.append(course.credit).append("\n");
        }
        return sb.toString();
    }

    // 添加学生成绩
    public void addCourseGrade(String studentId, String courseId, int grade) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);
        if (student == null || course == null) {
            return;
        }
        student.addCourseGrade(courseId, course.name, course.teacher, course.credit, grade);
    }

    // 删除学生成绩
    public void removeCourseGrade(String studentId, String courseId) {
        Student student = findStudent(studentId);
        if (student == null) {
            return;
        }
        student.removeCourseGrade(courseId);
    }

    // 修改学生成绩
    public void updateCourseGrade(String studentId, String courseId, int grade) {
        Student student = findStudent(studentId);
        if (student == null) {
            return;
        }
        student.updateCourseGrade(courseId, grade);
    }

    // 查询学生成绩
    public CourseGrade findCourseGrade(String studentId, String courseId) {
        Student student = findStudent(studentId);
        if (student == null) {
            return null;
        }
        return student.findCourseGrade(courseId);
    }

    // 对学生成绩进行排序（按照总成绩降序）
    public void sortCourseGrades() {
        for (Student student : students) {
            student.sortCourseGrades();
        }
    }

    // 导出学生成绩
    public String exportCourseGradeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("学生成绩：\n");
        for (Student student : students) {
            sb.append(student.id).append("\t");
            sb.append(student.name).append("\n");
            for (CourseGrade courseGrade : student.courseGrades) {
                sb.append("\t").append(courseGrade.courseName).append("\t");
                sb.append(courseGrade.teacher).append("\t");
                sb.append(courseGrade.credit).append("\t");
                sb.append(courseGrade.grade).append("\t");
                sb.append(courseGrade.totalGrade).append("\n");
            }
        }
        return sb.toString();
    }
}//StudentGradeManagementSystem类


package student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id; // 学号
    private String name; // 姓名
    private String gender; // 性别
    private String birth; // 出生日期
    private List<Course> courses; // 学生所选课程
    private int totalScore; // 总成绩

    public Student(String id, String name, String gender, String birth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.courses = new ArrayList<Course>();
        this.totalScore = 0;
    }

    // 添加课程
    public void addCourse(Course course) {
        courses.add(course);
    }

    // 删除课程
    public void removeCourse(Course course) {
        courses.remove(course);
    }
   
    // 获取成绩
    public int queryScore(Course course) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                return c.getScore();
            }
        }
        return -1; // 未选该课程
    }
    // 添加学生课程成绩
    public void addScore(Course course, int score) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                c.setScore(score);
                break;
            }
        }
        calculateTotalScore();
    }

    // 修改成绩
    public void modifyScore(Course course, int score) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                c.setScore(score);
                break;
            }
        }
        calculateTotalScore();
    }

    // 计算总成绩
    public void calculateTotalScore() {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getScore();
        }
        totalScore = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void removeScore(Course course) {
        courses.remove(course);
    }
}



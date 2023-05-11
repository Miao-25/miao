package student;

public class Course {
    private String id; // 课程编号
    private String name; // 课程名
    private String teacher; // 任课老师
    private int credit; // 学分
    private int score; // 成绩

    public Course(String id, String name, String teacher, int credit) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.credit = credit;
        this.score = -1; // 默认未选该课程
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

    public String getTeacher() {
        return teacher;

    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}


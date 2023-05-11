package student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getTotalScore() > s2.getTotalScore()) {
            return -1;
        } else if (s1.getTotalScore() < s2.getTotalScore()) {
            return 1;
        } else {
            return s1.getName().compareTo(s2.getName());
        }
    }
}

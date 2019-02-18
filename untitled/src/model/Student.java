package model;

public class Student implements Comparable<Student> {
    private String name;
    private String imgUrl;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    private void increaseScore() {

    }

    private void increaseTooLate() {

    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }
}

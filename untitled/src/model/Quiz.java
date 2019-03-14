package model;

public abstract class Quiz {
    protected Student selectedStudent;
    protected boolean isCorrect;

    public Quiz(Student s) {
        this.selectedStudent = s;
    }

    //abstract void checkAnswer();

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}

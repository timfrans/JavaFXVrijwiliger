package model;

import javafx.beans.property.IntegerProperty;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String imgUrl;
    private IntegerProperty score;
    private IntegerProperty tooLate;
    private boolean isGuessed;

    public Student(String firstName, String lastName, IntegerProperty score, IntegerProperty tooLate, boolean isGuessed, String id, String imgUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.tooLate = tooLate;
        this.isGuessed = isGuessed;
        this.imgUrl = imgUrl;
    }

    public void increaseScore() {
        this.score.setValue(this.score.getValue()+1);
    }

    public void increaseTooLate() {
        this.tooLate.setValue(this.tooLate.getValue()+1);
    }

    public IntegerProperty tooLateProperty() {
        return tooLate;
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public int getScore() {
        return score.get();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTooLate() {
        return tooLate.get();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }

    @Override
    public String toString() {
        char del = ';';
        return firstName + del + lastName + del + getScore() + del + getTooLate() + del + isGuessed + del + id + del + imgUrl;
    }
}

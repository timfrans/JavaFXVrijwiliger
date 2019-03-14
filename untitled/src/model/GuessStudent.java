package model;

public class GuessStudent extends Quiz {
    private Answer answer;
    private boolean isCorrect;

    public GuessStudent(Student s) {
        super(s);
        this.answer = new Answer();
    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }

    public void updateAnswer(String firstName, String lastName) {
        answer.setFirstName(firstName);
        answer.setLastName(lastName);
    }

    public void checkAnswer() {
        String firstname = selectedStudent.getFirstName();
        String lastname = selectedStudent.getLastName();
        String answerf = answer.getFirstName();
        String answerl = answer.getLastName();
        if(firstname.equalsIgnoreCase(answerf) && lastname.equalsIgnoreCase(answerl)) {
            isCorrect = true;
            selectedStudent.setGuessed(true);
        }
    }
}

package main.model;

import java.util.LinkedList;
import java.util.List;

public class QABlock {

    private String question;
    private List<String> answers;

    public QABlock() {
        this.answers = new LinkedList<String>();
    }

    public QABlock(String question, List<String> answers) {
        this.answers = new LinkedList<String>();
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void addAnswer(String answer) {
        this.answers.add(answer);
    }
}

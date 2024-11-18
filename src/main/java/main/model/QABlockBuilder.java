package main.model;

import java.util.LinkedList;
import java.util.List;

public class QABlockBuilder {

    private String _question;
    private List<String> _answers;

    public QABlockBuilder() {}

    public QABlockBuilder question(String question) {
        if(question == null || question.isEmpty()) {
            System.out.println("You must provide a question.");
            return null;
        }
        this._question = question;
        return this;
    }

    public QABlockBuilder answers(List<String> answers) {
        if(answers == null || answers.isEmpty()) {
            System.out.println("You must provide at least 1 answer.");
            return null;
        }
        this._answers = answers;
        return this;
    }

    public QABlockBuilder answers(String answer) {
        if(answer == null || answer.isEmpty()) {
            System.out.println("You must provide the answer.");
            return null;
        }
        if(this._answers == null) this._answers = new LinkedList<>();
        this._answers.add(answer);
        return this;
    }

    public QABlock build() {
        LinkedList<String> tempAnswers = (LinkedList<String>) this._answers;
        this._answers = null;
        return new QABlock(this._question, tempAnswers);
    }

}

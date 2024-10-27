package generic.model;

import java.util.LinkedList;
import java.util.List;

public class QABlock {

    private String question;
    private List<String> answers;

    protected QABlock() {
        this.answers = new LinkedList<String>();
    }

    protected QABlock(String question, List<String> answers) {
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
}

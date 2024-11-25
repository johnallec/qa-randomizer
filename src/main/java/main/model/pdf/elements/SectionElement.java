package main.model.pdf.elements;

import java.util.LinkedList;
import org.w3c.dom.Node;

public class SectionElement extends PDFElement {

    private String question;
    private LinkedList<String> answers;

    public SectionElement() {
        super();
        this.answers = new LinkedList<>();
    }

    public SectionElement(Node domNode) {
        super(domNode);
        this.answers = new LinkedList<>();
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LinkedList<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(LinkedList<String> answers) {
        this.answers = answers;
    }

}

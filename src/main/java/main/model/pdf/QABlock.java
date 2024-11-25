package main.model.pdf;

import java.util.LinkedList;
import java.util.List;

public class QABlock {

    private List<String> qaList;

    public QABlock() {
        this.qaList = new LinkedList<String>();
    }

    public QABlock(List<String> qaList) {
        this.qaList = qaList;
    }

    public List<String> getQAList() {
        return qaList;
    }

    public void setQAList(List<String> qaList) {
        this.qaList = qaList;
    }

}
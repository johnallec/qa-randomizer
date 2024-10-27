package generic.model;

import java.util.LinkedList;
import java.util.List;

public class PDFFile {

    private String title;
    private List<Section> sections;

    public PDFFile() {
        this.sections = new LinkedList<Section>();
    }

    public PDFFile(String title) {
        this.title = title;
        this.sections = new LinkedList<Section>();
    }

    public PDFFile(String title, List<Section> sections) {
        this.title = title;
        this.sections = sections;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section) {
        if(section != null) this.sections.add(section);
    }
}

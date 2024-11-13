package generic.model;

import java.util.LinkedList;
import java.util.List;

public class PDFFile {

    private String path;
    private String title;
    private List<Section> sections;

    public PDFFile() {
        this.sections = new LinkedList<>();
    }

    public PDFFile(String title) {
        this.path = "";
        this.title = title;
        this.sections = new LinkedList<>();
    }

    public PDFFile(String path, String title) {
        this.path = path;
        this.title = title;
        this.sections = new LinkedList<>();
    }

    public PDFFile(String title, List<Section> sections) {
        this.title = title;
        this.sections = sections;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompletePath() {
        return this.path + this.title;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section) {
        if(section != null) this.sections.add(section);
    }
}

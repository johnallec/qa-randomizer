package generic.model;

import java.util.LinkedList;
import java.util.List;

public class PDFFile extends GenericFile{

    private List<Section> sections;

    public PDFFile() {
        super();
        this.sections = new LinkedList<>();
    }

    public PDFFile(String title) {
        super(title);
        this.sections = new LinkedList<>();
    }

    public PDFFile(String path, String title) {
        super(path,title);
        this.sections = new LinkedList<>();
    }

    public PDFFile(String title, List<Section> sections) {
        super(title);
        this.sections = sections;
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

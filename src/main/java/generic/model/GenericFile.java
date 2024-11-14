package generic.model;

public class GenericFile {
    
    protected String path;
    protected String title;

    public GenericFile() {}

    public GenericFile(String title) {
        this.path = "";
        this.title = title;
    }

    public GenericFile(String path, String title) {
        this.path = path;
        this.title = title;
    }

    public String getCompletePath() {
        return this.path + this.title;
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
}

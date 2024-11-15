package generic.model;

public abstract class GenericFile<T> {
    
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

    protected abstract void generateDocument() throws Exception;

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

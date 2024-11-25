package main.model;

public abstract class FileCreator {
    public abstract GenericFile createFile();
    public abstract GenericFile createFile(String title);
    public abstract GenericFile createFile(String path, String title);
}

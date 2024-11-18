package main.model.factory;

import main.model.GenericFile;

public abstract class FileCreator {
    public abstract GenericFile createFile();
    public abstract GenericFile createFile(String title);
    public abstract GenericFile createFile(String path, String title);
}

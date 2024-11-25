package main.model.xml;

import main.model.FileCreator;
import main.model.GenericFile;

public class XMLFileCreator extends FileCreator {

    @Override
    public GenericFile createFile() { return new XMLFile(); }

    @Override
    public GenericFile createFile(String title) { return new XMLFile(title); }

    @Override
    public GenericFile createFile(String path, String title) { return new XMLFile(path,title); }

}


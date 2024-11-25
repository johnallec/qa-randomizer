package main.model.pdf;

import main.model.FileCreator;
import main.model.GenericFile;

public class PDFFileCreator extends FileCreator {

    @Override
    public GenericFile createFile() { return new PDFFile(); }

    @Override
    public GenericFile createFile(String title) { return new PDFFile(title); }

    @Override
    public GenericFile createFile(String path, String title) { return new PDFFile(path,title); }

}

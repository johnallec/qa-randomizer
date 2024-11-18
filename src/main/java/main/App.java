package main;

import main.model.factory.PDFFile;
import main.model.factory.PDFFileCreator;
import main.model.factory.XMLFile;
import main.model.factory.XMLFileCreator;

public class App
{
    public static void main( String[] args )
    {
        //java 17.0.13
        String pdfPath = "C:/Users/nuke/java-workspace/qa-randomizer-stuff/stuff/pdf/";
        String pdfTitle = "firstResult.pdf";

        String xmlPath = "C:/Users/nuke/java-workspace/qa-randomizer-stuff/stuff/xml/";
        String xmlTitle = "inputExample.xml";

        var pdfFileCreator = new PDFFileCreator();
        var xmlFileCreator = new XMLFileCreator();

        PDFFile pdfFile = (PDFFile) pdfFileCreator.createFile();
        pdfFile.setPath(pdfPath);
        pdfFile.setTitle(pdfTitle);
        
        XMLFile xmlFile = (XMLFile) xmlFileCreator.createFile();
        xmlFile.setPath(xmlPath);
        xmlFile.setTitle(xmlTitle);

        xmlFile.generateStructure();
        xmlFile.generatePdfFile(pdfFile);

    }
}

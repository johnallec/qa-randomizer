package main;

import com.itextpdf.io.font.FontConstants;
import main.model.pdf.PDFFile;
import main.model.pdf.PDFFileCreator;
import main.model.xml.XMLFile;
import main.model.xml.XMLFileCreator;

public class App
{
    public static void main( String[] args )
    {
        //java 17.0.13
        String pdfPath = "C:/Users/nuke/java-workspace/qa-randomizer-stuff/stuff/pdf/";
        String pdfTitle = "secondResult.pdf";

        String xmlPath = "C:/Users/nuke/java-workspace/qa-randomizer-stuff/stuff/xml/";
        String xmlTitle = "inputExample.xml";

        var pdfFileCreator = new PDFFileCreator();
        var xmlFileCreator = new XMLFileCreator();

        main.model.pdf.PDFFile pdfFile = (PDFFile) pdfFileCreator.createFile();
        pdfFile.setPath(pdfPath);
        pdfFile.setTitle(pdfTitle);
        
        XMLFile xmlFile = (XMLFile) xmlFileCreator.createFile();
        xmlFile.setPath(xmlPath);
        xmlFile.setTitle(xmlTitle);

        xmlFile.generateStructure();
        xmlFile.generatePdfFile(pdfFile);
    }
}

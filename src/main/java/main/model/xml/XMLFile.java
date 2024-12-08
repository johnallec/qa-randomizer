package main.model.xml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import main.model.GenericFile;
import main.model.exceptions.GUIException;
import main.model.pdf.PDFFile;

public class XMLFile extends GenericFile {

    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    private XMLNodeTree tree;

    protected XMLFile() {
        super();
    }

    protected XMLFile(String title) {
        super(title);
    }

    protected XMLFile(String path, String title) {
        super(path,title);
    }

    public XMLNodeTree tmpTest() {
        return this.tree;
    }

    public void generateStructure() throws GUIException {
        Document document;
        try {
            document = this.builderFactory.newDocumentBuilder().parse(getCompletePath());
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getChildNodes();
            this.tree = new XMLNodeTree(nodeList);
            this.tree.createStructure();
        }
        catch(IOException ioExc){}
        catch(SAXException saxExc) {}
        catch(ParserConfigurationException parserConfigExc) {}
        finally{}
    }

   public void generatePdfFile(PDFFile pdfFile) {
        try {
            pdfFile.setXMLNodeTree(this.tree);
            pdfFile.generateDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateDocument() {}

}
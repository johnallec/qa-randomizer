package main.model.factory;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import main.model.GenericFile;
import main.model.QABlock;
import main.model.Section;
import main.model.XMLNode;
import main.model.XMLNodeTree;

public class XMLFile extends GenericFile<Document> {

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

    public void generateStructure() {
        Document document;
        try {
            document = this.builderFactory.newDocumentBuilder().parse(getCompletePath());
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getChildNodes();
            Node pdfNode = nodeList.item(0);
            this.tree = new XMLNodeTree(pdfNode);
            this.tree.createStructure();
        }
        catch(IOException ioExc){}
        catch(SAXException saxExc) {}
        catch(ParserConfigurationException parserConfigExc) {}
        finally{}
    }

    public void generatePdfFile(PDFFile pdfFile) {
        if(this.tree == null) {
            System.out.println("Generate the structure first. If you did create the structure already, something went wrong.");
            return;
        }

        for(XMLNode xmlSectionNode : this.tree.getXMLNodesByTagName("section")) {
            Section newSection = new Section();
            QABlock block = new QABlock();

            block.setQuestion(xmlSectionNode.getFirstChild().getText());
            
            for(int i = 1; i < xmlSectionNode.numOfChildren(); i++){
                block.addAnswer(xmlSectionNode.getChild(i).getText());
            }
            newSection.addBlock(block);
            pdfFile.addSection(newSection);
        }
        try {
            pdfFile.generateDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateDocument() {}

}
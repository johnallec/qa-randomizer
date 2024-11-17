package generic.model.manager;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import generic.model.GenericFile;
import generic.model.XMLNodeTree;

public class XML {

    public class XMLFileManager implements Manager {

        private XMLFile xmlFile;
    
        public XMLFileManager() {
            this.xmlFile = new XMLFile();
        }

        public XMLFileManager(String title) {
            this.xmlFile = new XMLFile(title);
        }

        public XMLFileManager(String path, String title) {
            this.xmlFile = new XMLFile(path, title);
        }

        public XMLFile getPDFFile() {
            return this.xmlFile;
        }

        @Override
        public void manage() {
            try {
                this.xmlFile.generateDocument();
            }
            catch(IOException ioExc){}
            catch(SAXException saxExc) {}
            catch(ParserConfigurationException parserConfigExc) {}

        }
    
    }
    
    private class XMLFile extends GenericFile<Document> {

        private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        public XMLFile() {
            super();
        }

        public XMLFile(String title) {
            super(title);
        }
    
        public XMLFile(String path, String title) {
            super(path,title);
        }
    
        @Override
        protected void generateDocument() throws IOException, SAXException, ParserConfigurationException {
            Document document;
            try {
                document = this.builderFactory.newDocumentBuilder().parse(getCompletePath());
                document.getDocumentElement().normalize();
                NodeList nodeList = document.getChildNodes();
                Node pdfNode = nodeList.item(0);
                var nodeTree = new XMLNodeTree(pdfNode);
                nodeTree.createStructure();
                System.out.println(nodeTree.numOfTags(nodeTree.getRoot(), 0));
            }
            finally {}
        }

    }

}
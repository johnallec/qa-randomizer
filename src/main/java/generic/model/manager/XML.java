package generic.model.manager;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import generic.model.GenericFile;
import generic.model.QABlock;
import generic.model.Section;
import generic.model.XMLNode;
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

        public XMLFile getXMLFile() {
            return this.xmlFile;
        }

        @Override
        public void manage() {
            this.xmlFile.generateStructure();
            this.xmlFile.generateDocument();
        }
    
    }
    
    public class XMLFile extends GenericFile<Document> {

        private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        private XMLNodeTree tree;

        private XMLFile() {
            super();
        }

        private XMLFile(String title) {
            super(title);
        }
    
        private XMLFile(String path, String title) {
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

        @Override
        protected void generateDocument() {      

            if(this.tree == null) return;

            String pdfPath = "C:/Users/nuke/java-workspace/qa-randomizer-stuff/stuff/pdf/";
            String pdfTitle = "firstResult.pdf";

            var pdfManager = new PDF().new PDFFileManager(pdfPath,pdfTitle);



            for(XMLNode xmlSectionNode : this.tree.getXMLNodesByTagName("section")) {
                Section newSection = new Section();
                QABlock block = new QABlock();

                block.setQuestion(xmlSectionNode.getChildren().get(0).getDomNode().getTextContent());
                
                for(int i = 1; i < xmlSectionNode.getChildren().size(); i++){
                    block.addAnswer(xmlSectionNode.getChildren().get(i).getDomNode().getTextContent());
                }
                newSection.addBlock(block);
                pdfManager.getPDFFile().addSection(newSection);
            }
            pdfManager.manage();

        }
    
    }

}
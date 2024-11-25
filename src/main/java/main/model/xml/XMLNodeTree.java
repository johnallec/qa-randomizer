package main.model.xml;

import java.util.ArrayList;
import java.util.LinkedList;
import org.w3c.dom.NodeList;
import main.model.pdf.elements.PDFElementCreator;
import main.model.pdf.elements.SectionElement;

public class XMLNodeTree {

    private XMLNode root;
    private LinkedList<XMLNode> xmlNodesList;
    private final PDFElementCreator pdfElementCreator = new PDFElementCreator();

    public XMLNodeTree() {
        this.xmlNodesList = new LinkedList<>();
    }

    public XMLNodeTree(NodeList nodeList) {
        this.root = new XMLNode(pdfElementCreator.createPDFElement(nodeList.item(0)));
        this.xmlNodesList = new LinkedList<>();
    }

    public XMLNode getRoot() {
        return this.root;
    }

    public void setRoot(NodeList nodeList) {
        this.root = new XMLNode(pdfElementCreator.createPDFElement(nodeList.item(0).getNodeName()));
    }

    public void createStructure() {
        initStructure(root);
    }

    private void initStructure(XMLNode currentNode) {
        if(currentNode == null) return;

        int domNodeChildNodesLength = currentNode.getElement().getDomNodeChildNodesLength();
        for(int i = 0; i < domNodeChildNodesLength; i++) {
            XMLNode newNode = new XMLNode(pdfElementCreator.createPDFElement(currentNode.getElement().getDomNodeChildNode(i)));
            if(!toBeSkipped(newNode)){
                currentNode.addChild(newNode);
                if(currentNode.getElement().getTagName() == "section") {
                    SectionElement sectionElement = (SectionElement) currentNode.getElement();
                    switch(newNode.getElement().getTagName()) {
                        case "q":
                            sectionElement.setQuestion(newNode.getElement().getText());
                            break;
                        case "a":
                            sectionElement.getAnswers().add(newNode.getElement().getText());
                            break;
                        default: System.out.println("No q or a found in SectionElement switch. initStructure -> XMLNodeTree");
                    }
                }
                
                newNode.setFather(currentNode);
                initStructure(newNode);
            }
        }
    }

    public LinkedList<XMLNode> depthFirst() {
        depthFirstRic(this.root);
        return this.xmlNodesList;
    }

    private void depthFirstRic(XMLNode currentNode) {
        if(currentNode == null) return;

        this.xmlNodesList.add(currentNode);

        for(XMLNode child : currentNode.getChildren()) {   
            depthFirstRic(child);
        }
        
    }
    
    public int numOfTags() { return numOfTagsRic(this.root, 0); }

    public int numOfTagsByTagName(String tagName) { return numOfTagsByTagNameRic(this.root, tagName, 0); }

    public ArrayList<XMLNode> getXMLNodesByTagName(String tagName) {
        ArrayList<XMLNode> xmlNodes = new ArrayList<>();
        getXMLNodesByTagNameRic(this.root, tagName, xmlNodes);
        return xmlNodes;
    }

    private int numOfTagsRic(XMLNode currentNode, int size) {
        if(currentNode == null) return size;
        size = size+1;
        for(XMLNode child : currentNode.getChildren())
            size = numOfTagsRic(child,size);
        return size;
    }

    private int numOfTagsByTagNameRic(XMLNode currentNode, String tagName, int size) {
        if(currentNode == null) return size;
        if(currentNode.getElement().getTagName().equalsIgnoreCase(tagName)) size = size+1;
        for(XMLNode child : currentNode.getChildren())
            size = numOfTagsRic(child,size);
        return size;
    }

    private void getXMLNodesByTagNameRic(XMLNode currentNode, String tagName, ArrayList<XMLNode> xmlNodes) {
        if(currentNode == null) return;
        if(currentNode.getElement().getTagName().equalsIgnoreCase(tagName)) xmlNodes.add(currentNode);
        for(XMLNode child : currentNode.getChildren())
            getXMLNodesByTagNameRic(child,tagName,xmlNodes);
    }

    private boolean toBeSkipped(XMLNode node) {
        return node.getElement().getTagName().equalsIgnoreCase("#text");
    }
    
    public void printTree() {
        printTreeRic(this.root);
    }

    public void printTreeRic(XMLNode currentNode) {
        System.out.println(currentNode.toString());
        for(XMLNode child : currentNode.getChildren())
            printTreeRic(child);
    }

}

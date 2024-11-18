package main.model;

import java.util.ArrayList;

import org.w3c.dom.Node;

public class XMLNodeTree {

    private XMLNode root;

    public XMLNodeTree() {}
    
    public XMLNodeTree(Node domRoot) {
        this.root = new XMLNode(domRoot);
    }

    public void setRoot(Node domRoot) {
        this.root = new XMLNode(domRoot);
    }

    public XMLNode getRoot() {
        return this.root;
    }

    public void createStructure() {
        if(this.root == null) return;
        initStructure(root);
    }

    private void initStructure(XMLNode currentNode) {
        if(currentNode == null) return;
        int domNodeChildNodesLength = currentNode.getDomNode().getChildNodes().getLength();
        for(int i = 0; i < domNodeChildNodesLength; i++) {
            XMLNode newNode = new XMLNode(currentNode.getDomNode().getChildNodes().item(i));
            if(!toBeSkipped(newNode)){
                currentNode.addChild(newNode);
                newNode.setFather(currentNode);
                initStructure(newNode);
            }
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
        if(currentNode.getTagName().equalsIgnoreCase(tagName)) size = size+1;
        for(XMLNode child : currentNode.getChildren())
            size = numOfTagsRic(child,size);
        return size;
    }

    private void getXMLNodesByTagNameRic(XMLNode currentNode, String tagName, ArrayList<XMLNode> xmlNodes) {
        if(currentNode == null) return;
        if(currentNode.getTagName().equalsIgnoreCase(tagName)) xmlNodes.add(currentNode);
        for(XMLNode child : currentNode.getChildren())
            getXMLNodesByTagNameRic(child,tagName,xmlNodes);
    }
    
    public XMLNode breadthFirstSearch() {
        return null;
    }

    private boolean toBeSkipped(XMLNode node) {
        return node.getDomNode().getNodeName().equalsIgnoreCase("#text");
    }
    
}

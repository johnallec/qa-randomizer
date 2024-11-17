package generic.model;

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

    public int numOfTags(XMLNode currentNode, int size) {
        if(currentNode == null) return size;
        size = size+1;
        int domNodeChildNodesLength = currentNode.getDomNode().getChildNodes().getLength();
        for(int i = 0; i < domNodeChildNodesLength; i++) {
            XMLNode newNode = new XMLNode(currentNode.getDomNode().getChildNodes().item(i));
            if(!toBeSkipped(newNode)){
                size = numOfTags(newNode,size);
            }
        }
        return size;
    }

    public XMLNode depthFirstSearch() {
        return null;
    }
    
    public XMLNode breadthFirstSearch() {
        return null;
    }

    private boolean toBeSkipped(XMLNode node) {
        return node.getDomNode().getNodeName().equalsIgnoreCase("#text");
    }
    
}

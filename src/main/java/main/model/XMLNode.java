package main.model;

import java.util.ArrayList;

import org.w3c.dom.Node;

public class XMLNode {

    private Node domNode;
    private XMLNode father;
    private ArrayList<XMLNode> children;

    public XMLNode() {
        this.children = new ArrayList<>();
    }

    public XMLNode(Node node) {
        this.children = new ArrayList<>();
        this.domNode = node;
    }
    
    public void addChild(XMLNode child) {
        if(child == null) return;
        this.children.add(child);
    }

    public XMLNode getFirstChild() {
        return this.children.get(0);
    }

    public XMLNode getLastChild() {
        return this.children.get(this.children.size()-1);
    }

    public String getTagName(){
        return this.domNode.getNodeName();
    }

    public Node getDomNode() {
        return domNode;
    }
    
    public void setDomNode(Node domNode) {
        this.domNode = domNode;
    }
    
    public XMLNode getFather() {
        return father;
    }
    
    public void setFather(XMLNode father) {
        this.father = father;
    }
    
    public ArrayList<XMLNode> getChildren() {
        return children;
    }
    
    public void setChildren(ArrayList<XMLNode> children) {
        this.children = children;
    }


}


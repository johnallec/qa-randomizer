package main.model.xml;

import java.util.ArrayList;
import main.model.pdf.elements.PDFElement;

public class XMLNode {

    private XMLNode father;
    private ArrayList<XMLNode> children;
    private PDFElement element;

    public XMLNode() {
        this.children = new ArrayList<>();
    }

    public XMLNode(PDFElement element) {
        this.element = element;
        this.children = new ArrayList<>();
    }
    
    public void addChild(XMLNode child) {
        if(child != null) this.children.add(child);
    }

    public XMLNode getFirstChild() {
        return this.children.get(0);
    }

    public XMLNode getLastChild() {
        return this.children.get(this.children.size()-1);
    }

    public ArrayList<XMLNode> getChildrenByTagName(String tagName) {
        ArrayList<XMLNode> result = new ArrayList<>(); 
        for(XMLNode child : this.children)
            if(child.getElement().getTagName().equals(tagName))
                result.add(child);
        return result;
    }

    public XMLNode getChild(int i) {
        return this.children.get(i);
    }

    public int numOfChildren() {
        return this.children.size();
    }
    
    public XMLNode getFather() {
        return father;
    }
    
    public void setFather(XMLNode father) {
        this.father = father;
    }

    public ArrayList<XMLNode> getChildren() {
        return this.children;
    }
    
    public void setChildren(ArrayList<XMLNode> children) {
        this.children = children;
    }

    public PDFElement getElement() {
        return this.element;
    }

    public void setElement(PDFElement element) {
        this.element = element;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n------------------------------\n");
        builder.append("Tag name: " + this.element.getTagName() +  "\n");
        builder.append("Attributes: " + this.element.getAttributes().keySet() + "\n");
        builder.append("Children:");
        for(XMLNode node : this.children)
            builder.append(" " + node.element.getTagName());
        builder.append("\n-----------------------------\n");
        return builder.toString();
    }

}


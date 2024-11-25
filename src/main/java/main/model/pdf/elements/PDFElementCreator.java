package main.model.pdf.elements;

import org.w3c.dom.Node;

import main.model.Tags;
import main.model.xml.XMLNode;

public class PDFElementCreator {

    public void setPDFElement(String tagName, XMLNode xmlNode) {
        switch(tagName) {
            case Tags.pdf:
                xmlNode.setElement(new PDFMainElement());
                break;
            case Tags.text:
                xmlNode.setElement(new TextElement());
                break;
            case Tags.image:
                xmlNode.setElement(new ImageElement());
                break;
            case Tags.section:
                xmlNode.setElement(new SectionElement());
                break;
            default:
                System.out.println("No element found in setXMLNodeElement -> XMLNodeTree");
                xmlNode.setElement(new SkippableElement());
                break;
        }
    }

    public PDFElement createPDFElement(String tagName) {
        switch(tagName) {
            case Tags.pdf: return new PDFMainElement();
            case Tags.text: return new TextElement();
            case Tags.image: return new ImageElement();
            case Tags.section: return new SectionElement();
            default:
                System.out.println("No element found in setXMLNodeElement -> XMLNodeTree");
                return new SkippableElement();
        }
    }

    public PDFElement createPDFElement(Node node) {
        switch(node.getNodeName()) {
            case Tags.pdf: return new PDFMainElement(node);
            case Tags.text: return new TextElement(node);
            case Tags.image: return new ImageElement(node);
            case Tags.section: return new SectionElement(node);
            default:
                return new SkippableElement(node);
        }
    }

}

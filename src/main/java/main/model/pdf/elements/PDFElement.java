package main.model.pdf.elements;

import java.util.HashMap;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import main.model.Attributes;
import main.model.Tags;

public abstract class PDFElement {

    protected String text;
    protected String tagName;
    protected Node domNode;
    private HashMap<String,String> attributes;

    protected PDFElement() {
        this.attributes = new HashMap<>();
    }

    protected PDFElement(Node domNode) {
        this.domNode = domNode;
        this.text = domNode.getTextContent();
        this.tagName = domNode.getNodeName();
        this.attributes = new HashMap<>();
        setAttributes();
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTagName(){
        return this.domNode.getNodeName();
    }
    
    public void setDomNode(Node domNode) {
        this.domNode = domNode;
        this.text = domNode.getTextContent();
        this.tagName = domNode.getNodeName();
        setAttributes();
    }

    public HashMap<String,String> getAttributes() {
        return this.attributes;
    }

    public Node getDomNodeChildNode(int index){
        return this.domNode.getChildNodes().item(index);
    }

    public int getDomNodeChildNodesLength() {
        return this.domNode.getChildNodes().getLength();
    }

    private void setAttributes() {
        
        NamedNodeMap nodeMap = this.domNode.getAttributes();
        
        if(nodeMap == null) return;

        for(int i = 0; i < nodeMap.getLength(); i++) {
            switch(this.tagName) {
                case Tags.image: {
                    Node imageSourceNode = nodeMap.getNamedItem(Attributes.Image.Source.name);
                    if( imageSourceNode != null )
                        this.attributes.put(Attributes.Image.Source.name, imageSourceNode.getTextContent());
                    break;
                }
                case Tags.section: {
                    Node sectionSymbolNode = nodeMap.getNamedItem(Attributes.Section.Symbol.name);
                    if(  sectionSymbolNode != null )
                        this.attributes.put(Attributes.Section.Symbol.name, sectionSymbolNode.getTextContent());
                    Node sectionIndentNode = nodeMap.getNamedItem(Attributes.Section.Indent.name);
                    if(  sectionIndentNode != null )
                            this.attributes.put(Attributes.Section.Indent.name, sectionIndentNode.getTextContent());
                }
                default: {
                    Node textFontNode = nodeMap.getNamedItem(Attributes.Text.Font.name);
                    if(textFontNode != null && Attributes.Text.Font.values.containsKey(textFontNode.getTextContent()))
                        this.attributes.put(Attributes.Text.Font.name, textFontNode.getTextContent());
                    Node textSizeNode = nodeMap.getNamedItem(Attributes.Text.Size.name);
                        if( textSizeNode != null )
                            this.attributes.put(Attributes.Text.Size.name, textSizeNode.getTextContent());
                }
            }
            //if new attributes are added, it should be extended to those too
        }
    }

}

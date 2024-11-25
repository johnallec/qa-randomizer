package main.model.pdf;

import java.io.IOException;
import java.util.LinkedList;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import main.model.Attributes;
import main.model.GenericFile;
import main.model.pdf.elements.ImageElement;
import main.model.pdf.elements.PDFElement;
import main.model.pdf.elements.PDFMainElement;
import main.model.pdf.elements.SectionElement;
import main.model.pdf.elements.TextElement;
import main.model.xml.XMLNode;
import main.model.xml.XMLNodeTree;

public class PDFFile extends GenericFile {

    private XMLNodeTree tree;

    protected PDFFile() {
        super();
    }

    protected PDFFile(String title) {
        super(title);
    }

    protected PDFFile(String path, String title) {
        super(path,title);
    }

    protected PDFFile(String title, LinkedList<PDFElement> elements) {
        super(title);
    }

    public void setXMLNodeTree(XMLNodeTree tree) {
        this.tree = tree;
    }

    @Override
    public void generateDocument() throws IOException {
        if(this.tree == null) {
            System.out.println("Set the XML node tree first. generateDocument() -> PDFFile");
            return;
        }
        try(PdfWriter writer = new PdfWriter(getCompletePath());
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc)) {
            iterateElementsRic(this.tree.getRoot(), document);    
        }
    }

    private void iterateElementsRic(XMLNode currentNode, Document document) {
        buildElement(currentNode, document);
        for(XMLNode child : currentNode.getChildren())
            iterateElementsRic(child, document);
    }

    private void buildElement(XMLNode elementNode, Document document) {
        if(elementNode.getElement() instanceof PDFMainElement)
            return;
        else if(elementNode.getElement() instanceof SectionElement) {
            buildQABlocks(elementNode, document);
        }
        else if(elementNode.getElement() instanceof TextElement textElement)
            document.add(new Paragraph().add(textElement.getText()));
        else if(elementNode.getElement() instanceof ImageElement imageElement)
            try {
                document.add(new Image(ImageDataFactory.create(imageElement.getAttributes().get("src"))));
            } catch (Exception e) {
                System.out.println("Image problem, buildElements() -> PDFFile");
                e.printStackTrace();
            }
        else {
            //System.out.println("Building the elements, no association was found for " + elementNode.getElement().getTagName() + ". buildElements() -> PDFFile");
        }
    }

    private void buildQABlocks(XMLNode sectionNode, Document document) {
        SectionElement sectionElement = (SectionElement) sectionNode.getElement();
        document.add(new Paragraph(sectionElement.getQuestion()));
        List list = new List();
        Attributes.Utilities.applyAttributes(list, sectionNode);
        for(String answer : sectionElement.getAnswers())
            list.add(answer);
        document.add(list);
    }
}
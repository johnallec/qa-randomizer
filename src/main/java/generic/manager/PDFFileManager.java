package generic.manager;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import generic.model.PDFFile;
import generic.model.QABlock;
import generic.model.Section;
import java.io.IOException;

public class PDFFileManager {

    public PDFFileManager() {}

    public void create(PDFFile pdfFile) {
        if(pdfFile == null) return;
        try (PdfWriter writer = new PdfWriter(pdfFile.getCompletePath());
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf)){
            for(Section section : pdfFile.getSections())
                buildSection(section,document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildSection(Section s, Document document) {
        for(QABlock block : s.getBlocks())
            buildBlocks(block,document);
    }

    private void buildBlocks(QABlock block, Document document) {
        document.add(new Paragraph(block.getQuestion()));
        List list = new List().setListSymbol("-").setSymbolIndent(8);
        for(String answer : block.getAnswers())
            list.add(answer);
        document.add(list);
    }

}

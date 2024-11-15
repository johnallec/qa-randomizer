package generic.model.manager;

import java.io.IOException;
import java.util.LinkedList;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import generic.model.GenericFile;
import generic.model.QABlock;
import generic.model.Section;

public class PDF {

    public class PDFFileManager implements Manager {

        private PDFFile pdfFile;

        public PDFFileManager() {
            this.pdfFile = new PDFFile();
        }

        public PDFFileManager(String title) {
            this.pdfFile = new PDFFile(title);
        }

        public PDFFileManager(String path, String title) {
            this.pdfFile = new PDFFile(path, title);
        }

        public PDFFile getPDFFile() {
            return this.pdfFile;
        }

        @Override
        public void manage() {
            if(pdfFile == null) return;
            try {
                pdfFile.generateDocument();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class PDFFile extends GenericFile<Document> {

        private LinkedList<Section> sections;

        private PDFFile() {
            super();
            this.sections = new LinkedList<>();
        }

        private PDFFile(String title) {
            super(title);
            this.sections = new LinkedList<>();
        }

        private PDFFile(String path, String title) {
            super(path,title);
            this.sections = new LinkedList<>();
        }

        private PDFFile(String title, LinkedList<Section> sections) {
            super(title);
            this.sections = sections;
        }

        public LinkedList<Section> getSections() {
            return this.sections;
        }

        public void setSections(LinkedList<Section> sections) {
            this.sections = sections;
        }

        public void addSection(Section section) {
            if(section != null) this.sections.add(section);
        }

        @Override
        protected void generateDocument() throws IOException {
            try(PdfWriter writer = new PdfWriter(getCompletePath());
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc)) {
            for(Section section : this.sections)
                buildSection(section,document);
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
}

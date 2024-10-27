package generic;

import generic.manager.PDFFileManager;
import generic.model.PDFFile;
import generic.model.QABlockBuilder;
import generic.model.Section;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        PDFFileManager manager = new PDFFileManager();

        PDFFile pdfFile = new PDFFile();
        pdfFile.setTitle("anotherPDFExample.pdf");

        QABlockBuilder blockBuilder = new QABlockBuilder();

        Section firstSection = new Section();
        firstSection.addBlock(blockBuilder.question("What is the company you work at rn?").answers("Cap4 Lab").answers("Capgemini").answers("NTT Data").build());

        Section secondSection = new Section();
        secondSection.addBlock(blockBuilder.question("What is the number of employees range Cap4 Lab has reached?").answers("0 - 100").answers("100 - 200").answers("200 - 300").build());

        Section thirdSection = new Section();
        thirdSection.addBlock(blockBuilder.question("What is the answer to ALL the questions?").answers("8").answers("48").answers("42").build());

        pdfFile.addSection(firstSection);
        pdfFile.addSection(secondSection);
        pdfFile.addSection(thirdSection);

        manager.create(pdfFile);
    }
}

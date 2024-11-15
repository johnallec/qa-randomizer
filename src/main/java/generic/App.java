package generic;

import generic.model.QABlockBuilder;
import generic.model.Section;
import generic.model.manager.PDF;


public class App
{
    public static void main( String[] args )
    {
        var manager = new PDF().new PDFFileManager("C:/Users/nuke/java-workspace/qa-randomizer-stuff/stuff/pdf/","pdfExample.pdf");

        QABlockBuilder blockBuilder = new QABlockBuilder();

        Section firstSection = new Section();
        firstSection.addBlock(blockBuilder.question("What is the company you work at rn?").answers("Cap4 Lab").answers("Capgemini").answers("NTT Data").build());

        Section secondSection = new Section();
        secondSection.addBlock(blockBuilder.question("What is the number of employees range Cap4 Lab has reached?").answers("0 - 100").answers("100 - 200").answers("200 - 300").build());

        Section thirdSection = new Section();
        thirdSection.addBlock(blockBuilder.question("What is the answer to ALL the questions?").answers("8").answers("48").answers("42").build());

        manager.getPDFFile().addSection(firstSection);
        manager.getPDFFile().addSection(secondSection);
        manager.getPDFFile().addSection(thirdSection);

        manager.manage();
    }
}

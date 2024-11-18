package generic;

import generic.model.manager.XML;


public class App
{
    public static void main( String[] args )
    {
        //java 17.0.13

        //pdfExample();

        XML xml = new XML();
        var xmlManager = xml.new XMLFileManager("C:/Users/nuke/java-workspace/qa-randomizer-stuff/stuff/xml/","inputExample.xml");
        xmlManager.manage();

    }
}

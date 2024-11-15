package generic.model.manager;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import generic.model.GenericFile;

public class XML {

    public class XMLFileManager implements Manager {

        private DocumentBuilder builder;
    
        public XMLFileManager(XMLFile xmlFile) {
            try {
                Document document = this.builder.parse(xmlFile.getCompletePath());
            }
            catch(IOException ioExc){
    
            }
            catch(SAXException saxEcp) {
    
            }
        }
        @Override
        public void manage() {}
    
    }
    
    private class XMLFile extends GenericFile {

        @Override
        public void generateDocument() throws Exception {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'generateDocument'");
        }

    

    }

}
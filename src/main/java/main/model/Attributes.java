package main.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.BlockElement;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import main.model.Attributes.Text.Font;
import main.model.xml.XMLNode;

public final class Attributes {

    public class Utilities {
        
        public static void applyAttributes(BlockElement blockElement, XMLNode xmlNode) {
            switch(xmlNode.getElement().getTagName()) {
                case Tags.pdf: break;
                case Tags.properties: break;
                case Tags.content: break;
                case Tags.text: {
                    applyTextAttributes((Paragraph) blockElement, xmlNode);
                    break;
                }
                case Tags.image: break;
                case Tags.section: {
                    applyListAttributes((List) blockElement, xmlNode); 
                    break;
                }
                default: break;
            }
        }
    
        private static void applyTextAttributes(Paragraph text, XMLNode xmlNode) {
            HashMap<String,String> textAttributes = xmlNode.getElement().getAttributes();
            
            if(textAttributes.isEmpty()) return;
            System.out.println(xmlNode.getElement().getTagName());
            if(textAttributes.get(Font.name) != null)
                try {
                    text.setFont(PdfFontFactory.createFont(Attributes.Text.Font.values.get(textAttributes.get(Font.name))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        private static void applyListAttributes(List list, XMLNode xmlNode) {
            HashMap<String,String> sectionAttributes = xmlNode.getElement().getAttributes();
            
            if(sectionAttributes.isEmpty()) return;
            
            if(sectionAttributes.get(Section.Symbol.name) != null)
                list.setListSymbol(sectionAttributes.get(Section.Symbol.name));
            
            if(sectionAttributes.get(Section.Indent.name) != null)
                list.setSymbolIndent(Float.parseFloat(sectionAttributes.get(Section.Indent.name)));
            
            if(sectionAttributes.get(Font.name) != null)
                try {
                    list.setFont(PdfFontFactory.createFont(Attributes.Text.Font.values.get(sectionAttributes.get(Font.name))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    
    public final class Text {

        public final class Font {
            public static final String name = "font";
            public static final HashMap<String,String> values = new HashMap<>(
                Map.ofEntries(
                    Map.entry("COURIER_BOLD","Courier-Bold"),
                    Map.entry("COURIER_OBLIQUE","Courier-Oblique"),
                    Map.entry("COURIER_BOLDOBLIQUE","Courier-BoldOblique"),
                    Map.entry("HELVETICA","Helvetica"),
                    Map.entry("HELVETICA_BOLD","Helvetica-Bold"),
                    Map.entry("HELVETICA_OBLIQUE","Helvetica-Oblique"),
                    Map.entry("HELVETICA_BOLDOBLIQUE","Helvetica-BoldOblique"),
                    Map.entry("SYMBOL","Symbol"),
                    Map.entry("TIMES_ROMAN","Times-Roman"),
                    Map.entry("TIMES_BOLD","Times-Bold"),
                    Map.entry("TIMES_ITALIC","Times-Italic"),
                    Map.entry("TIMES_BOLDITALIC","Times-BoldItalic"),
                    Map.entry("ZAPFDINGBATS","ZapfDingbats")
                )
            ); 
        }

        public final class Size {
            public static final String name = "size";
        }

    }

    public final class Section {
        
        public static final class Symbol {
            public static final String name = "symbol";
        }

        public static final class Indent {
            public static final String name = "indent";
        }

    }

    public final class Properties {

        public final class ApplyAll {
            public static final String name = "apply-all";
            public enum Value { True,False }
        }

    }

    public final class Image {

        public final class Source {
            public static final String name = "src";
        }

    } 

}

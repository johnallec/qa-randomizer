package main.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class Attributes {
    
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

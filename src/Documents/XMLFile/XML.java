package Documents.XMLFile;

import Documents.Document;

import java.util.List;

public class XML extends Document {

    public XML(List<String> words) {
        super(words);
    }

    @Override
    public  String toString(){
        StringBuilder xmlDoc= new StringBuilder();
        for (String word : words) {
            xmlDoc.append(word);
        }
        return  "Documents.XMLFile.XML " + xmlDoc ;
    }

    @Override
    public String analyze() {
        StringBuilder xmlDoc= new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == '<') {
                if (word.charAt(1) == '/') {
                    word = String.valueOf(word.toCharArray(), 2, word.length());
                } else {
                    word = String.valueOf(word.toCharArray(), 1, word.length());
                }
            }
            if (word.charAt(word.length() - 1) == '>') {
                word = String.valueOf(word.toCharArray(), 0, (word.length() - 1));
            }
            xmlDoc.append(word);
        }
        return xmlDoc.toString();
    }
}

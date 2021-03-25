package Documents.JSONFile;

import Documents.Document;

import java.util.List;

public class JSON extends Document {
    public JSON(List<String> words) {
        super(words);
    }

    @Override
    public String toString() {
        StringBuilder jsonDoc = new StringBuilder();
        for (String word : words) {
            jsonDoc.append(word).append(" ");
        }
        return "Documents.JSONFile.JSON " + jsonDoc;
    }

    @Override
    public String analyze() {
        StringBuilder jsonDoc = new StringBuilder();
        for (String word : words) {
            int indexColumns = words.indexOf(":");
            if (indexColumns > -1) {
                word = String.copyValueOf(word.toCharArray(), indexColumns, (word.length() - 1));
            }
            jsonDoc.append(word);
        }
        return jsonDoc.toString();
    }
}

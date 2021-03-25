package Documents;

import java.util.ArrayList;
import java.util.List;

public abstract class Document {
    protected List<String> words = new ArrayList<>(3);

    public Document(List<String> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return  "Documents" + words ;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public abstract String analyze();

}

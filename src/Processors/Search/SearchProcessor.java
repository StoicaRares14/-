package Processors.Search;

import Documents.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchProcessor {
    private final String toSearch;

    public SearchProcessor(String toSearch) {
        this.toSearch = toSearch;
    }

    public int Process(Document... docs) {
        String analyzedDoc;
        int cnt = 0;
        for (Document doc : docs) {
            analyzedDoc = doc.analyze();
            Matcher m = Pattern.compile(toSearch).matcher(analyzedDoc);
            while (m.find()) {
                cnt += 1;
            }
        }
        return cnt;
    }
}

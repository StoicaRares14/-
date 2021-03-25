package Processors.Composed;

import Documents.Document;
import Processors.Processor;
import Processors.Search.SearchProcessor;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ComposedProcessor {
    private List<Processor> compProcess;

    public ComposedProcessor(Processor ...processes) {
        Objects.requireNonNull(compProcess).addAll(Arrays.asList(processes));
    }

    public void addProcessor(Processor...processes){
        compProcess.addAll(Arrays.asList(processes));
    }

    public int Process(Document...docs){
        int cnt=0;
        for(Document doc:docs){
            for(Processor p:compProcess){
                if(p instanceof SearchProcessor){
                     cnt+=((SearchProcessor) p).Process(doc);
                }
                else ((ComposedProcessor)p).Process(doc);
            }
        }
        return cnt;
    }
}

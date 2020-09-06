package com.kdhm;

import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NERExample {

    public static void main(String[] args) throws IOException {

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        Parser p= new Parser();
        List<Parsed_data> v= p.parse();
//        System.out.println("BEFORE!!!!!!!!!!!");
//        System.out.println(" ");
//        System.out.println(" ");
//        System.out.println(" ");
//        System.out.println(" ");
//        for(Parsed_data a:v){
//            a.print();
//        }

        System.out.println("List size= "+v.size());
        String text = new String("");
        List <Processed_data> fin= new ArrayList<>();
        for(Parsed_data d: v){
            text = d.get_details();
            //System.out.println(text);
            CoreDocument coreDocument = new CoreDocument(text);

            stanfordCoreNLP.annotate(coreDocument);

            List<CoreLabel> coreLabels = coreDocument.tokens();
            int count =0;
            for (CoreLabel coreLabel : coreLabels) {
                if(count==0){
                    //System.out.print(text+" - ");
                    String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    //System.out.println(/*coreLabel.originalText() + " = " + */ner);
                    Processed_data n = new Processed_data(d, ner);
                    fin.add(n);
                }
                count++;
            }
        }
        for(Processed_data k: fin){
            k.println();
        }

    }
}

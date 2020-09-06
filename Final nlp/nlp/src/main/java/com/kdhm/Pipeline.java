package com.kdhm;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;
public class Pipeline {
    private static Properties properties;
    private static String propertiesName = "tokenize, ssplit, pos, lemma, ner, parse, sentiment, regexner";
    private static StanfordCoreNLP standfordCoreNLP;

    private Pipeline() {

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, regexner");
        properties.put("regexner.mapping", "/Users/dhiraj.h/IdeaProjects/stanford-corenlp-4.1.0/jg-regexner.txt");
    }

    public static StanfordCoreNLP getPipeline() {
        if(standfordCoreNLP == null) {
            standfordCoreNLP = new StanfordCoreNLP(properties);
        }

        return standfordCoreNLP;
    }
}

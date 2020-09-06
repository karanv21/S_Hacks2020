package com.kdhm.nerapplication.core;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Pipeline {

    private static Properties properties;
    private static String propertiesName = "tokenize, ssplit, pos, lemma, ner, regexner";
    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() {

    }
    static {
        properties = new Properties();
        properties.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, regexner");
        properties.put("regexner.mapping", "/Users/karanvasdev/IdeaProjects/stanford-corenlp-4.1.0/jg-regexner.txt");
    }

    @Bean(name = "stanfordCoreNLP")
    public static StanfordCoreNLP getInstance() {
        if(stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}

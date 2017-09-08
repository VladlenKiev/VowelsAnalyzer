package org.company.test.Parser;

import java.util.ArrayList;
import java.util.List;


public class ParserImpl implements Parser {
    List<String> listWords = new ArrayList<String>();


    @Override
    public List<String> parse(List<String> arrayListSentences) {

        for (int i = 0; i<arrayListSentences.size();++i){

            for (String word:arrayListSentences.get(i).split("\\s+")) {
                if (!isEnglishWord(normalizeWord(word)))
                    continue;
                listWords.add(normalizeWord(word));
            }
        }
        return listWords;
    }

    @Override
    public String normalizeWord(String word){
        return word.replaceAll("[()!?,.#%^&*_+=><~`{}]", "").toLowerCase().trim();
    }

    @Override
    public boolean isEnglishWord(String word){
        return word.matches("^[A-Za-z]+");
    }




}

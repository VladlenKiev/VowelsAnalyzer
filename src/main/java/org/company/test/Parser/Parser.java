package org.company.test.Parser;

import java.util.List;

/**
 * Created by admin on 05.09.2017.
 */
public interface Parser {

    List<String> parse(List<String> arrayListSentences);

    String normalizeWord(String word);

    boolean isEnglishWord(String word);
}

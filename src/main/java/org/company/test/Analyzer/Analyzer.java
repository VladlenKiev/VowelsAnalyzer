package org.company.test.Analyzer;

import org.company.test.Model.ResultModel;
import java.util.List;

public interface Analyzer {

    public String vowelCharByWord(String word);

    byte vowelCounterByWord(String word);

    public List<ResultModel> resultMaker(List<String> listWords);

}

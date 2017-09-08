package org.company.test.Analyzer.Impl;

import org.company.test.Analyzer.Analyzer;
import org.company.test.Model.ResultModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 08.09.2017.
 */
public class AnalyzerImpl implements Analyzer {


    @Override
    public String vowelCharByWord(String word) {

        String vowelResult = "";
        int[] arr = new int[255];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i)]++;
        }

        byte[] arrVowel = new byte[]{97, 101, 105, 111, 117, 121};
        for (int j = 0; j < arrVowel.length; j++) {
            if (arr[arrVowel[j]] > 0)
                vowelResult += (char) arrVowel[j];
        }

        return vowelResult;
    }

    @Override
    public byte vowelCounterByWord(String word) {
        byte countVowel = 0;

        int[] arr = new int[255];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i)]++;
        }

        byte[] arrVowel = new byte[]{97, 101, 105, 111, 117, 121}; //ASCII code for vowels
        for (int j = 0; j < arrVowel.length; j++) {
            if (arr[arrVowel[j]] > 0)
                countVowel += arr[arrVowel[j]];
        }

        return countVowel;
    }


    @Override
    public List<ResultModel> resultMaker(List<String> listWords) {
        List<ResultModel> resultModelList = new ArrayList<ResultModel>();

        for (int l = 0; l < listWords.size(); ++l) {
            String word = listWords.get(l);

            int[] arr = new int[255];
            for (int i = 0; i < listWords.get(l).length(); i++) {
                arr[word.charAt(i)]++;
            }

            resultModelList.add(new ResultModel(vowelCharByWord(word), (byte) word.length(), vowelCounterByWord(word)));
        }
        return resultModelList;
    }
}

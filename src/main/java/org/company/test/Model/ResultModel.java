package org.company.test.Model;

import java.util.Arrays;

public class ResultModel {
    private String charSequence;
    private byte wordLength;
    private byte vowelCount;


    public ResultModel(String charSequence, byte wordLength, byte vowelCount) {
        this.charSequence = charSequence;
        this.wordLength = wordLength;
        this.vowelCount = vowelCount;
    }


    public String toString() {
        return "(" +
                Arrays.asList((new String(charSequence)).split("(?!^)")) +
                ", " + wordLength +
                ") -> " + vowelCount +
                ')';
    }
}

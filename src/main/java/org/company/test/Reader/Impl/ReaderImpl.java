package org.company.test.Reader.Impl;

import org.company.test.Reader.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05.09.2017.
 */
public class ReaderImpl implements Reader {

    public List<String> readFile() {
        BufferedReader br = null;
        ArrayList<String> listSentences = null;

        try {
            br = new BufferedReader(new FileReader("INPUT.txt"));

            listSentences = new ArrayList<String>();
            String line = br.readLine();

            while (line != null) {
                listSentences.add(line);
                line = br.readLine();
            }
            System.out.println("File successful read.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listSentences;

    }

    public List<String> readFileForTest(BufferedReader reader) throws IOException {
        BufferedReader br = (BufferedReader) reader;
        ArrayList<String> listSentences = null;
            br = new BufferedReader(new FileReader("INPUT.txt"));

            listSentences = new ArrayList<String>();
            String line = br.readLine();

            while (line != null) {
                listSentences.add(line);
                line = br.readLine();
            }
            System.out.println("File successful read.");


        return listSentences;

    }
}

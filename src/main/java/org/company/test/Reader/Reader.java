package org.company.test.Reader;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 05.09.2017.
 */
public interface Reader {

    public List<String> readFile();

    public List<String> readFileForTest(BufferedReader reader) throws IOException;



    }

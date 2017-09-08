package org.company.test.Writer.Impl;

import org.company.test.Model.ResultModel;
import org.company.test.Writer.Writer;

import java.io.*;
import java.util.List;

public class WriterImpl implements Writer {
    @Override
    public void writeFile(List<ResultModel> resultWraper) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("OUTPUT.txt"));
            for (ResultModel content : resultWraper) {
                bw.write(content.toString());
                bw.newLine();
            }

            System.out.println("File was successful write.");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

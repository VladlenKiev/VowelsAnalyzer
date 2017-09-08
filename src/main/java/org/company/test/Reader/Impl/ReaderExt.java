package org.company.test.Reader.Impl;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;


public class ReaderExt implements org.company.test.Reader.Reader {
    private ArrayList<String> listSentencesTemp = new ArrayList<String>();
    private long totalBytesLeft;

    public List<String> readFile() {

        FileInputStream fIn = null;
        FileChannel fChan = null;
        ByteBuffer memoryBuffer;
        int bufSize = 50; //It can be depends from a memory size (Runtime.getRuntime().totalMemory())
        long fileSize;
        long totalBytesRead = 0;

        try {
            fIn = new FileInputStream("input.txt");
            fChan = fIn.getChannel();
            fileSize = fChan.size();
            memoryBuffer = ByteBuffer.allocate(bufSize);
            totalBytesLeft = fileSize;


            for (int bytesRead = fChan.read(memoryBuffer); bytesRead != -1; bytesRead = fChan.read(memoryBuffer)) {
                totalBytesRead += bytesRead;

                StringBuilder sbTemp = new StringBuilder();

                System.out.println(String.format("Read %d bytes from channel; total bytes read/fileSize %d/%d ", bytesRead,
                        totalBytesRead, fChan.size()));

                memoryBuffer.flip();

                byte[] chars0 = memoryBuffer.array();

                for (byte ch : chars0)
                    sbTemp.append((char) ch);

                listSentencesTemp = sentenceMaker(sbTemp);
                totalBytesLeft -= bytesRead;
                System.out.println("totalBytesLeft=" + totalBytesLeft);
            }

            System.out.println("File was successful read.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fIn.close();
                fChan.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listSentencesTemp;
    }

    @Override
    public List<String> readFileForTest(BufferedReader reader) throws IOException {
        return null;
    }

    private ArrayList<String> sentenceMaker(StringBuilder stringBuilder) {
        String[] strings = stringBuilder.toString().split("\\r");
        for (String s : strings)
            listSentencesTemp.add(s);

        return listSentencesTemp;
    }

    public long getTotalBytesLeft() {
        return totalBytesLeft;
    }

}

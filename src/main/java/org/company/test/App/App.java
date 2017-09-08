package org.company.test.App;

import com.carrotsearch.sizeof.RamUsageEstimator;
import org.company.test.Analyzer.Impl.AnalyzerImpl;
import org.company.test.Model.ResultModel;
import org.company.test.Parser.*;
import org.company.test.Reader.Impl.ReaderExt;
import org.company.test.Writer.Impl.WriterImpl;

import java.util.List;

/**
 * Created by admin on 08.09.2017.
 */
public class App {

    public static void main(String[] args) {
        ReaderExt readerExt = new ReaderExt();
        WriterImpl writer = new WriterImpl();
        ParserImpl parser = new ParserImpl();
        AnalyzerImpl analyzer = new AnalyzerImpl();

        List<String> listWords;
        List<ResultModel> listResultModel;
        List<String> listSentences;

        do {
            //1
            listSentences = readerExt.readFile();
            //2
            listWords = parser.parse(listSentences);
            //3
            listResultModel = analyzer.resultMaker(listWords);
            //4
            writer.writeFile(listResultModel);
        }while (readerExt.getTotalBytesLeft()>0);

        System.out.println("****************USED RAM*******************");
        System.out.println("Runtime.getRuntime().totalMemory()="+Runtime.getRuntime().totalMemory()/1024/1024+"Mb");
        System.out.println("Runtime.getRuntime().freeMemory()="+Runtime.getRuntime().freeMemory()/1024/1024+"Mb");
        System.out.println("USED RAM="+(Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory())/1024/1024+" Mb used");
        System.out.println("****************STATISTIC*******************");

        System.out.println("RamUsage(listSentences)="+ RamUsageEstimator.sizeOf(listSentences)+" bytes");
        System.out.println("RamUsage(listWords)="+RamUsageEstimator.sizeOf(listWords)+" bytes");
        System.out.println("RamUsage(listResultModel)="+RamUsageEstimator.sizeOf(listResultModel)+" bytes");
    }
}

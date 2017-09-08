import org.company.test.Model.ResultModel;
import org.company.test.Writer.Impl.WriterImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 07.09.2017.
 */
public class WriterTest {
    private WriterImpl writerImpl;
    private List<ResultModel> listWrapper;

    @Before
    public void init() {
        writerImpl = new WriterImpl();
        listWrapper = new ArrayList<ResultModel>();
        listWrapper.add(new ResultModel("ao",(byte)2,(byte)6));
        listWrapper.add(new ResultModel("aeo",(byte)3,(byte)7));

    }

    /*
    *It's not finish test with mock!
    *
     */
    @Test
    public void writeFileTest(){
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("line1", "line2", "line3");
        } catch (IOException e) {
            Assert.fail();
        }
    }
}

import org.company.test.Reader.Impl.ReaderImpl;
import org.company.test.Reader.Reader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 07.09.2017.
 */
public class ReaderTest {
    private ReaderImpl readerImpl;

    @Before
    public void init() {
        readerImpl = new ReaderImpl();
    }

    /*
    *It's not finish test with mock!
    *
     */
    @Test
    public void readFileTest(){
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("line1", "line2", "line3");
        } catch (IOException e) {
            Assert.fail();
        }
    }
    @Test
    public void readFileForTest() {
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        try {
        Mockito.when(bufferedReader.readLine()).thenReturn("line1", "line2", "line3");

        String result = readerImpl.readFileForTest(bufferedReader).get(0);
        Assert.assertEquals("Good Day!!!", result);
        } catch (IOException e) {
            Assert.fail();
        }
    }
}

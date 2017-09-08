import org.company.test.Analyzer.Analyzer;
import org.company.test.Analyzer.Impl.AnalyzerImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 07.09.2017.
 */

public class AnalyzerTest {
    private Analyzer analyzer;
    private List<String> listWords;

    @Before
    public void init() {
        analyzer = new AnalyzerImpl();
        listWords = new ArrayList<String>();
        listWords.add("platon");
        listWords.add("made");
        listWords.add("bamboo");
        listWords.add("boats");
    }

    @Test
    public void vowelCharByWordTest() {
        assertEquals("word must contain vowels", "ao", analyzer.vowelCharByWord(listWords.get(0)));
        assertEquals("word must contain vowels", "ae", analyzer.vowelCharByWord("made"));
        assertEquals("word must contain vowels", "aeio", analyzer.vowelCharByWord("Cooperative"));
    }

    @Test
    public void vowelCounterByWordTest(){
        assertEquals("word must contain company vowels", 2, analyzer.vowelCounterByWord(listWords.get(0)));
        assertEquals("word must contain company vowels", 2, analyzer.vowelCounterByWord("made"));
        assertEquals("word must contain company vowels", 6, analyzer.vowelCounterByWord("Cooperative"));
    }

    @Test
    public void testReturnValueDependentOnEnglishLetter() {
        Comparable c = Mockito.mock(Comparable.class);
        Mockito.when(c.compareTo(new String().matches("[^a-z]+"))).thenReturn(1);
        Mockito.when(c.compareTo(new String().matches("^[a-zA-Z]+"))).thenReturn(0);

        assertEquals(0, c.compareTo("pop"));
        assertEquals(0, c.compareTo("Hello"));
    }
}

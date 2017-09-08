import org.company.test.Parser.Parser;
import org.company.test.Parser.ParserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 07.09.2017.
 */
public class ParserTest {
    private Parser parser;
    private List<String> listWords;
    private List<String> arrayListSentences;

    @Before
    public void init() {
        parser = new ParserImpl();
        listWords = new ArrayList<String>();
        arrayListSentences = new ArrayList<String>();
            arrayListSentences.add("Platon made bamboo boats.");
        listWords = new ArrayList<String>();
            listWords.add("platon");
            listWords.add("made");
            listWords.add("bamboo");
            listWords.add("boats");


    }



    @Test
    public void normalizeWordTest(){
        assertEquals("stringTest must be normalized(odd spec symbols with Low case)", "hello", parser.normalizeWord("Hello, "));
        assertEquals("stringTest must be normalized(odd spec symbols with Low case)", "good", parser.normalizeWord("Good?!"));
        assertEquals("stringTest must be normalized(odd spec symbols with Low case)", "cooperative", parser.normalizeWord("!!Cooperative,!"));
    }

    @Test
    public void parseTest() {
        assertArrayEquals(listWords.toArray(), parser.parse(arrayListSentences).toArray());

        Assert.assertEquals("Wrong 1st element", "platon", parser.parse(arrayListSentences).get(0));
        Assert.assertEquals("Wrong 2nd element", "made", parser.parse(arrayListSentences).get(1));
        Assert.assertEquals("Wrong 3rd element", "bamboo", parser.parse(arrayListSentences).get(2));
    }

    @Test
    public void isEnglishWordTest(){
        assertEquals("word must be English letters", true, parser.isEnglishWord("Perfect"));
        assertEquals("word must be English letters", true, parser.isEnglishWord("Marker"));
        assertEquals("word must be English letters", false, parser.isEnglishWord("Корпорация"));
    }
}

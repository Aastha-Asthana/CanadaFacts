package cognizant.a471515.com.cfacts;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkForAppendedString(){
        String testString = "1 . Fact";
        FactsUtils utils = new FactsUtils();
        assertEquals(testString,utils.getAppendedFactsPosition(1,"Fact"));
    }

}
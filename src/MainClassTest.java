import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetClassString() {
        String a = getClassString();
        String hello = "ello";
        Assert.assertTrue("В сторке нет слов Hello или hello", a.contains(hello));
    }
}

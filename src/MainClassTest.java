import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetClassNumber() {
        int a = getClassNumber();
        Assert.assertTrue("Число меньше 45", a > 45);
    }
}

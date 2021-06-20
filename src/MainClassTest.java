import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void myTest() {
        int a = getLocalNumber();
        Assert.assertTrue("Число не равно 14", a == 14);
    }
}

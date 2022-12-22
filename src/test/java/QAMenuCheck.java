import org.junit.Test;
import ru.praktikum.MainPageObj;

public class QAMenuCheck extends TestPreloadData {
    @Test
    public void QAMenuCheckTest() {
        MainPageObj objFirst = new MainPageObj(driver);
        objFirst.checkQAMenu(8);
    }
}

import org.junit.Test;
import ru.praktikum.MainPageObj;
import ru.praktikum.OrderProcessObj;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class BottomCreateCheck extends TestPreloadData {

    @Test
    public void createBottomProcess() {
        MainPageObj obkMainPage = new MainPageObj(driver);
        obkMainPage.clickBottomButton();
        OrderProcessObj obkOrderProc = new OrderProcessObj(driver);
        obkOrderProc.setFirstTextFields("Петр", "Максимов", "г. Москва", "79877896655");
        obkOrderProc.selectMetroField();
        obkOrderProc.clickNextButton();
        obkOrderProc.setSecondTextFields("12.12.2022", "сутки", "grey", "Открыть дверь с ноги");
        obkOrderProc.clickOrderFinishButton();
        obkOrderProc.approveFinishPopUp();
        assertThat(obkOrderProc.confirmedOrderPopUp(), containsString("Номер заказа"));
    }

}

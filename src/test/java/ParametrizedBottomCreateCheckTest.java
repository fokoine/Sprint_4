import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.MainPageObj;
import ru.praktikum.OrderProcessObj;

@RunWith(Parameterized.class)
public class ParametrizedBottomCreateCheckTest extends TestPreloadData {
    private final String nameField;
    private final String surnameField;
    private final String adressField;
    private final String phoneField;
    private final String dateArrival;
    private final String arendPeriod;
    private final String colourField;
    private final String commentField;

    public ParametrizedBottomCreateCheckTest(String nameField, String surnameField, String adressField, String phoneField,
                                             String dateArrival, String arendPeriod, String colourField, String commentField) {
        this.nameField = nameField;
        this.surnameField = surnameField;
        this.adressField = adressField;
        this.phoneField = phoneField;
        this.dateArrival = dateArrival;
        this.arendPeriod = arendPeriod;
        this.colourField = colourField;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldsData() {
        return new Object[][]{
                {"Петр", "Васильев", "г Москва", "79877897878", "12.12.2023", "сутки", "grey","Открыть входную дверь с ноги"},
                {"Иван", "Йцукен", "г Люберцы", "79990009898", "12.01.2023", "двое суток", "black","Закрыть входную дверь с руки"},
        };
    }

    @Test
    public void ParametrizedTopCreateCheck () {
        MainPageObj obkMainPage = new MainPageObj(driver);
        obkMainPage.clickBottomButton();
        OrderProcessObj obkOrderProc = new OrderProcessObj(driver);
        obkOrderProc.setFirstTextFields(nameField, surnameField, adressField, phoneField);
        obkOrderProc.selectMetroField();
        obkOrderProc.clickNextButton();
        obkOrderProc.setSecondTextFields(dateArrival, arendPeriod, colourField, commentField);
        obkOrderProc.clickOrderFinishButton();
        obkOrderProc.approveFinishPopUp();
    }

}

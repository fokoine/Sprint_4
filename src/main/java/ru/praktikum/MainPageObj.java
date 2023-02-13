package ru.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObj {
    public WebDriver driver;
    public MainPageObj(WebDriver driver){
        this.driver = driver;
    }
    // Позиция печенья
    private By cookiePlace = By.className("App_CookieButton__3cvqF");
    // Позиция кнопки создания заявки верх
    private By orderButtonTop = By.xpath("//div[@class = 'Header_Nav__AGCXC']/button[text() = 'Заказать']");
    // Позиция кнопки создания заявки низ
    private By orderButtonBottom = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    // Поиск и проверка меню "Вопросы и ответы"
    public void checkQAMenu(int rowCount) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-7")));
        driver.findElement(By.id("accordion__heading-" + rowCount + "")).click();
    }
    // Поиск и проверка содержания текста для заголовка выпадайки
    public String checkQAMenuContentTitle(int rowCountTitle) {
        return driver.findElement(By.xpath("//div[@id = 'accordion__heading-" + rowCountTitle + "']")).getText();
    }
    // Поиск и проверка содержания текста в выпадайке
    public String checkQAMenuContentInnerContent(int rowCountInner) {
        return driver.findElement(By.xpath("//div[@aria-labelledby = 'accordion__heading-" + rowCountInner + "']/p")).getText();    }
    public void clickCookieButton() {
        WebElement element = driver.findElement(cookiePlace);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(cookiePlace).click();
    }
    // Кнопка "Заказать" верхняя
    public void clickTopButton() {
        driver.findElement(orderButtonTop).click();
    }
    // Кнопка "Заказать" нижняя
    public void clickBottomButton() {
        WebElement element = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonBottom).click();
    }
}

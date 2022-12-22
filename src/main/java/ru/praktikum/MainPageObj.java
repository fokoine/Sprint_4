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
    // Поиск и проверка меню "Вопросы и ответы"
    public void checkQAMenu(int rowCount) {
        WebElement element = driver.findElement(By.className("App_CookieButton__3cvqF"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-7")));
        for (int i = 0; i < rowCount; i++) {
            driver.findElement(By.id("accordion__heading-" + i + "")).click();
        }
    }
    // Кнопка "Заказать" верхняя
    public void clickTopButton() {
        driver.findElement(By.xpath("//div[@class = 'Header_Nav__AGCXC']/button[text() = 'Заказать']")).click();
    }
    // Кнопка "Заказать" нижняя
    public void clickBottomButton() {
        WebElement element = driver.findElement(By.xpath("//div[@class = 'Home_FinishButton__1_cWm']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
    }
}

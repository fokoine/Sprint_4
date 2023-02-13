package ru.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderProcessObj {
    private WebDriver driver;
    private String actual;
    // Поиск поля для имени
    private By nameField = By.xpath("//input[@placeholder = '* Имя']");
    // Поиск поля для фамилии
    private By surnameField = By.xpath("//input[@placeholder = '* Фамилия']");
    // Поиск поля для адреса
    private By adressField = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Поиск поля для телефона
    private By phoneField = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Поиск поля выбора метро
    private By metroField = By.xpath("//input[@placeholder = '* Станция метро']");
    // Поиск списка станций метро
    private By metroFieldFill = By.className("select-search__select");
    // Поиск поля даты доставки
    private By dateSelect = By.xpath("//input[@placeholder = '* Когда привезти самокат']");
    // Поиск селектора срока аренды
    private By arendaPeriod = By.xpath("//span[@class = 'Dropdown-arrow']");
    // Поиск поля коментария курьера
    private By courierFieldInput = By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    // Поиск кнопки на первом экране заполнения заказа
    private By firstFieldNextButton = By.xpath("//div[@class = 'Order_NextButton__1_rCA']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    // Поиск кнопки завершения заказа на втором экране
    private By orderFinishButton = By.xpath("//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    // Поиск кнопки подтверждения окончания заказа в всплывающем окне
    private By orderFinishPopUpButtonConfirm = By.xpath("//button[text() = 'Да']");
    // Текст в всплывающем окне оформленного заказа
    private By orderCreatedPopUp = By.xpath("//div[text() = 'Заказ оформлен']");
    public OrderProcessObj(WebDriver driver){
        this.driver = driver;
    }
        // Кнопка "Далее" на первой форме заполнения заказа
    public void clickNextButton() {
        driver.findElement(firstFieldNextButton).click();
    }
        // Кнопка "Заказать" окончательная после заполнения формы
    public void clickOrderFinishButton() {
        driver.findElement(orderFinishButton).click();
    }
    // Метод заполнения первого экрана формы
    public void setFirstTextFields(String name, String surname, String adress, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(adressField).sendKeys(adress);
        driver.findElement(phoneField).sendKeys(phone);
    }
    // Метод выбора станции метро
    public void selectMetroField() {
        driver.findElement(metroField).click();
        driver.findElement(metroFieldFill).click();
    }
    // Метод заполнения второга экрана формы
    public void setSecondTextFields(String whenArrive, String arendaInput, String colour, String commentForCourier) {
        driver.findElement(dateSelect).sendKeys(whenArrive);
        driver.findElement(arendaPeriod).click();
        driver.findElement(By.xpath("//div[text() = '" + arendaInput + "']")).click();
        driver.findElement(courierFieldInput).sendKeys(commentForCourier);
        driver.findElement(By.id("" + colour + "")).click();
    }
    public void approveFinishPopUp () {
        driver.findElement(orderFinishPopUpButtonConfirm).click();
    }
    public String confirmedOrderPopUp () {
        WebElement element = driver.findElement(orderCreatedPopUp);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return driver.findElement(orderCreatedPopUp).getText();
    }
}

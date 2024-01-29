package com.scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class OrderPage extends BasePage {
    //локатор для имя
    private By firstName = By.xpath(".//input[@placeholder = '* Имя']");
    //локатор для фамилии
    private By secondName = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор для адреса
    private By addss = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // локатор для метро
    private By fieldMetro = By.xpath(".//input[@placeholder = '* Станция метро']");

    //локатор номера телефона
    private By phoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //локатор кнопки "Далее"
    private By btnNext = By.xpath(".//button[text()='Далее']");

    //локатор надписи "Для кого самокат"

    private By label = By.xpath(".//div[text() = 'Для кого самокат']");

    private By selectMetroOptions = By.xpath(".//div[@class = 'select-search__select']");
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //проверка отображения надписи
    public boolean checkIsDisplayed(){
        return driver.findElement(label).isDisplayed();
    }

    //ввод имени
    public OrderPage setFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
        return this;
    }

    //ввод фамилии
    public OrderPage setSecondName(String surname){
        driver.findElement(secondName).sendKeys(surname);
        return this;
    }

    //ввод адреса
    public OrderPage setAddress(String address){
        driver.findElement(addss).sendKeys(address);
        return this;
    }
    //выбор станции метро
    public OrderPage selectStationMetroFromOptions(String stationMetro){
        driver.findElement(fieldMetro).click();
        final String metroOptionTemplate = ".//div[@class='Order_Text__2broi' and text()='%s']";
        String locator = String.format(metroOptionTemplate, stationMetro);
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }
    //Ввод номер телефона
    public OrderPage setPhoneNumber(String phNumber){
        driver.findElement(phoneNumber).sendKeys(phNumber);
        return this;
    }

    public ArendaPage clicBtnNext(){
        driver.findElement(btnNext).click();
        return new ArendaPage(driver);
    }




}
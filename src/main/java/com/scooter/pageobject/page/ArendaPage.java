package com.scooter.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArendaPage extends BasePage {

    //поле Когда сможете привезти самокат
    private By fieldDate = By.xpath(".//input[@placeholder= '* Когда привезти самокат']");
    private By fieldArenda = By.className("Dropdown-control");
    private By listDayArenda = By.className("Dropdown-option");

    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By btnOrder = By.xpath(".//button[contains(@class,'Middle')and text()='Заказать']");
    private By colorScooter = By.id("black");

    private By btnYes = By.xpath(".//button[@class and text() = 'Да']");

    private By orderCancelled = By.xpath(".//div[text()='Заказ оформлен']");
    public ArendaPage(WebDriver driver) {
        super(driver);
    }
    //выбора даты из календаря
    public ArendaPage selectDayFromOptions(String day){
        driver.findElement(fieldDate).click();
        final String dayOptionTemplate = ".//div[@aria-label='Choose %s']";
        String locator = String.format(dayOptionTemplate, day);
        driver.findElement(By.xpath(locator)).click();
        return this;
    }

    //Выбор аренды
    public ArendaPage selectArendaDayFromOptions(int day){
        driver.findElement(fieldArenda).click();
        driver.findElements(listDayArenda).get(day).click();
        return this;
    }

    public ArendaPage selectColor(String colorName){
        final String selectColorName = ".//input[@id= '%s']";
        String locator = String.format(selectColorName, colorName);
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }

    public ArendaPage setComment(String text){
        driver.findElement(comment).sendKeys(text);
        return this;
    }

    public ArendaPage clickBtnOrder(){
        driver.findElement(btnOrder).click();
        return this;
    }
    public ArendaPage clickBtnYes(){
        driver.findElement(btnYes).click();
        return this;
    }

    public boolean isOrderCancelled(){
        return driver.findElement(orderCancelled).isDisplayed();
    }

}

package com.scooter.pageobject.page;

import com.scooter.pageobject.fragments.SectionImportantQuestions;
import org.bouncycastle.oer.OERDecoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

//класс галвной
public class HomePageScooter extends BasePage {

    public HomePageScooter(WebDriver driver) {
        super(driver);
    }
    //раздел вопросов о важном
    SectionImportantQuestions sectionImortantQuestions = new SectionImportantQuestions(driver);

    //локатор для кнопки "Заказать" в header страницы
    private By btnOrderHeader = By.className("Button_Button__ra12g");
    //локатор для кнопки "Заказать" в центре страницы
    private By btnOrderCenter = By.xpath(".//button[contains(@class,'Button_Middle') and text()='Заказать']");

    //клик по кнопке заказать в header
    public OrderPage clickBtnOrderHeader(){
        driver.findElement(btnOrderHeader).click();
        return new OrderPage(driver);
    }

    //скрол по кнопке в центре
        public OrderPage scrollBtnOrderCenter() {
            WebElement element = driver.findElement(btnOrderCenter);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return new OrderPage(driver);
        }

    }





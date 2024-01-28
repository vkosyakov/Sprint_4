package com.scooter.pageobject.fragments;

import com.scooter.pageobject.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SectionImportantQuestions extends BasePage {
    private By questionsImportant = By.xpath(".//div[text()='Вопросы о важном']");
    //локатор до списка элементов вопросы
    private By qustions = By.className("accordion__button");
    // локатор до списка элементов ответов
    private By answers = By.className("accordion__panel");
    private By imgScoter = By.xpath(".//img[@src = '/assets/ya.svg']");

    public SectionImportantQuestions(WebDriver driver) {
        super(driver);
    }

    //ожидание загрузки картинки со скутером

    public SectionImportantQuestions waitImgScoter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(imgScoter));
        return this;
    }


    //Скролл до раздела "Вопросы о важном"
    public SectionImportantQuestions scrollToQuestionsImportant() {
        WebElement element = driver.findElement(questionsImportant);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    //взять текст у ответа
    public String getTextAnswer(int numberAnswer){
        //список вопросов
        List<WebElement> qustionsList = driver.findElements(qustions);
        qustionsList.get(numberAnswer).click();
        //список ответов
        List<WebElement> answerList = driver.findElements(answers);
        return answerList.get(numberAnswer).getText();
    }
}

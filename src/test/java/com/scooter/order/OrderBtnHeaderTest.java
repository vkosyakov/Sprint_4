package com.scooter.order;

import com.scooter.BaseTest;
import com.scooter.pageobject.page.ArendaPage;
import com.scooter.pageobject.page.HomePageScooter;
import com.scooter.pageobject.page.OrderPage;
import org.junit.Assert;
import org.junit.Test;

public class OrderBtnHeaderTest extends BaseTest {

    @Test
    public void checkOnOrderPageTest1(){
        //тест через кнопку "Заказать" в header
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickBtnOrderHeader();
        OrderPage orderPage = new OrderPage(driver);
        ArendaPage arendaPage = new ArendaPage(driver);
        Assert.assertTrue(orderPage.checkIsDisplayed());

       orderPage.setFirstName("Влад")
                .setSecondName("Бушмелев")
                .setAddress("ул.Тургеньева дом 53")
                .selectStationMetroFromOptions("Чистые пруды")
                .setPhoneNumber("88005553535")
                .clicBtnNext()
                .selectDayFromOptions("четверг, 4-е января 2024 г.")
                .selectArendaDayFromOptions(4)
                .selectColor("black")
                .setComment("Первый тест")
                .clickBtnOrder()
                .clickBtnYes();
        Assert.assertTrue(arendaPage.isOrderProcessed());
    }
    @Test
    public void checkOnOrderPageTest2(){
        //тест через кнопку "Заказать" в header
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickBtnOrderHeader();
        OrderPage orderPage = new OrderPage(driver);
        ArendaPage arendaPage = new ArendaPage(driver);
        Assert.assertTrue(orderPage.checkIsDisplayed());

        orderPage.setFirstName("Сергей")
                .setSecondName("Чуприянов")
                .setAddress("ул.Пушкина д.124")
                .selectStationMetroFromOptions("Комсомольская")
                .setPhoneNumber("89025698714")
                .clicBtnNext()
                .selectDayFromOptions("среда, 31-е января 2024 г.")
                .selectArendaDayFromOptions(1)
                .selectColor("grey")
                .setComment("Второй тест")
                .clickBtnOrder()
                .clickBtnYes();
        Assert.assertTrue(arendaPage.isOrderProcessed());
    }

}

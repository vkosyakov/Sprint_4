package com.scooter.testChrome;

import com.scooter.BaseTest;
import com.scooter.pageobject.page.ArendaPage;
import com.scooter.pageobject.page.HomePageScooter;
import com.scooter.pageobject.page.OrderPage;
import org.junit.Assert;
import org.junit.Test;

public class OrderBtnHeaderTest extends BaseTest {

    @Test
    public void checkInputDateOnOrderPage(){
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
                .setComment("123")
                .clickBtnOrder()
                .clickBtnYes();
        Assert.assertTrue(arendaPage.isOrderCancelled());
    }



}

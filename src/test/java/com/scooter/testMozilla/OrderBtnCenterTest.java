package com.scooter.testMozilla;

import com.scooter.BaseTest;
import com.scooter.pageobject.page.ArendaPage;
import com.scooter.pageobject.page.HomePageScooter;
import com.scooter.pageobject.page.OrderPage;
import org.junit.Assert;
import org.junit.Test;

public class OrderBtnCenterTest extends BaseTest {
    @Test
    public void checkInputDateOnOrderPage(){
        //тест через кнопку "Заказать" в header
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.scrollBtnOrderCenter();
        OrderPage orderPage = new OrderPage(driver);
        ArendaPage arendaPage = new ArendaPage(driver);
        Assert.assertTrue(orderPage.checkIsDisplayed());

        orderPage.setFirstName("Андрей")
                .setSecondName("Рублев")
                .setAddress("ул. Пушкина дом 111")
                .selectStationMetroFromOptions("Тропарёво")
                .setPhoneNumber("89052365898")
                .clicBtnNext()
                .selectDayFromOptions("вторник, 23-е января 2024 г.")
                .selectArendaDayFromOptions(2)
                .selectColor("grey")
                .setComment("Второй тест")
                .clickBtnOrder()
                .clickBtnYes();
        Assert.assertTrue(arendaPage.isOrderCancelled());
    }
}


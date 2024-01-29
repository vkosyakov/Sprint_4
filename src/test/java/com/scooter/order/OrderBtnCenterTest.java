package com.scooter.order;

import com.scooter.BaseTest;
import com.scooter.pageobject.page.ArendaPage;
import com.scooter.pageobject.page.HomePageScooter;
import com.scooter.pageobject.page.OrderPage;
import org.junit.Assert;
import org.junit.Test;

//проверка до ввода параметров заказа -- "Для кого самокат"
public class OrderBtnCenterTest extends BaseTest {
    @Test
    public void checkInputDateOnOrderPage(){
        //тест через кнопку "Заказать" в header
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.scrollBtnOrderCenter();
        OrderPage orderPage = new OrderPage(driver);
        Assert.assertTrue(orderPage.checkIsDisplayed());
    }
}


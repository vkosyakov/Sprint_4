package com.scooter.order;

import com.scooter.BaseTest;
import com.scooter.pageobject.page.ArendaPage;
import com.scooter.pageobject.page.HomePageScooter;
import com.scooter.pageobject.page.OrderPage;
import org.junit.Assert;
import org.junit.Test;
<<<<<<< HEAD
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderBtnHeaderTest extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;

    private final int arenda;
    private final String day;
    private final String color;
    private final String comment;
    private final boolean result;

    public OrderBtnHeaderTest(String name, String surname, String address, String metro, String phoneNumber, String day, int arenda, String color, String comment, boolean result) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.day = day;
        this.arenda = arenda;
        this.color = color;
        this.comment = comment;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getOrder() {
        return new Object[][]{
                {"Влад", "Бушмелев", "ул.Тургеньева дом 53", "Чистые пруды", "88005553535", "четверг, 4-е января 2024 г.", 4,
                        "black", "Первый тест",true},
        {
            "Сергей", "Чуприянов", "ул.Пушкина д.124", "Комсомольская", "89025698714", "среда, 31-е января 2024 г.", 1,
                    "grey", "Второй тест",true
        },
    }

    ;
}
    @Test
    public void checkOnOrderPageTest(){
=======

public class OrderBtnHeaderTest extends BaseTest {

    @Test
    public void checkOnOrderPageTest1(){
>>>>>>> origin/develop
        //тест через кнопку "Заказать" в header
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickBtnOrderHeader();
        OrderPage orderPage = new OrderPage(driver);
        ArendaPage arendaPage = new ArendaPage(driver);
        Assert.assertTrue(orderPage.checkIsDisplayed());

<<<<<<< HEAD
       orderPage.setFirstName(name)
                .setSecondName(surname)
                .setAddress(address)
                .selectStationMetroFromOptions(metro)
                .setPhoneNumber(phoneNumber)
                .clicBtnNext()
                .selectDayFromOptions(day)
                .selectArendaDayFromOptions(arenda)
                .selectColor(color)
                .setComment(comment)
                .clickBtnOrder()
                .clickBtnYes();
        Assert.assertEquals(arendaPage.isOrderProcessed(),result);
=======
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
>>>>>>> origin/develop
    }

}

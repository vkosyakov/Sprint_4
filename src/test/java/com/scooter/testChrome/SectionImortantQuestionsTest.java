package com.scooter.testChrome;

import com.scooter.BaseTest;
import com.scooter.pageobject.fragments.SectionImportantQuestions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SectionImortantQuestionsTest extends BaseTest {
    private final String ansver;
    private final int numberAnsver;

    public SectionImortantQuestionsTest(String ansver, int numberAnsver) {
        this.ansver= ansver;
        this.numberAnsver = numberAnsver;
    }

    @Parameterized.Parameters
    public static Object[][] getAnsver() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"TESTДопустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.",3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.",7},


        };
    }

    @Test
    public void ansverTest() {
        SectionImportantQuestions sectionImortantQuestions = new SectionImportantQuestions(driver);
        sectionImortantQuestions.waitImgScoter().scrollToQuestionsImportant();
        Assert.assertEquals(ansver,sectionImortantQuestions.getTextAnsver(numberAnsver));
    }


}

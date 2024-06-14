import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class Masha_Test030624 {
    @BeforeAll
    static void ba() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 120_000;
    }


    @Test
    void Test1() {

        //1. Открыть сайт "https://www.wildberries.ru/";
        //2. Выбрать вкладку "Продавайте с wildberries";
        //3. Нажать кнопку "Стать партнером";

        open("https://www.wildberries.ru/");
        $("#searchInput").should(exist);
        $("[data-wba-header-name='Seller']").click();
        switchTo().window(1);
        $(byText("Стать партнёром")).closest("button").click();
        sleep(10000);
        $(byText("Введите номер телефона, чтобы войти или зарегистрироваться")).should(exist);
        sleep(10000);


    }

        @Test
        void Test2() {
            open("https://market.yandex.ru/");

            sleep(1000);
            $(byText("Продавайте на Маркете")).click();
            sleep(5000);
            $(byText("class=lc-styled-text")).click();
            sleep(5000);

        }

    @Test
    void Dz2() {
        open("https://msk.top-academy.ru/");
        sleep(120_000);
        $(withText("Мероприятия")).should(exist);
        SelenideElement a;
        File b;
        a =$(withText("Мероприятия"));
        a.should(exist);
        b = takeScreenShot(a);

        System.out.println(b);
        a = $("h2.title__h2.center");
        a.should(exist);
        b = takeScreenShot(a);
        System.out.println(b);

       }

    @Test
    void Text3() {
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");

            $(By.xpath("(//input[@name='sum'])[2]")).setValue("100");
            $("[name=sum]", 0).setValue("333");


        }


    @Test
    void Text4() {
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        ElementsCollection ec;
        SelenideElement se;
        ec = $$("name='sum");
        System.out.println("Найдено элементов:" + ec. size());
        ec.get(1).setValue("100");
        sleep(1000);
        }
    }
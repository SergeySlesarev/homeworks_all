import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class Masha_WB {
    @Test
    void Test1() {
//1. Открыть сайт "https://www.wildberries.ru/";
//2. Выбрать вкладку "Продавайте с wildberries";
//3. Нажать кнопку "Стать партнером";
        open("https://www.wildberries.ru/");
        $(byText("Продавайте на Wildberries")).click();
//Я попробовал распознать на странице разные элементы, но они не распознавались
//Я решил посмотреть код веб-страницы, чтобы понять, почему элементы не находятся:
//System.out.println(source());
//и увидел, что это не та страница. Проще это проверить, посмотрев адрес:
//System.out.println("URL: >" + url() + "<");
//У нас 2 открытых вкладки, но Selenide почему-то не перешёл на новую вкладку
//Для того, чтобы перейти на 2-ю вкладку, надо выполнить следующую команду
//Нумерация начинается с нуля, поэтому 2-я вкладка имеет индекс 1
        //System.out.println("URL: >" + url() + "<");
        switchTo().window(1);
        //System.out.println("URL: >" + url() + "<");
        $(withText("Торговать может")).should(exist);

        // $(byText("[type=button]")).click();
        //$("[class=FormPhoneInputBorderless__input-wrapper--OC7KT]").should(exist);
        // sleep(5000);
    }
}
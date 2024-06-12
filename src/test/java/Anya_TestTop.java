import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;


import static com.codeborne.selenide.Condition.exist;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Anya_TestTop {

    @Test
    void home_work() {
        Configuration.pageLoadTimeout = 120_000;
        open("https://msk.top-academy.ru/");
        sleep(8000);
        $(byText("Принять")).click();

        SelenideElement a;
        File b;

        a = $(withText("Мероприятия"));
        a.should(exist);
        b = takeScreenShot(a);
        System.out.println(b);
        sleep(5000);

        a = $("h2.title__h2.center");
        a.should(exist);
        b = takeScreenShot(a);
        System.out.println(b);
        sleep(5000);

    }

}
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Ivan_DOMASHKA1 {
    @Test
    void ScreenShot () {
        open("https://msk.top-academy.ru");
        SelenideElement a;
        File b;

        a = $(withText("Мероприятия"));
        a.should(exist);
        b = takeScreenShot(a);
        System.out.println(b);

    }
}

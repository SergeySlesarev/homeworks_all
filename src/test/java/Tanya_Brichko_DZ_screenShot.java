import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Tanya_Brichko_DZ_screenShot {
    @Test
    void screenShot() {
        open("https://msk.top-academy.ru/");
        $(".close_banner").click();
        $(".header__top").shouldBe(exist);
        $(byText("Мероприятия")).shouldBe(exist);
        String screenshot1 = screenshot("screenshot_events");
        System.out.println(screenshot1);

    }
    @Test
    void screenShot1() {
        open("https://msk.top-academy.ru/");
        $(".close_banner").click();
        $(".header__bottom").shouldBe(exist);
        $(byText("Мероприятия")).shouldBe(exist);
        takeScreenShot($(".header__bottom"));

    }

    @Test
    void screenShot2() {
        open("https://msk.top-academy.ru/");
        sleep(3000);
        $(".close_banner").click();
        $(".cookies-confirm").shouldBe(visible).click();
        sleep(3000);

        $(".header__bottom").shouldBe(exist);
        $(byText("Мероприятия")).shouldBe(exist);
        File screenshot_file1 = takeScreenShot($(".header__bottom"));
        System.out.println("Скриншот 1 элемента: " + screenshot_file1.getPath());
        sleep(2000);

        $("main.home-page > section.home-events > div.title > h2.title__h2.center").shouldBe(exist);
        $(withText("Мероприятия")).shouldBe(exist);
        File screenshot_file2 = takeScreenShot($("h2.title__h2.center"));
        System.out.println("Скриншот 2 элемента: " + screenshot_file2.getPath());
        sleep(2000);

        $("main.home-page > section.home-events > a.home-events__btn.btn.btn-primary.btn-animate").shouldBe(exist);
        $(withText("Мероприятия")).shouldBe(exist);
        File screenshot_file3 = takeScreenShot($("a.home-events__btn.btn.btn-primary.btn-animate"));
        System.out.println("Скриншот 3 элемента: " + screenshot_file3.getPath());
        sleep(2000);

    }
}

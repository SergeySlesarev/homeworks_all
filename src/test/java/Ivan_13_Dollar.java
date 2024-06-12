import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Ivan_13_Dollar {
    @Test
    void Test1() {
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $("body > form > div:nth-child(1) > input[type=text]").shouldBe(exist);
        $("body > form > div:nth-child(1) > input[type=text]").setValue("100");
        $("[type=submit]").click();
        $(byText("Вы внесли 100 рублей")).shouldBe(exist);
        $("#sum").shouldHave(text("100"));
        sleep(10000);
    }

    @Test
    void Test2() {
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $("body > form > div:nth-child(3) > input[type=text]").shouldBe(exist);
        $("body > form > div:nth-child(3) > input[type=text]").setValue("100");
        $("[type=submit]").click();
        $(byText("Вы внесли 100 долларов")).shouldBe(exist);
        $("#sum").shouldHave(text("100"));
        sleep(10000);
    }

    @Test
    void Test3() {
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        $("body > form > div:nth-child(5) > input[type=text]").shouldBe(exist);
        $("body > form > div:nth-child(5) > input[type=text]").setValue("100");
        $("[type=submit]").click();
        $(byText("Вы внесли 100 евро")).shouldBe(exist);
        sleep(10000);
    }
}

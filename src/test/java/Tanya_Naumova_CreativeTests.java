import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Tanya_Naumova_CreativeTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void CartTest() {
        open("https://snowqueen.ru");
        sleep(5000);

        // закрыть всплывающее окно с подтверждением города
        $("[data-testid=cityConfirmButton]").click();

        //кликнуть по лупе
        $("i.sq-icons.icon-search.cl-black").click();
        sleep(5000);

        //в появившейся строке поиска ввести значение "шуба" и нажать Enter
        $("[id=search]").setValue("Шуба").pressEnter();

        //убрать сообщение о куки
        $("[data-testid=closeCookieButton]").click();

        //убедиться, что поиск произведен по введенному слову
        $("[data-testid=categoryTitle]").shouldHave(text("шуба"));
        sleep(5000);

        //кликом выбрать первое изображение из представленного каталога (уже не первое)
        $("a[href='/product/shuba-iz-ovchiny-670061003']").click();

        //убедиться, что кнопка "Добавить в корзину" появилась
        $(byText("Добавить в корзину")).should(exist);

        //нажать на кнопку "Добавить в корзину"  выбранный товар
        $(byText("Добавить в корзину")).click();

        //нажать на значок корзины в правом верхнем углу
        $("[data-testid=openMicrocart]").click();

        //убедиться по артикулу, что выбранный товар находится в корзине
        $("[data-testid=productSku").shouldHave(text("670061003"));
    }



        @Test
        void NoProductTest_Logo() {
        open("https://snowqueen.ru");

        $("i.sq-icons.icon-search.cl-black").click();
        sleep(5000);

//      ввести значение, которого нет в каталоге
        $("[id=search]").setValue("собака").pressEnter();

//        убедится, что появляется сообщение о том, что "Товары не найдены"
        $(byText("Товары не найдены!")).should(appear);
        sleep(5000);

//        убедиться, что на странице есть логотип сайта,
//        при нажатии на который осуществляется переход на главную страницу
        $("[data-testid=headerLogo]").should(appear).click();
        sleep(5000);

        }
    }



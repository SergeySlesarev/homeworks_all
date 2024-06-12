import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.ElementsCollection;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Denis_topAcademyForm {

    public void validDataTest() {
        String url = "https://msk.top-academy.ru/";
        Selenide.open(url);

        // Обработка всплывающего окна с куками
        if ($(".cookies-confirm").exists()) {
            $(".cookies-confirm").click();
        }

        String screenshotsDir = System.getProperty("user.dir") + File.separator + "screenshots";
        new File(screenshotsDir).mkdirs();

        // Создание скриншотов всех элементов с текстом "мероприятия"
        ElementsCollection elements = $$(Selectors.byText("мероприятия"));
        int count = 0;
        for (var element : elements) {
            String filename = "element-" + count++ + ".png";
            File screenshot = element.screenshot();
            if (screenshot != null) {
                screenshot.renameTo(new File(screenshotsDir, filename));
            }
        }
    }

    public static void main(String[] args) {
        Denis_topAcademyForm topAcademyForm = new Denis_topAcademyForm();
        topAcademyForm.validDataTest();
    }
}
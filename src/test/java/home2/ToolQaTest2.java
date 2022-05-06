package home2;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Configuration.baseUrl;
import  static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.open;

public class ToolQaTest2 {
    @BeforeAll
    static void beforeAll() {

       baseUrl = "https://demoqa.com";
       browserSize = "1920x1880";

    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Vito"); // имя
        $("#lastName").setValue("Korleone"); // фамилия
        $("#userEmail").setValue("baron@boroda.com"); // почта
        $(byText("Male")).click(); // пол
        $("#userNumber").setValue("0123456789"); // номер телефона
        $("#dateOfBirthInput").click(); // календарь
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1900");
        $("[aria-label$='December 7th, 1900']").click();
        $("#subjectsInput").setValue("Commerce").pressEnter(); // доожность
        $(byText("Music")).click(); // хобби
        $("#uploadPicture").uploadFromClasspath("img/1.png"); // фото
        $("#state").scrollTo().click();

        // $(byText("hobbies-checkbox-1")).parent().click();

        $("#currentAddress").setValue("Sicily"); // адрес
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive")
                .parent().shouldHave(text("Vito Korleone"),text("baron@boroda.com"),
                        text("Male"),text("0123456789"), text("07 December,1900"),
                        text("Commerce"), text("Music"), text("1.png"), text("Sicily"), text("Haryana Karnal"));


    }


}






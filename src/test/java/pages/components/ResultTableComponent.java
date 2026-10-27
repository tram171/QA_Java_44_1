package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private SelenideElement resultTable = $(".table-responsive");

    public ResultTableComponent checkCell(String key, String value) {
        resultTable
                .$(byText(key))
                .sibling(0)
                .shouldHave(text(value));
        return this;
    }
}



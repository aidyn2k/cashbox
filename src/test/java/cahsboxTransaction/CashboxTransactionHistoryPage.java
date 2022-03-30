package cahsboxTransaction;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Owner("aidyn2k")
public class CashboxTransactionHistoryPage extends TestBase {

    @Test
    @Feature("Проверка раздела Касса - Транзакции")
    @DisplayName("Проверка фильтра за Вчера")
    @Link(name = "RB", url = "https://rahmetbiz.chocodev.kz/cashbox/orders")
    public void filterByYesterday() {
        $(".vue-daterange-picker.mr-3.date-selector > div").click();
        $("[data-range-key='Вчера']").click();
        $(".btn-success").click();

        $(".vue-daterange-picker.mr-3.date-selector > div").shouldHave(text("Вчера"));
        $("h3").shouldHave(text("Транзакции за вчера"));
        $(".filters-reset").shouldBe(visible);
    }
}

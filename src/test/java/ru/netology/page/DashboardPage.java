package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");

    private ElementsCollection buttons = $$("[data-test-id=\"action-deposit\"] .button__content");

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public void verifyIsDashboardPage() {
        heading.shouldBe(visible);
    }

    public CardReplenishmentPage replenishmentCard(int index) {
        buttons.get(index).click();
        return new CardReplenishmentPage();
    }

    public int getCardBalance(int index) {
        String text = cards.get(index).getText();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public void assertBalance(int index, int expected) {
        int actual = getCardBalance(index);
        assertEquals(expected, actual);
    }
}

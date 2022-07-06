package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;

import ru.netology.page.CardReplenishmentPage;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

public class MoneyTransferSteps {

    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private static CardReplenishmentPage cardReplenishmentPage;


    @Пусть("пользователь залогинен с именем {string} и паролем {string} и с верификационным кодом {string}")
    public void userLogin(String login, String password, String code) {
        loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        verificationPage = loginPage.validLogin(login, password);
        dashboardPage = verificationPage.validVerify(code);
    }

    @Когда("пользователь нажимает на кнопку 'Пополнить' для {int} карты")
    public void getCardReplenishmentPage(int index) {
        cardReplenishmentPage = dashboardPage.replenishmentCard(index);
    }

    @Когда("пользователь вводит сумму перевода {int} для перевода с карты {int}")
    public void filledDataForReplenishment(int amount, int indexCardFrom) {
        dashboardPage = cardReplenishmentPage.filledData(amount, indexCardFrom);
    }

    @Тогда("итоговая сумма для первой карты {int}")
    public void getCardBalanceForFirstCard(int expected) {
        int index = 0;
        dashboardPage.assertBalance(index, expected);
    }

    @Тогда("итоговая сумма для второй карты {int}")
    public void getCardBalanceForSecondCard(int expected) {
        int index = 1;
        dashboardPage.assertBalance(index, expected);
    }
}

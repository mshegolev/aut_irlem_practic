package io.cucumber.zituorden;

import io.cucumber.java.After;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.net.MalformedURLException;
import java.util.Map;

public class MyStepdefs {
    ApplicationManager app;

    {
        try {
            app = new ApplicationManager();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    AccountData userData = new AccountData();


    @Тогда("В браузере открыта страница авторизации")
    public void в_браузере_открыта_страница_авторизации() {
        if (!app.getNavigationHelper().isLoginPageOpen()) throw new AssertionError();
    }

    @Когда("Пользователь ввел {string} и {string}")
    public void пользовательВвелЛогинИПароль(String login, String password) {
        System.out.println("fill form for: " + login + " " + password);
        userData.login = login;
        userData.password = password;
        app.getAccountHelper().fillLoginForm(userData);
    }

    @И("Нажал кнопку {string}")
    public void нажалКнопку(String btnName) {
        System.out.println("нажал кнопку: " + btnName);
        app.getNavigationHelper().clickButtonByName(btnName);
    }

    @Тогда("Открылась главная страница сайта")
    public void открыласьГлавнаяСтраницаСайта() {
        System.out.println("открылась страница");
        assert app.getNavigationHelper().isUserLogged();
    }

    @Тогда("На сайте видно поля {string} и {string} пользователя")
    public void наСайтеВидноПоляИмяИФамилияПользователя(String name, String surname) {
        System.out.println("получиили фио:" + name + " " + surname);
        Map fio = app.getNavigationHelper().getUserData();
        if (!fio.get("name").equals(name)) throw new AssertionError();
        if (!fio.get("surname").equals(surname)) throw new AssertionError();
        userData.name = (String) fio.get("name");
        userData.surname = (String) fio.get("surname");
    }

    @Когда("Пользователь нажал на кнопку {string}")
    public void пользовательНажалНаКнопку(String arg0) {
        System.out.println("нажал кнопку");

    }

    @Дано("Открыть в браузере ссылку: {string}")
    public void открытьВБраузереСсылкуСсылка(String url) {
        app.getNavigationHelper().openUrl(url);
    }

    @After("@Закрытьбраузер")
    public void tearDown() {
        app.stop();
    }

}

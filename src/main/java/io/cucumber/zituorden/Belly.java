package io.cucumber.zituorden;


import java.net.MalformedURLException;

public class Belly {
    public void eat(int cukes) {
        String result = "i eat cukes: " + cukes;
        System.out.println(result);
    }

    public void waiting(Integer int1) {
        String result = "i waite: " + int1;
        System.out.println(result);
    }

    public void growl() {
        System.out.println("Belly growl");

    }

    protected void login() throws MalformedURLException {
        ApplicationManager app = new ApplicationManager();
        System.out.println("login");
        app.getNavigationHelper().openMainPage();
        AccountData account = new AccountData();
        account.username = "test001";
        account.password = "001test";
        System.out.println("fill form");
        app.getAccountHelper().fillLoginForm(account);
        System.out.println("click login btn");
        app.getNavigationHelper().clickButtonLogin();
        System.out.println("exit");
        boolean result = app.getNavigationHelper().exit();
        System.out.println("check");
        assert result == true;
        System.out.println("stop app");
        app.stop();
    }
}

package io.cucumber.zituorden;

public class AccountData {
    public String login;
    public String password;
    public String name;
    public String surname;


    public AccountData() {
    }

    public AccountData(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

}

package io.cucumber.zituorden;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class StepDefinitions {

    Belly belly = new Belly();

    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        System.out.println(cukes);
        try {
            belly.login();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        belly.eat(cukes);
    }

    @When("I wait {int} hour")
    public void i_wait_hour(Integer int1) {
        belly.waiting(int1);
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        belly.growl();
    }

}
package io.cucumber.zituorden;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        features="src/test/resources/io/cucumber/zituorden",
        tags = "@all",
        dryRun = false)
public class RunCucumberTest {

}


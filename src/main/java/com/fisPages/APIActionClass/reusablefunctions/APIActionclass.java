package com.fisPages.APIActionClass.reusablefunctions;

import com.fisPages.APIActionClass.Util.restFunctions;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class APIActionclass extends restFunctions {

    private static String employeeURL = "https://api.coindesk.com/v1/bpi/currentprice.json";
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    public static Scenario scenario;
    public Scenario getScenario() {
        return scenario;
    }

    public void writeScenarioEvidence(String message) {
        try {
            getScenario().log(message);
        } catch (NullPointerException e) {
            System.out.println(message);
        }
    }
    public void executeGetREquest() {
        get(employeeURL);
        Response res = getResponse();
        System.out.println(res.asPrettyString());
        writeScenarioEvidence(res.asPrettyString());
    }

}

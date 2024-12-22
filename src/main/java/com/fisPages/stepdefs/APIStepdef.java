package com.fisPages.stepdefs;

import com.fisPages.APIActionClass.reusablefunctions.APIActionclass;
import io.cucumber.java.en.When;

public class APIStepdef
{
    APIActionclass actionclass=new APIActionclass();
    @When("request is triggered with GET method")
    public void requestIsTriggeredWithGETMethod()
    {
        actionclass.executeGetREquest();
    }

}

package com.fisPages.stepdefs;

import com.fisPages.DigitalWindow.digitalServicesFunctions;
import com.fisPages.UIActions.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UIStepDef
{
    private LoginPage loginPage=new LoginPage();
    private digitalServicesFunctions digitalServicesFunctions=new digitalServicesFunctions();


    @Given("^Launch the ebay website$")
    public void launchApplication()
    {
        loginPage.launchMottoWebsite();

    }
    @And("^Accept the cookies$")
    public void acceptTheCookies()
    {
        loginPage.selectLanguage();

    }
//   @After
    public void closeBrowser()
    {
        loginPage.closeBrowser();
    }

    @When("^Click on the Mott Homepage$")
    public void clickOnTheMottHomepage()
    {
        loginPage.clickHomePage();
    }

    @Then("^HomePage is displayed$")
    public void homepageIsDisplayed()
    {
        loginPage.verifyTitleOfHomePage();
    }

    @Given("^Click on the \"([^\"]*)\" section$")
    public void clickOnTheDigitalSection(String sectionName)
    {
        digitalServicesFunctions.navigateToSection(sectionName);

    }

    @And("^Click on the \"([^\"]*)\" link$")
    public void clickOnTheSubLink(String subSection)
    {
        digitalServicesFunctions.navigateToSubServices(subSection);
    }

    @And("^Scroll to the Transformation \"([^\"]*)\" section$")
    public void scrollToTheTransformationSection(String section) {
        digitalServicesFunctions.scrollToChangeSection(section);

    }

    @When("^click on the Transformation \"([^\"]*)\" section$")
    public void clickOnTheTransformationSection(String section) {
        digitalServicesFunctions.clickOnChangeSection(section);
    }

    @And("^Enter the first name as \"([^\"]*)\"$")
    public void enterTheFirstNameAs(String name)
    {
        digitalServicesFunctions.inputFirstName(name);
    }

    @And("^Enter the Surname as \"([^\"]*)\"$")
    public void enterTheSurnameAs(String name) {
        digitalServicesFunctions.inputSurname(name);
    }

    @And("^Enter the Email address as \"([^\"]*)\"$")
    public void enterTheEmailAddressAs(String email) {
        digitalServicesFunctions.inputEmail(email);
    }

    @And("^Select the Service as \"([^\"]*)\" from dropdown list$")
    public void selectTheServiceAsFromDropdownList(String value)
    {
        digitalServicesFunctions.selectServices(value);

    }
    @When("click on the Send now button")
    public void clickOnTheSendNowButton()
    {
        digitalServicesFunctions.clickSendButton();
    }

    @Then("^Form should be submitted successfully$")
    public void formShouldBeSubmittedSuccessfully() throws InterruptedException {
        digitalServicesFunctions.verifySubmitMessage();
    }
    @Before
    public void setScenarioName(Scenario scenarioName)
    {
        loginPage.setScenario(scenarioName);

    }

    @When("^search for the \"([^\"]*)\" in ebay search bar$")
    public void searchForTheInEbaySearchBar(String searchText)
    {
        loginPage.inputSearchTextbox(searchText);

    }

    @And("^click on the first \"([^\"]*)\" book in the list$")
    public void clickOnTheFirstBookInTheList(String bookNum) {
        loginPage.selectProduct(bookNum);
    }

    @And("^click on the \"([^\"]*)\" button on product page$")
    public void clickOnTheButtonOnProductPage(String buttonName)
    {
        loginPage.clickButton(buttonName);

    }

    @Then("^cart is updated with product details$")
    public void cartIsUpdatedWithProductDetails()
    {
        loginPage.verifyShoppingCart();
    }

    @And("^switch to the another tab$")
    public void switchToTheAnotherTab()
    {
        loginPage.switchToTab();
    }



}

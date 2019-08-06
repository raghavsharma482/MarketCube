package Steps;

import Pages.LoginPage;
import Utilities.ConfigLoader;
import com.typesafe.config.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
    Config conf = ConfigLoader.load();
    LoginPage loginPage;

    @Given("^User is on login page$")
    public void userIsOnLoginPage() {
        loginPage.iAmOnHomePage();
        loginPage.login();
    }

    @When("^I enter username and password$")
    public void iEnterUsernameAndPassword() {
    }

    @And("^I enter the password as the password$")
    public void iEnterThePasswordAsThePassword() {
    }

    @Then("^I should be redirected to the home page of marketcube$")
    public void iShouldBeRedirectedToTheHomePageOfMarketcube() {
    }

    @When("^User click on menu$")
    public void userClickOnMenu() {
        loginPage.menuButton();
    }

    @Then("^Click on filter button$")
    public void clickOnFilterButton() {
        loginPage.filterButton();
    }

    @And("^click on a approved product$")
    public void clickOnAApprovedProduct() {
        loginPage.approved();
    }

    @And("^edit the title$")
    public void editTheTitle() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.title();
        loginPage.description();
        loginPage.uploadShortFile();
    }

    @And("^Sku will be entered$")
    public void skuWillBeEntered() {
        loginPage.sku();
    }

    @And("^Barcode will be entered$")
    public void barcodeWillBeEntered() {
        loginPage.barcode();
    }

    @And("^Submit the changes$")
    public void submitTheChanges() {
        loginPage.Submit1();
    }

    @And("^Go to product list page$")
    public void goToProductListPage() {
        loginPage.approve();

    }

    @And("^click on search textbox$")
    public void clickOnSearchTextbox() {
        loginPage.search();
    }

    @Then("^Status should be approved$")
    public void statusShouldBeApproved() {
        loginPage.statusCheck();
    }

    @And("^Upload image more then ten mb$")
    public void uploadImageMoreThenTenMb() throws Exception {
        loginPage.title();
        loginPage.description();
        loginPage.uploadLargeFile();
    }

    @Then("^File size must be less than ten MB$")
    public void fileSizeMustBeLessThanTenMB() {
        loginPage.validationMessageCheck();
    }

    @And("^logout from seller$")
    public void logoutFromSeller() {
        loginPage.logout();
    }


}

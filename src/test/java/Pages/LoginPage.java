package Pages;

import Utilities.ConfigLoader;
import com.typesafe.config.Config;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class LoginPage<bool> extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade email;
    @FindBy(xpath = "//button[@class='Polaris-Header-Action']")
    private WebElementFacade menu;
    @FindBy(id = "password")
    private WebElementFacade password;
    @FindBy(xpath = "//button[@id='submitButton']")
    private WebElementFacade submit;
    @FindBy(xpath = "//div[contains(text(),'Products')]")
    private WebElementFacade prod;
    @FindBy(xpath = "//span[contains(text(),'Filter')]")
    private WebElementFacade filter;
    @FindBy(xpath = "//button[contains(text(),'Punjabi')]")
    private WebElementFacade approvedProduct;
    @FindBy(id = "title")
    private WebElementFacade title;
    @FindBy(xpath = "//*[@id='tinymce']")
    private WebElementFacade description;
    @FindBy(xpath = "//span[contains(text(),'Add image')]")
    private WebElementFacade add;
    @FindBy(id = "sku")
    private WebElementFacade sku;
    @FindBy(id = "barcode")
    private WebElementFacade bar;
    @FindBy(id = "submitButton")
    private WebElementFacade Submit1;
    @FindBy(xpath = "//span[contains(text(),'View all products here.')]")
    private WebElementFacade approve;
    @FindBy(id = "TextField1")
    private WebElementFacade search;
    @FindBy(xpath = "//span[@class='text-capitalize'][contains(text(),'Approved')]")
    private WebElementFacade status;
    @FindBy(xpath = "//p[@class='Polaris-Heading']")
    private WebElementFacade validationMessage;
    @FindBy(xpath = "//button[@class='Polaris-TopBar-Menu__Activator']")
    private WebElementFacade logout;
    @FindBy(xpath = "//div[contains(text(),'Log Out')]")
    private WebElementFacade logoutButton;


    private static Config conf = ConfigLoader.load();
    private static String shortImage = "C:\\Users\\raghavs\\Downloads\\FrameWorkPractice\\src\\test\\resources\\testData\\Capture.PNG";
    private static String largeImage = "C:\\Users\\raghavs\\Downloads\\FrameWorkPractice\\src\\test\\resources\\testData\\DSC_0356.JPG";

    private static void setEnvironMent(String environment) {
        System.setProperty("env", environment);
        conf = ConfigLoader.load();
    }

    public void iAmOnHomePage() {
        setEnvironMent("test");
        getDriver().get(conf.getString("base_url"));
    }

    public void login() {
        email.click();
        email.sendKeys("marketcube.qa@gmail.com");
        password.click();
        password.sendKeys("Password1234!");
        submit.click();
    }

    public void menuButton() {
        menu.click();

        prod.click();

    }

    public void filterButton() {
        filter.click();

    }

    public void approved() {
        approvedProduct.click();

    }

    public void title() throws InterruptedException {
        Thread.sleep(2000);
        title.clear();
        title.sendKeys("Punjabi");

    }

    public void description() {
        getDriver().switchTo().frame("description_ifr");
        description.clear();
        description.sendKeys("hello this is a punjabi coat");
        getDriver().switchTo().defaultContent();
    }

    private void uploadFile(String filePath) throws InterruptedException {
        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        System.out.println("File Uploaded Successfully  ");
    }

    public void uploadShortFile() throws InterruptedException {
        waitABit(5000);
        Scroll.to(By.xpath("//span[contains(text(),'Add image')]"));
        waitFor(add).click();
        this.uploadFile(shortImage);
    }

    public void uploadLargeFile() throws InterruptedException {
        waitABit(5000);
        Scroll.to(By.xpath("//span[contains(text(),'Add image')]"));
        waitFor(add).click();
        this.uploadFile(largeImage);
    }

    public void sku() {
        sku.clear();
        sku.sendKeys("1234567890");

    }

    public void barcode() {
        bar.clear();
        bar.sendKeys("paytm karo");
    }

    public void Submit1() {
        submit.click();
    }

    public void approve() {
        approve.click();

    }

    public void search() {
        search.sendKeys("punjabi");
    }

    public void statusCheck() {
        String statusCheck = status.getText();
        Assert.assertEquals(statusCheck, "Approved");
        System.out.println("Assertion passed");
    }

    public void validationMessageCheck() {
        String validationCheck = validationMessage.getText();
        System.out.println(validationCheck);
        Assert.assertEquals(validationCheck, "Some of the images were ignored:");
        System.out.println("Assertion of validation message is passed");

    }

    public void logout() {
        logout.click();
        logoutButton.click();
    }

}



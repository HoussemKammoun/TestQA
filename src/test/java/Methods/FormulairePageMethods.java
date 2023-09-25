package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormulairePageMethods {
    private WebDriver driver;
    private String baseUrl = "https://testqa.purse.tech/fake-contact";

    ///////////////////////////////////////////////////////////////////////////////
    /////////////////////Locators/////////////////////////////////////////////////
    private By titleLocator = By.xpath("//*[@id='contact-form']/h2");
    private By genderDropdownLocator = By.id("gender");
    private By firstNameInputLocator = By.id("first-name");
    private By lastNameInputLocator = By.id("last-name");
    private By companyInputLocator = By.id("company");
    private By phoneInputLocator = By.id("phone");
    private By messageTitleInputLocator = By.id("message-title");
    private By messageTextareaLocator = By.id("message");
    private By submitButtonLocator = By.id("submit-button");
    private By messagePopupLocator = By.id("popin-message");

    public FormulairePageMethods(WebDriver driver) {
        this.driver = driver;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////Methods////////////////////////////////////////////////////////////////////////
    
    // Navigate to the contact page
    public void navigateToContactPage() {
        System.setProperty("webdriver.chrome.driver", "Ressources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    // check the title exist
    public void assertTitleIsCorrect() {
        WebElement titleElement = driver.findElement(titleLocator);
        String pageTitle = titleElement.getText();
        Assert.assertEquals(pageTitle, "Contactez-nous", "Le titre de la page n'est pas correct.");
    }

    // Set data which enable us to set a message
    public void setMessage() {
        Select dropdown = new Select(driver.findElement(genderDropdownLocator));
        dropdown.selectByVisibleText("Femme");

        WebElement firstNameInput = driver.findElement(firstNameInputLocator);
        firstNameInput.clear();
        firstNameInput.sendKeys("UserFirstName");

        WebElement lastNameInput = driver.findElement(lastNameInputLocator);
        lastNameInput.clear();
        lastNameInput.sendKeys("UserName");

        WebElement companyInput = driver.findElement(companyInputLocator);
        companyInput.clear();
        companyInput.sendKeys("Société Test");

        WebElement phoneInput = driver.findElement(phoneInputLocator);
        phoneInput.clear();
        phoneInput.sendKeys("0708050203");

        WebElement messageTitleInput = driver.findElement(messageTitleInputLocator);
        messageTitleInput.clear();
        messageTitleInput.sendKeys("TESTQA");

        WebElement messageTextarea = driver.findElement(messageTextareaLocator);
        messageTextarea.clear();
        messageTextarea.sendKeys("Hello, this is an automation framework");
    }

    // click on the submit btn
    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }

    // check that the good message after sending a message
    public void assertMessageReceived() {
        WebElement messageElement = driver.findElement(messagePopupLocator);
        String actualMessage = messageElement.getText();
        Assert.assertEquals(actualMessage, "Le message a été envoyé.", "Le message reçu ne correspond pas au message attendu.");
    }

    // hook to close browser after test execusion
    public void closeBrowser() {
    driver.close();

        
    }
    
}

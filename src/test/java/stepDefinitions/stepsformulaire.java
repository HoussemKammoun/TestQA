package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Methods.FormulairePageMethods;
import io.cucumber.java.After;

public class stepsformulaire {
    private WebDriver driver;
    private FormulairePageMethods formulairePage;

    // Step to navigate to the contact
    @When("I navigate to the contact page")
    public void i_navigate_to_the_contact_page() {
        formulairePage = new FormulairePageMethods(driver);
        formulairePage.navigateToContactPage();
    }

    // Step to check that the title exist
    @Then("I see Contactez-nous as a title")
    public void all_formulaire_elements_are_good() {
    formulairePage.assertTitleIsCorrect();

   }
   // Step to set a message via the formulaire contact
   @When("I set a message to contact purseteck")
    public void i_set_a_message_to_contact_purseteck() {
    formulairePage.setMessage();
  }
// Step to click on the submit btn
@When("I click on submit btn")
    public void i_click_on_submit_btn() {
    formulairePage.clickSubmitButton();
}
// Step to check that the message was added successfully
@Then("the message is saved successfully")
public void the_message_is_saved_successfully() {
    formulairePage.assertMessageReceived();
}

// hooks to close the browser after the test execution
@After
    public void teardown() {
        formulairePage.closeBrowser();

    }


}

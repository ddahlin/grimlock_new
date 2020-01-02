import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.InputField;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class InputFieldTest {
    public InputField inputField;
    @BeforeMethod(groups = "fyber9")
    public void initPxp() throws Exception {

    }

    @Test(groups = "fyber9")
    public void inputFieldTest() throws Exception {
        inputField = new InputField();
        inputField.applicationBuilder.setUpAdInApp(inputField.tremorAdTypeVastXml.inputfieldUrl);
        inputField.clickOnBug();
        inputField.insertTextIntoInputField();
        inputField.clickOnCloseButton();

    }
}



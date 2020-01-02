package GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import org.apache.log4j.Logger;
import static GrimlockAdTesting.TestUtils.EventEnums.*;


import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;


public class InputField extends Pxp {
    private static final Logger logger = Logger.getLogger(Pxp.class);
    public ApplicationBuilder applicationBuilder;

    public InputField() {
        applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
    }

    public void insertTextIntoInputField() throws Exception {
        Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.INPUTFIELD_INPUTFIELD_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080, "Test For Input Field");
        logger.info("Input field filled with text");
//        Grimlock.eventService().trackEvents(NAVIGATE_CLOSE_CLICK.toString());
//        logger.info("Assert - NAVIGATE CLOSE CLICK");
    }
}

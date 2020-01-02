package GrimlockAdTesting.TremorVideoAdType;

import GrimlockAdTesting.TestUtils.TremorAdTypeVastXml;
import GrimlockFramework.DriverCommands.GrimlockDriver;

import static GrimlockAdTesting.TestUtils.EventEnums.INTERACT_BUG_CLICK;
import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class VastGeneralCommands {
    public TremorAdTypeVastXml tremorAdTypeVastXml;
    GrimlockDriver grimlockDriver;

    public VastGeneralCommands() {
        tremorAdTypeVastXml = new TremorAdTypeVastXml();
        tremorAdTypeVastXml.downloadMdFileAndExtractToVast3XmlUrl();
        grimlockDriver  = Grimlock.grimlockDriver();
    }

    public void clickOnBug() {
        try {
            grimlockDriver.clickOnImageLocation(ImageConstants.IMAGE_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,RELAXED,30000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Grimlock.eventService().trackEvents(INTERACT_BUG_CLICK.toString());
    }

    public void clickOnOldBug() {
        try {
            grimlockDriver.clickOnImageLocation(ImageConstants.OLDBUG_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.OLDBUG_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,30000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Grimlock.eventService().trackEvents(INTERACT_BUG_CLICK.toString());
    }
}

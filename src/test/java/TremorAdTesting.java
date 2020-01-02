import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.TremorVideoNY;
import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import GrimlockEventHandler.NetworkSniffer.Charles.CharlesParsers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class TremorAdTesting {
    @BeforeMethod(groups = "AdTesting")
    public void initTremorVideoAds_JW_3203_RML() throws Exception {
        TremorVideoNY tremorVideoNY = new TremorVideoNY();
        Grimlock.eventService().setParseEventFunction(CharlesParsers::extractNYPixelName, CharlesParsers::getUnixTimeFromJson);
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(),Grimlock.params());
        applicationBuilder.setUpAdInApp(tremorVideoNY.getUrl("3203"));
    }
    @Test(groups = "AdTesting")
    public void JW_3203_RML_TestingEvent()throws Exception{
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.NEWYORKIMAGES_ADPLAY_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1031);
        Grimlock.eventService().trackEvents("creative_impression");
        Grimlock.eventService().trackEvents("desktop_screen_impression");
        Grimlock.eventService().trackEvents("impression");
        Grimlock.eventService().trackEvents("creative_impression");
        Grimlock.eventService().trackEvents("impression");
        Grimlock.grimlockDriver().waitUntilImageLocationFound(ImageConstants.NEWYORKIMAGES_ADVIDEO_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1031);
        Grimlock.grimlockDriver().waitUntilImageLocationFound(ImageConstants.NEWYORKIMAGES_VIDEOCONTENT_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1502);
    }
}

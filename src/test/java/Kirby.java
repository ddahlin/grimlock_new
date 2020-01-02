import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class Kirby {
    @Test(groups = "kirby")
    public void Kirby_Test()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("http://localhost/login");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.KIRBY_KIRBYREDIRECTEDLOGIN_BASEELEMENTID_DOCUMENT_WIDTH_2560_HEIGHT_1600);
        Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.KIRBY_KIRBYMICROSOFTSIGNIN_BASEELEMENTID_DOCUMENT_WIDTH_2560_HEIGHT_1,"yitzhaki@tremorvideo.com");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.KIRBY_KIRBYMICROSOFTNEXT_BASEELEMENTID_DOCUMENT_WIDTH_2560_HEIGHT_1);
        Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.KIRBY_KIRBYMICROSOFTPASSWORD_BASEELEMENTID_DOCUMENT_WIDTH_2560_HEIGHT_1,"Luckyno2019");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.KIRBY_KIRBYMICROSOFTSIGN_IN_BASEELEMENTID_DOCUMENT_WIDTH_2560_HEIGHT_1);
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.KIRBY_KIRBYMICROSOFTYES_BASEELEMENTID_DOCUMENT_WIDTH_2560_HEIGHT_1);
        Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.KIRBY_KIRBYMANIFESTPATH_BASEELEMENTID_DOCUMENT_WIDTH_2560_HEIGHT_1600,"https://s.tremorvideodsp.com/m/2019/09/cCuJLWVkH/manifest.json");
    }
}

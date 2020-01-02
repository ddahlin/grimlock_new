package GrimlockAdTesting.Application.VastApplicationImplements;

import GrimlockAdTesting.TremorVideoAdType.ImageConstants;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class WebBcPlayer {

    public void setupAdInApp(String caseNumber) {
        try {
            String BcPlayerUrl ="https://s.tremorvideodsp.com/q/BC_PLAYER/BC_";
            Grimlock.grimlockDriver().navigateToUrl(BcPlayerUrl+caseNumber+".html");
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.RML_BC_PLAY_BTN_BASEELEMENTID_VJS_VIDEO_3_WIDTH_2560_HEIGHT_1440);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


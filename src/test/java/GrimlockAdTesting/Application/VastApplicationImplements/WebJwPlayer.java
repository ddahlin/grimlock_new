package GrimlockAdTesting.Application.VastApplicationImplements;

import GrimlockAdTesting.TremorVideoAdType.ImageConstants;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class WebJwPlayer {

    public void WebJwPlayer() {

    }

    public void setupAdInApp(String caseNumber) {
        try {
            String JwPlayerUrl ="https://s.tremorvideodsp.com/q/JW_PLAYER/JW_";
            Grimlock.grimlockDriver().navigateToUrl(JwPlayerUrl+caseNumber+".html");
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.RML_JW_PLAY_BTN_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1600);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

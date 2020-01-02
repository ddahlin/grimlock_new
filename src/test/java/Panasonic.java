import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class Panasonic {

    public void setupAd(){
        try {
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAYSETTINGS_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1600);
            Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.TVBANNERS_DISPLAYINPUTURL_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502,"https://s.tremorvideodsp.com/v/2017/09/SJ2cyOu5Z/720p.mp4");
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAYAPPLY_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_360x232_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/360x232?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY360X232_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_360x232_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/360x232?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY360X232_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_412x212_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/412x212?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY412X212_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_412x212_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/412x212?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY412X212_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "panasonic")
    public void Panasonic_Test_500x160_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/500x160?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY500X160_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_500x160_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/500x160?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY500X160_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_728X90_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/728x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY728X90_BASEELEMENTID_DOCUMENT_WIDTH_1920_HEIGHT_1080);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_728X90_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/728x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY728X90_BASEELEMENTID_DOCUMENT_WIDTH_1920_HEIGHT_1080);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_860x90_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/860x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY860X90_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_860x90_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/860x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY860X90_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_1400x200_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/1400x200?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY1400X200_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

    @Test(groups = "panasonic")
    public void Panasonic_Test_1400x200_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup2/1400x200?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/Oj4UA929f/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY1400X200_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }

}

import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class Lg {

    public void setupAd(){
        try {
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAYSETTINGS_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1600);
            Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.TVBANNERS_DISPLAYINPUTURL_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502,"https://s.tremorvideodsp.com/v/2017/09/SJ2cyOu5Z/720p.mp4");
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAYAPPLY_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Test(groups = "lg")
    public void LG_Test_278x157_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/278x157?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY278X157_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_278x157_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/278x157?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY278X157_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_300x250_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/300x250?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY300X250_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_300x250_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/300x250?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY300X250_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_360x150_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/360x150?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY360X150_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_360x150_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/360x150?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY360X150_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_728x90_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/728x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY728X90_BASEELEMENTID_DOCUMENT_WIDTH_1920_HEIGHT_1080);
    }
    @Test(groups = "lg")
    public void LG_Test_728x90_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/728x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY728X90_BASEELEMENTID_DOCUMENT_WIDTH_1920_HEIGHT_1080);
    }
    @Test(groups = "lg")
    public void LG_Test_970x90_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/970x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY970X90_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_970x90_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/970x90?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY970X90_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_970x250_NonVideo()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/970x250?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY970X250_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
    @Test(groups = "lg")
    public void LG_Test_970x250_Video()throws Exception{
        Grimlock.grimlockDriver().navigateToUrl("https://html5-test.tremorvideodsp.com/v7.1.4-alpha.1/index.html#/siu/sizeGroup1/970x250?siuJsonUri=https://s.tremorvideodsp.com/m/2019/09/tj5UYj3e6/siu.json");
        setupAd();
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.TVBANNERS_DISPLAY970X250_BASEELEMENTID_DOCUMENT_WIDTH_2530_HEIGHT_1502);
    }
}

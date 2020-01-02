import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.SPR_Retailiegence_Slate;
import GrimlockEventHandler.NetworkSniffer.Charles.CharlesParsers;
import GrimlockEventHandler.NetworkSniffer.HarParsers;
import GrimlockInitialisation.Listeners.AnnotationTransformer;
import GrimlockInitialisation.Listeners.InvokedMethodListener;
import GrimlockInitialisation.Listeners.SuiteListener;
import GrimlockInitialisation.Listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static GrimlockAdTesting.TestUtils.EventEnums.VIEW_SLATE;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;
@Listeners({SuiteListener.class, TestListener.class, InvokedMethodListener.class, AnnotationTransformer.class})
public class TestCase {
    @Test(groups = "slate")
    public void slateTesting1() throws Exception {
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        Grimlock.eventService().trackEvents(VIEW_SLATE.toString());
//        Grimlock.eventService().trackEvents("Not Needed To Found - Failed for testing.");
        sprRetailiegenceSlate.sendZipCodeToInputFild("90210");
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }

    @Test(groups = "slate")
    public void slateTesting2() throws Exception {
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        Grimlock.eventService().trackEvents(VIEW_SLATE.toString());
        sprRetailiegenceSlate.CloseSlateCompanent();
        sprRetailiegenceSlate.clickOnBug();
        Grimlock.eventService().trackEvents(VIEW_SLATE.toString());
        sprRetailiegenceSlate.CloseSlateCompanent();
    }

    @Test(groups = "slate")
    public void slateTesting3() throws Exception {
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.sendZipCodeToInputFild("90210");
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }

    @Test(groups = "slate")
    public void slateTesting4() throws Exception {
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.sendZipCodeToInputFild("88901");
    }
    @Test(groups = "slate")
    public void slateTesting5()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting6()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting7()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting8()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting9()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting10()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting11()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting12()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting13()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting14()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting15()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting16()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting17()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting18()throws Exception{
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }

    @Test(groups = "slate")
    public void slateTesting19()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting20()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting21()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting22()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting23()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting24()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting25()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting26()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting27()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting28()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting29()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting30()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting31()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
    @Test(groups = "slate")
    public void slateTesting32()throws Exception{
        SPR_Retailiegence_Slate sprRetailiegenceSlate = new SPR_Retailiegence_Slate();
        sprRetailiegenceSlate.applicationBuilder.setUpAdInApp(sprRetailiegenceSlate.tremorAdTypeVastXml.sprRetailiegenceSlate);
        sprRetailiegenceSlate.clickOnBug();
        sprRetailiegenceSlate.clickOnGps();
        sprRetailiegenceSlate.CloseSlateCompanent();
    }
}

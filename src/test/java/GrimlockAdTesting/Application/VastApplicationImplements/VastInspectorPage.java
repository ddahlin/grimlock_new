package GrimlockAdTesting.Application.VastApplicationImplements;

import GrimlockAdTesting.TestUtils.RaptorWrapper;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;
public class VastInspectorPage {
    public VastInspectorPage() {
    }
    public void setupAdInApp(String xml) {
        try {
            RaptorWrapper raptorWrapper = new RaptorWrapper();
            Grimlock.grimlockDriver().navigateToUrl("https://preview.tremorvideodsp.com/#/");
            Grimlock.grimlockDriver().navigateToUrl(raptorWrapper.wrapperVastXmlWithRaptorWrapper(xml, Grimlock.grimlockDriver().getSession()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

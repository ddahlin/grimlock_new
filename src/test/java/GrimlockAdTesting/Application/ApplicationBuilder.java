package GrimlockAdTesting.Application;

import GrimlockAdTesting.Application.VastApplicationImplements.FyberAppCommands;
import GrimlockAdTesting.Application.VastApplicationImplements.JwPlayerCommands;
import GrimlockAdTesting.Application.VastApplicationImplements.VastInspectorPage;
import GrimlockAdTesting.Application.VastApplicationImplements.WebJwPlayer;
import GrimlockFramework.DriverCommands.GrimlockDriver;
import GrimlockInitialisation.InitalisationUtils.Params;

public class ApplicationBuilder {
    JwPlayerCommands jwPlayerCommands;
    VastInspectorPage vastInspectorPage;
    WebJwPlayer webJwPlayer;
    Params xml2Params;
    //    Xml2Params xml2Params;
    FyberAppCommands fyberAppCommands;

    public ApplicationBuilder(GrimlockDriver grimlockDriver, Params xml2Params) {
        this.xml2Params = xml2Params;
        if (xml2Params.IS_MOBILE && xml2Params.Website == null)
            SetupAppliction(grimlockDriver, xml2Params);
       else
            SetupWebApp(xml2Params);

    }

    private void SetupWebApp(Params xml2Params) {
        switch ((xml2Params.WEB_OBJECT_TO_TEST.toLowerCase())) {
            case "vastinspector":
                vastInspectorPage = new VastInspectorPage();
                break;
            case "jwplayer":
                webJwPlayer = new WebJwPlayer();
                break;
        }
    }

    private void SetupAppliction(GrimlockDriver grimlockDriver, Params xml2Params) {
        switch (xml2Params.getApplication("application_name").toLowerCase()) {
            case "jwplayer":
                jwPlayerCommands = new JwPlayerCommands(grimlockDriver);
                break;
            case "fyberapp":
                fyberAppCommands = new FyberAppCommands("");
                break;
        }
    }

    public void setUpAdInApp(String urlTag) {
        if (xml2Params.IS_MOBILE && xml2Params.Application!=null)
            SetAdInApplication(urlTag);
        else
            SetAdInWebApp(urlTag);
    }

    private void SetAdInWebApp(String urlTag) {
        switch ((xml2Params.WEB_OBJECT_TO_TEST.toLowerCase())) {
            case "vastinspector":
                vastInspectorPage.setupAdInApp(urlTag);
                break;
            case "jwplayer":
                webJwPlayer.setupAdInApp(urlTag);
                break;
        }
    }

    private void SetAdInApplication(String urlTag) {
        if (xml2Params.Website != null) {
            SetAdInWebApp(urlTag);
        } else {
            switch (xml2Params.getApplication("application_name").toLowerCase()) {
                case "jwplayer":
                    jwPlayerCommands.setupAdInApp(urlTag);
                    break;
                case "fyberapp":
                    fyberAppCommands.setupAdInApp(urlTag); //new FyberAppCommands(urlTag);
                    break;
            }
        }

    }
}

package GrimlockAdTesting.TestUtils;

import java.util.HashMap;
import java.util.Map;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class TremorVideoNY {
    public static final String BC_3069 = "https://s.tremorvideodsp.com/q/BC_PLAYER/BC_3069_RML.html";
    public static final String JW_3069 = "https://s.tremorvideodsp.com/q/JW_PLAYER/JW_3069_RML.html";
    public static final String Mob_3069 = "https://adserver.videohub.tv/preview?RI=IkYgDLIOrjWTY3uLCOQXaw&amp;screenType=mobiletablet&amp;rml=true&amp;Uctry=__country__&amp;Ust=__state__&amp;Udma=__dma__&amp;Uzip=__postalCode__&amp;Ucty=__city__&amp;Uctnt=__continent__&amp;Ulong=__longitude__&amp;Ulat=__latitude__&amp;Uacd=__areaCode__&amp;position_ACP=__adChoicesPosition__&amp;usedACP=__usedACP__&amp;dspACP=__adChoicesProviders__&amp;sig=A1EACCBDAC58AFA6141FDB4341608FB5&amp;CI=tRLrZ3DRVg73eA19b3cA7A&amp;dmps=y&amp;ssRmlApp=1&amp;isApp=y";
    public static final String BC_3203 = "https://s.tremorvideodsp.com/q/BC_PLAYER/BC_3203_RML.html";
    public static final String JW_3203 = "https://s.tremorvideodsp.com/q/JW_PLAYER/JW_3203_RML.html";
    public static final String Mob_3203 = "https://adserver.videohub.tv/preview?RI=0qVDB4RQ6XxaPtPJ6LvNPw&amp;screenType=mobiletablet&amp;rml=true&amp;Uctry=__country__&amp;Ust=__state__&amp;Udma=__dma__&amp;Uzip=__postalCode__&amp;Ucty=__city__&amp;Uctnt=__continent__&amp;Ulong=__longitude__&amp;Ulat=__latitude__&amp;Uacd=__areaCode__&amp;position_ACP=__adChoicesPosition__&amp;usedACP=__usedACP__&amp;dspACP=__adChoicesProviders__&amp;sig=EB3C0E79452040BDF67C3F14F44A81FE&amp;CI=EQRLslwxeX0ah-b4ofuB8A&amp;dmps=y&amp;ssRmlApp=1&amp;isApp=y";
    public Map urls;

    public TremorVideoNY() {
        urls = new HashMap();
        urls.put("BC_3069", BC_3069);
        urls.put("JW_3069", JW_3069);
        urls.put("Mob_3069", Mob_3069);

        urls.put("BC_3203", BC_3203);
        urls.put("JW_3203", JW_3203);
        urls.put("Mob_3203", Mob_3203);
    }

    public String getUrl(String jiraTicket) {
        if (Grimlock.params().IS_MOBILE) {
            return (String) urls.get("Mob_" + jiraTicket);
        } else if (Grimlock.params().WEB_OBJECT_TO_TEST.toLowerCase().equals("jwplayer")) {
            return urls.get("JW_" + jiraTicket).toString();
        } else {
            return urls.get("BC_" + jiraTicket).toString();
        }
    }


}

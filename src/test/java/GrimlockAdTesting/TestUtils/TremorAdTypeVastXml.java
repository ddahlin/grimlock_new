package GrimlockAdTesting.TestUtils;


import GrimlockInitialisation.InitalisationUtils.networkUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TremorAdTypeVastXml {
    public static final String Prop = "./src/main/resources/Properties/tag.text";
    public static final String TAG_URL = "https://s3.amazonaws.com/ta-blink-vpaid-tags/d/6/2019-10-31.md";

    public static String DestiniSlate, prpRetailiegenceStandard, prpRetailiegenceCompact, sprRetailiegenceSlate,
            prpPathformanceStandard, prpPathformanceCompact, sprPathformanceSlate, priceSpiderUrl, twitterUrl,
            video360Url, photo360Url, sprBugUrl, spr720Url, spraUrl, spra720Url, spreUrl, spre720Url, prpEventsUrl,
            prp720Url, prpVUrl, secondaryUrl, pxpAgeGateNonCont2Url, pxpAgeGateNonCont3Url, pxpAgeGateContUrl, pxpAgeGateCont2Url,
            pxpStandardContUrl, pxpStandardNonContUrl, pxp720Url, channelFinderUrl, tvListingsSlateUrl, movieboardSlateUrl,
            movieboardBugUrl, inputfieldUrl;


    public static String extractUrls(String text) {
        String containedUrls = null;
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find()) {
            containedUrls = (text.substring(urlMatcher.start(0), urlMatcher.end(0)));
        }
        return containedUrls;
    }

    public void downloadMdFileAndExtractToVast3XmlUrl() {
        networkUtils.getURLContent(TAG_URL, Prop);
        prpEventsUrl = getVAST3Tag("prp", Prop);
        prp720Url = getVAST3Tag("prp720", Prop);
        prpVUrl = getVAST3Tag("prp-v", Prop);
        spraUrl = getVAST3Tag("spra", Prop);
        spra720Url = getVAST3Tag("spra720", Prop);
        spreUrl = getVAST3Tag("spre", Prop);
        spre720Url = getVAST3Tag("spre720", Prop);
        spreUrl = getVAST3Tag("spre", Prop);
        DestiniSlate = getVAST3Tag("destini-slate", Prop);
        prpRetailiegenceStandard = getVAST3Tag("retailigence-standard", Prop);
        prpRetailiegenceCompact = getVAST3Tag("retailigence-compact", Prop);
        sprRetailiegenceSlate = getVAST3Tag("retailigence-slate", Prop);
        prpPathformanceStandard = getVAST3Tag("pathformance-standard", Prop);
        prpPathformanceCompact = getVAST3Tag("pathformance-compact", Prop);
        sprPathformanceSlate = getVAST3Tag("pathformance-slate", Prop);
        priceSpiderUrl = getVAST3Tag("pricespider", Prop);
        twitterUrl = getVAST3Tag("twitter", Prop);
        video360Url = getVAST3Tag("video-360", Prop);
        photo360Url = getVAST3Tag("photo-360", Prop);
        sprBugUrl = getVAST3Tag("spr", Prop);
        spr720Url = getVAST3Tag("spr720", Prop);
        secondaryUrl = getVAST3Tag("secondary-video", Prop);
        pxpAgeGateNonCont2Url = getVAST3Tag("pxp_agnc2", Prop);
        pxpAgeGateNonCont3Url = getVAST3Tag("pxp_agnc3", Prop);
        pxpAgeGateContUrl = getVAST3Tag("pxp_agc", Prop);
        pxpAgeGateCont2Url = getVAST3Tag("pxp_agc2", Prop);
        pxpStandardContUrl = getVAST3Tag("pxp_sc", Prop);
        pxpStandardNonContUrl = getVAST3Tag("pxp_snc", Prop);
        pxp720Url = getVAST3Tag("pxp720", Prop);
        channelFinderUrl = getVAST3Tag("channel-finder", Prop);
        tvListingsSlateUrl = getVAST3Tag("tvlistings-slate", Prop);
        movieboardSlateUrl = getVAST3Tag("movieboard-slate", Prop);
        movieboardBugUrl = getVAST3Tag("movieboard-bug", Prop);
        inputfieldUrl = getVAST3Tag("input-field", Prop);
    }

    private static String getVAST3Tag(String text, String filePath) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()) {
            String data = sc.nextLine();
            if (data.contains(text)) {
                while (sc.hasNext()) {
                    String required = sc.nextLine();
                    if (required.contains("[VAST3]")) {
                        sc.close();
                        return extractUrls(required);
                    } else {
                        // do noting
                    }
                }
            }
        }
        sc.close();

        return text + " not found in file.";
    }


}

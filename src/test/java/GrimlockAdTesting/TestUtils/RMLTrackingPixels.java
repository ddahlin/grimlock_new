package GrimlockAdTesting.TestUtils;

import java.util.HashMap;
import java.util.Map;

public  final class RMLTrackingPixels {

    public static String[] PixelsFromQuery = {"EC=7", "Ee=1", "RcpF=1", "EC=40", "EC=3&", "EC=38", "EC=2", "Eipct=0", "Eipct=25", "Eipct=50", "Eipct=75", "Eipct=100",
            "ctx=42674&cmp=DV069178", "cmp=2256325", "ctx=42674&cmp=2256325&sid=1111", "ctx=42674&cmp=2311460", "ca=12345", "cmp=DV015740",
            "param1=creative_impression", "param1=screen_completion", "param1=screen_impression", "param1=impression_1", "param1=impression_2", "param1=creative_first_quartile",
            "param1=creative_second_quartile", "param1=creative_third_quartile", "param1=screen_first_quartile",
            "param1=screen_second_quartile", "param1=screen_third_quartile", "param1=completion", "param1=viewable_completion", "ci=nlsnapi12535", "param1=mobile_screen_impression", "param1=desktop_screen_impression", "param1=mobile_screen_completion", "desktop_screen_completion",
            "param1=desktop_screen_first_quartile", "param1=desktop_screen_second_quartile", "param1=desktop_screen_third_quartile", "param1=mobile_screen_first_quartile", "param1=mobile_screen_second_quartile", "param1=mobile_screen_third_quartile", "param1=creative_completion"
            , "param1=impression", "param1=MediaProgress_Preroll_0", "param1=MediaProgress_Preroll_25", "param1=MediaProgress_Preroll_50", "param1=MediaProgress_Preroll_75", "param1=MediaProgress_Preroll_100", "EaC=MediaProgress_Preroll_0", "EaC=MediaProgress_Preroll_25", "EaC=MediaProgress_Preroll_50",
            "EaC=MediaProgress_Preroll_75", "EaC=MediaProgress_Preroll_100", "EaC=Engagement_Third_Party", "EaC=View_Slate", "EaC=Navigate_Close_Click", "EaC=Click_Slate", "EaC=Interact_Preroll_Click", "EaC=Interact_Bug_Click", "param1=Engagement_Third_Party", "param1=View_Slate", "param1=Navigate_Close_Click",
            "param1=Click_Slate", "param1=Interact_Preroll_Click", "param1=Interact_Bug_Click", "param1=Interact_Photo360_Click", "param1=Interact_Video360_Click", "param1=MediaProgress_Video360_0", "param1=MediaProgress_Video360_25", "param1=MediaProgress_Video360_50", "param1=MediaProgress_Video360_75",
            "param1=MediaProgress_Video360_100", "param1=MediaProgress_Teaser_0", "param1=MediaProgress_Teaser_25", "param1=MediaProgress_Teaser_50", "param1=MediaProgress_Teaser_75", "param1=MediaProgress_Teaser_100", "param1=View_Teaser", "param1=MediaProgress_LongformRed_0", "param1=MediaProgress_LongformRed_25",
            "param1=MediaProgress_LongformRed_50", "param1=MediaProgress_LongformRed_75", "param1=MediaProgress_LongformRed_100", "param1=Interact_AgeGatePass_Click", "EaC=Interact_AgeGatePass_Click", "param1=View_Longform", "param1=Click_Longform", "EaC=Click_Longform", "param1=Click_Bug", "EaC=Click_Bug",
            "EaC=MediaProgress_SecondaryVideo_0", "EaC=MediaProgress_SecondaryVideo_25", "EaC=MediaProgress_SecondaryVideo_50", "EaC=MediaProgress_SecondaryVideo_75", "EaC=MediaProgress_SecondaryVideo_100", "param1=MediaProgress_SecondaryVideo_0",
            "param1=MediaProgress_SecondaryVideo_25", "param1=MediaProgress_SecondaryVideo_50", "param1=MediaProgress_SecondaryVideo_75", "param1=MediaProgress_SecondaryVideo_100", "EaC=Interact_ClickToContinue_Click", "param1=Interact_ClickToContinue_Click", "param1=Interact_AgeGateFaail_Click", "EaC=Interact_AgeGateFaail_Click"
            , "param1=MediaProgress_LongformGreen_0", "param1=MediaProgress_LongformGreen_25", "param1=MediaProgress_LongformGreen_50", "param1=MediaProgress_LongformGreen_75", "param1=MediaProgress_LongformGreen_100"};



    public static final Map<String, Integer> EC_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EC=3&", 1);
            put("EC=40", 1);
            put("EC=38", 1);
            put("EC=7", 5);
            put("RcpF=1", 1);
            put("Eipct=0", 1);
            put("Eipct=25", 1);
            put("Eipct=50", 1);
            put("Eipct=75", 1);
            put("Eipct=100", 1);

        }
    };
    public static final Map<String, Integer> EC_SPRE_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EC=3&", 1);
            put("EC=40", 1);
            put("EC=38", 0);
            put("EC=7", 5);
            put("RcpF=1", 1);
            put("Eipct=0", 1);
            put("Eipct=25", 1);
            put("Eipct=50", 1);
            put("Eipct=75", 1);
            put("Eipct=100", 1);

        }
    };
    public static final Map<String, Integer> EC_PXP_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EC=3&", 1);
            put("EC=40", 1);
            put("EC=7", 6);
            put("RcpF=1", 1);
            put("Eipct=0", 1);
            put("Eipct=25", 1);
            put("Eipct=50", 2);
            put("Eipct=75", 1);
            put("Eipct=100", 1);

        }
    };
    public static final Map<String, Integer> EC_38_NULL_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EC=38", 0);
        }
    };
    public static final Map<String, Integer> EC_38_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EC=38", 1);
        }
    };
    public static final Map<String, Integer> EC_PIXEL_VAST_MAP = new HashMap<String, Integer>() {
        {
            put("EC=3&", 1);
            put("EC=7", 5);
            put("RcpF=1", 1);
            put("Eipct=0", 1);
            put("Eipct=25", 1);
            put("Eipct=50", 1);
            put("Eipct=75", 1);
            put("Eipct=100", 1);

        }
    };
    public static final Map<String, Integer> EC_ONE_CLICK_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EC=2", 1);

        }

    };
    public static final Map<String, Integer> EC_TWO_CLICK_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EC=2", 2);

        }

    };


    public static final Map<String, Integer> ENGAGE_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("Ee=1", 1);


        }

    };
    public static final Map<String, Integer> NO_ENGAGE_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("Ee=1", 0);


        }

    };


    public static final Map<String, Integer> REG3279_CUSTOM_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=creative_impression", 1);
            put("param1=screen_impression", 1);
            put("param1=impression", 1);
            put("param1=creative_first_quartile", 1);
            put("param1=creative_second_quartile", 1);
            put("param1=creative_third_quartile", 1);
            put("param1=screen_first_quartile", 1);
            put("param1=screen_second_quartile", 1);
            put("param1=screen_third_quartile", 1);
            put("param1=creative_completion", 1);
            put("param1=screen_completion", 1);
            put("param1=completion", 1);
        }

    };


    public static final Map<String, Integer> REG3063_CUSTOM_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=creative_impression", 1);
            put("param1=screen_impression", 1);
            put("param1=impression_1", 1);
            put("param1=impression_2", 1);
            put("param1=creative_first_quartile", 1);
            put("param1=creative_second_quartile", 1);
            put("param1=creative_third_quartile", 1);
            put("param1=creative_completion", 1);
        }

    };
    public static final Map<String, Integer> REG3203_DESK_CUSTOM_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=creative_impression", 2);
            put("param1=creative_first_quartile", 1);
            put("param1=creative_second_quartile", 1);
            put("param1=creative_third_quartile", 1);
            put("param1=completion", 1);
            put("param1=viewable_completion", 1);
            put("param1=desktop_screen_impression", 1);
            put("desktop_screen_completion", 1);
            put("param1=desktop_screen_first_quartile", 1);
            put("param1=desktop_screen_second_quartile", 1);
            put("param1=desktop_screen_third_quartile", 1);
            put("param1=creative_completion", 1);
            ;

        }

    };
    public static final Map<String, Integer> REG3062_DESK_CUSTOM_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=creative_impression", 2);
            put("param1=creative_first_quartile", 1);
            put("param1=creative_second_quartile", 1);
            put("param1=creative_third_quartile", 1);
            put("param1=completion", 1);
            put("param1=desktop_screen_impression", 1);
            put("desktop_screen_completion", 1);
            put("param1=desktop_screen_first_quartile", 1);
            put("param1=desktop_screen_second_quartile", 1);
            put("param1=desktop_screen_third_quartile", 1);
            put("param1=creative_completion", 1);
            ;

        }

    };
    public static final Map<String, Integer> REG3203_MOB_CUSTOM_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=creative_impression", 2);
            put("param1=creative_first_quartile", 1);
            put("param1=creative_second_quartile", 1);
            put("param1=creative_third_quartile", 1);
            put("param1=completion", 1);
            put("param1=viewable_completion", 1);
            put("param1=mobile_screen_impression", 1);
            put("param1=mobile_screen_completion", 1);
            put("param1=mobile_screen_first_quartile", 1);
            put("param1=mobile_screen_second_quartile", 1);
            put("param1=mobile_screen_third_quartile", 1);
        }

    };



    public static final Map<String, Integer> MEDIA_PROGRESS_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=MediaProgress_Preroll_0", 1);
            put("EaC=MediaProgress_Preroll_25", 1);
            put("EaC=MediaProgress_Preroll_50", 1);
            put("EaC=MediaProgress_Preroll_75", 1);
            put("EaC=MediaProgress_Preroll_100", 1);
            put("param1=MediaProgress_Preroll_0", 1);
            put("param1=MediaProgress_Preroll_25", 1);
            put("param1=MediaProgress_Preroll_50", 1);
            put("param1=MediaProgress_Preroll_75", 1);
            put("param1=MediaProgress_Preroll_100", 1);

        }

    };
    public static final Map<String, Integer> MEDIA_VIDEO_360_PROGRESS_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=MediaProgress_Video360_0", 1);
            put("param1=MediaProgress_Video360_25", 1);
            put("param1=MediaProgress_Video360_50", 1);
            put("param1=MediaProgress_Video360_75", 1);
            put("param1=MediaProgress_Video360_100", 1);

        }

    };
    public static final Map<String, Integer> MEDIA_SECONDARY_PROGRESS_PIXEL_MAP = new HashMap<String, Integer>() {
        {

            put("EaC=MediaProgress_SecondaryVideo_0", 1);
            put("EaC=MediaProgress_SecondaryVideo_25", 1);
            put("EaC=MediaProgress_SecondaryVideo_50", 1);
            put("EaC=MediaProgress_SecondaryVideo_75", 1);
            put("EaC=MediaProgress_SecondaryVideo_100", 1);
            put("param1=MediaProgress_SecondaryVideo_0", 1);
            put("param1=MediaProgress_SecondaryVideo_25", 1);
            put("param1=MediaProgress_SecondaryVideo_50", 1);
            put("param1=MediaProgress_SecondaryVideo_75", 1);
            put("param1=MediaProgress_SecondaryVideo_100", 1);

        }

    };
    public static final Map<String, Integer> PXP_TEASER_PROGRESS_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=MediaProgress_Teaser_0", 1);
            put("param1=MediaProgress_Teaser_25", 1);
            put("param1=MediaProgress_Teaser_50", 1);
            put("param1=MediaProgress_Teaser_75", 1);
            put("param1=MediaProgress_Teaser_100", 1);

        }

    };

    public static final Map<String, Integer> PXP_LONGFORM_RED_PROGRESS_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=MediaProgress_LongformRed_0", 1);
            put("param1=MediaProgress_LongformRed_25", 1);
            put("param1=MediaProgress_LongformRed_50", 1);
            put("param1=MediaProgress_LongformRed_75", 1);
            put("param1=MediaProgress_LongformRed_100", 1);

        }

    };
    public static final Map<String, Integer> PXP_LONGFORM_GREEN_PROGRESS_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=MediaProgress_LongformGreen_0", 1);
            put("param1=MediaProgress_LongformGreen_25", 1);
            put("param1=MediaProgress_LongformGreen_50", 1);
            put("param1=MediaProgress_LongformGreen_75", 1);
            put("param1=MediaProgress_LongformGreen_100", 1);

        }

    };
    public static final Map<String, Integer> SPR_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Engagement_Third_Party", 1);
            put("param1=Engagement_Third_Party", 1);
            put("EaC=Interact_Preroll_Click", 1);
            put("param1=Interact_Preroll_Click", 1);
            put("EaC=Interact_Bug_Click", 1);
            put("param1=Interact_Bug_Click", 1);
            put("EaC=Click_Slate", 1);
            put("param1=Click_Slate", 1);
        }

    };

    public static final Map<String, Integer> NAVIGATE_CLOSE_CLICK_ONE_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Navigate_Close_Click", 1);
            put("param1=Navigate_Close_Click", 1);

        }

    };
    public static final Map<String, Integer> NAVIGATE_CLOSE_CLICK_TWO_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Navigate_Close_Click", 2);
            put("param1=Navigate_Close_Click", 2);

        }

    };
    public static final Map<String, Integer> SPRA_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Engagement_Third_Party", 1);
            put("param1=Engagement_Third_Party", 1);
            put("EaC=Click_Slate", 2);
            put("param1=Click_Slate", 2);
            put("EaC=Navigate_Close_Click", 1);
            put("param1=Navigate_Close_Click", 1);

        }

    };
    public static final Map<String, Integer> SPR_VIEW_SLATE_ONE_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=View_Slate", 1);
            put("param1=View_Slate", 1);
        }

    };
    public static final Map<String, Integer> SPR_VIEW_SLATE_TWO_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=View_Slate", 2);
            put("param1=View_Slate", 2);
        }

    };
    public static final Map<String, Integer> PXP_VIEW_TEASER_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=View_Teaser", 1);
        }

    };
    public static final Map<String, Integer> PXP_VIEW_LONGFORM_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=View_Longform", 1);
        }

    };
    public static final Map<String, Integer> SPR_PHOTO_360_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=Interact_Photo360_Click", 1);
        }

    };
    public static final Map<String, Integer> SPR_VIDEO_360_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("param1=Interact_Video360_Click", 1);
        }

    };

    public static final Map<String, Integer> PXP_AGEGATE_YES_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Interact_AgeGatePass_Click", 1);
            put("param1=Interact_AgeGatePass_Click", 1);
        }

    };
    public static final Map<String, Integer> PXP_AGEGATE_NO_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Interact_AgeGateFaail_Click", 1);
            put("param1=Interact_AgeGateFail_Click", 1);
        }

    };
    public static final Map<String, Integer> PXP_CLICK_TO_CONT_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Interact_ClickToContinue_Click", 1);
            put("param1=Interact_ClickToContinue_Click", 1);
        }

    };
    public static final Map<String, Integer> PXP_PIXEL_MAP = new HashMap<String, Integer>() {
        {
            put("EaC=Click_Bug", 1);
            put("param1=Click_Bug", 1);
            put("EaC=Click_Longform", 1);
            put("param1=Click_Longform", 1);
            put("EaC=Engagement_Third_Party", 1);
            put("param1=Engagement_Third_Party", 1);
        }

    };

}



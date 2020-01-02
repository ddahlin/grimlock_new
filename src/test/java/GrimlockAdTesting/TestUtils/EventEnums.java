package GrimlockAdTesting.TestUtils;

public enum EventEnums {

    MEDIA_PROGRESS_PREROLL_0("MediaProgress_Preroll_0"),
    MEDIA_PROGRESS_PREROLL_25("MediaProgress_Preroll_25"),
    MEDIA_PROGRESS_PREROLL_50("MediaProgress_Preroll_50"),
    MEDIA_PROGRESS_PREROLL_75("MediaProgress_Preroll_75"),
    MEDIA_PROGRESS_PREROLL_100("MediaProgress_Preroll_100"),
    MEDIA_PROGRESS_LONGFORM_0("MediaProgress_Longform_0"),
    MEDIA_PROGRESS_LONGFORM_25("MediaProgress_Longform_25"),
    MEDIA_PROGRESS_LONGFORM_50("MediaProgress_Longform_50"),
    MEDIA_PROGRESS_LONGFORM_75("MediaProgress_Longform_75"),
    MEDIA_PROGRESS_LONGFORM_100("MediaProgress_Longform_100"),
    VIEW_SLATE("View_Slate"),
    INTERACT_BUG_CLICK("Interact_Bug_Click"),
    INTERACT_RETAILIGENCE_CLICK("Interact_Retailigence_Click"),
    NAVIGATE_CLOSE_CLICK("Navigate_Close_Click"),
    INTERACT_CLICK_TO_CONTINUE_CLICK("Interact_ClickToContinue_Click"),
    MEDIA_PROGRESS_LONGFORM_RED_25("MediaProgress_LongformRed_25"),
    MEDIA_PROGRESS_LONGFORM_RED_50("MediaProgress_LongformRed_50"),
    MEDIA_PROGRESS_LONGFORM_RED_75("MediaProgress_LongformRed_75"),
    MEDIA_PROGRESS_LONGFORM_RED_100("MediaProgress_LongformRed_100"),
    MEDIA_PROGRESS_LONGFORM_GREEN_25("MediaProgress_LongformGreen_25"),
    MEDIA_PROGRESS_LONGFORM_GREEN_50("MediaProgress_LongformGreen_50"),
    MEDIA_PROGRESS_LONGFORM_GREEN_75("MediaProgress_LongformGreen_75"),
    MEDIA_PROGRESS_LONGFORM_GREEN_100("MediaProgress_LongformGreen_100"),
    INTERACT_AGE_GATE_PASS_CLICK("Interact_AgeGatePass_Click"),
    INTERACT_AGE_GATE_FAIL_CLICK("Interact_AgeGateFail_Click"),
    CLICK_BUG("Click_Bug"),
    MEDIA_PROGRESS_SECONDARY_VIDEO_0("MediaProgress_SecondaryVideo_0"),
    MEDIA_PROGRESS_SECONDARY_VIDEO_25("MediaProgress_SecondaryVideo_25"),
    MEDIA_PROGRESS_SECONDARY_VIDEO_50("MediaProgress_SecondaryVideo_50"),
    MEDIA_PROGRESS_SECONDARY_VIDEO_75("MediaProgress_SecondaryVideo_75"),
    MEDIA_PROGRESS_SECONDARY_VIDEO_100("MediaProgress_SecondaryVideo_100");
    private final String text;

    EventEnums(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

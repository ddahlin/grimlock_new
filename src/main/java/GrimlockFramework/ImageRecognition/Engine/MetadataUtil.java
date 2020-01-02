package GrimlockFramework.ImageRecognition.Engine;

import org.opencv.core.Point;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetadataUtil {
    /**
     * get the width for the name of the sub image.
     *
     * @param path target to the path of the sub image
     * @return int after extract
     */
    public static int extractWidthFromPath(String path) {
        int width = 0;
        Pattern pattern = Pattern.compile(".+width-(\\d+)-.+\\..{3}$");
        Matcher matcher = pattern.matcher(path);
        if (matcher.matches() && matcher.groupCount() > 0) {
            String widthStr = matcher.group(1);
            width = Integer.parseInt(widthStr);
        }
        return width;
    }
    /**
     * get the baseElementId from the name of the sub image.
     *
     * @param path target to the path of the sub image
     * @return String of the element id if exist.
     */
    public static String extractBaseElementIDFromPath(String path) {
        String baseElemId = "";
        Pattern pattern = Pattern.compile(".+baseElementID-([^-]+)-.+\\..{3}$");
        Matcher matcher = pattern.matcher(path);
        if (matcher.matches() && matcher.groupCount() > 0) {
            baseElemId = matcher.group(1);
            if (baseElemId.equalsIgnoreCase("document")) baseElemId = "";
        }
        return baseElemId;
    }

    /**
     * get the datum point from the name of the sub image.
     *
     * @param path target to the path of the sub image
     * @return Point of the datum point if exist in path.
     */
    public static Point extractDatumPointForClickPositionFromPath(String path) {
        Point datum = null;
        Pattern pattern = Pattern.compile(".+datum-x-([\\d+]+)-y-([\\d+]+).*\\..{3}$");
        Matcher matcher = pattern.matcher(path);
        if (matcher.matches() && matcher.groupCount() > 0) {
            String xStr = matcher.group(1);
            String yStr = matcher.group(2);
            datum = new Point(Integer.parseInt(xStr), Integer.parseInt(yStr));
        }
        return datum;
    }
}

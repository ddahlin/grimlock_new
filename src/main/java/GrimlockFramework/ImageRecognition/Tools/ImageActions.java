package GrimlockFramework.ImageRecognition.Tools;

import GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection;
import GrimlockFramework.ImageRecognition.Interface.ImageRecognitionInterface;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.awt.*;
import java.util.ArrayList;

import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE;

/**
 * Create By @Ben Reich
 * <p>
 * this class implement ImageRecognitionInterface
 */
public class ImageActions implements ImageRecognitionInterface {

    private static final Logger logger = Logger.getLogger(ImageActions.class);
    protected OpenCvSubImageDetection openCvSubImageDetection;

    public ImageActions() {
        this.openCvSubImageDetection = new OpenCvSubImageDetection();
    }
    public Point getCoords(String targetPath, String source, RECOGNITION_MODE recognition_mode,int Width) {
        logger.info("Locating sub image ...");
        Point point = this.getImageCoords(targetPath, source, recognition_mode,Width);
        if (point == null) Assert.assertTrue(false, targetPath + " image not found in " + source);
        logger.info("Sub Image Found In Point :" + point);
        return point;
    }

    public ArrayList<Point> getMultiplePoint(String target, String source, int numOfSubImage,int Width) {
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<org.opencv.core.Point> points1 = this.openCvSubImageDetection.getMultiPoints(target, source, numOfSubImage,Width);
        for (org.opencv.core.Point p : points1) {
            points.add(new Point((int) p.x, (int) p.y));
        }
        return points;
    }

    private Point getImageCoords(String targetPath, String source, RECOGNITION_MODE recognition_mode,int Width) {
        Point point = new Point(0, 0);
        try {
            org.opencv.core.Point point1 = this.openCvSubImageDetection.GetSubImageCoords(targetPath, source, recognition_mode,Width);
            point = new Point((int) point1.x, (int) point1.y);
            if (point.x > 0 && point.y > 0) {
                return point;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return point;
    }


}

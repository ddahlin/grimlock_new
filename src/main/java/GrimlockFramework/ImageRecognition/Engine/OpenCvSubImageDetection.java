package GrimlockFramework.ImageRecognition.Engine;

import org.apache.log4j.Logger;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.opencv.imgproc.Imgproc.*;

/**
 * Created By Ben Reich - Axe Team
 * Open Cv Lib for recognize sub image in the
 * screen image
 * ability to find more then one sub image in the screen
 */
public class OpenCvSubImageDetection {

    final double IMAGE_RECONITION_TOLERANCE = 0.7;
    final double IMAGE_RECONITION_RELAXED_TOLERANCE = 0.5;
    final double SECOND_COMPARE_RELAXED_TOLERANCE_SQDIFF_NORM = 0.4;
    private Map<String, Double> MaxVal;

    public static enum RECOGNITION_MODE {
        RELAXED, STRICT
    }

    /**
     * using Mat for image mobileSourcePath and for sub image
     */
    Scalar white = new Scalar(0);
    Scalar black = new Scalar(999999999);
    Scalar color;
    private final Logger logger = Logger.getLogger(OpenCvSubImageDetection.class);

    public OpenCvSubImageDetection() {
        MaxVal = new HashMap<>();
    }

    /**
     * using this function for get point of the sub image
     * using threshold of 0.75 as default(75% min threshold)
     *
     * @param pathToSubImage        the target for the path of the  target image
     * @param pathToScreenshotImage the target to path of the screenshot image
     * @param mode                  the mode - no have default
     * @return point to the center of the image
     * @throws Exception Exception
     */

    public  org.opencv.core.Point GetSubImageCoords(String pathToSubImage, String pathToScreenshotImage, RECOGNITION_MODE mode, int Width) throws Exception {
        return GetSubImageCoords(pathToSubImage, pathToScreenshotImage, IMAGE_RECONITION_TOLERANCE, mode, Width);
    }

    private  org.opencv.core.Point GetSubImageCoords(String pathToSubImage, String pathToScreenshotImage, double threshold, RECOGNITION_MODE mode, int Width) {
        nu.pattern.OpenCV.loadShared();
        Mat screenshotImageMatrix = getMatFromScrenshot(pathToScreenshotImage);
        Mat subImageMatrix = createMatrixsFromImagesFiles(screenshotImageMatrix, pathToSubImage, Width);

        Mat resultMatrix = createResultMatrix(screenshotImageMatrix, subImageMatrix);
        Mat resultTempMetrix = resultMatrix;
        Imgproc.matchTemplate(screenshotImageMatrix, subImageMatrix, resultMatrix, TM_CCOEFF_NORMED);
        Core.MinMaxLocResult minMaxLocResult = Core.minMaxLoc(resultMatrix);
        org.opencv.core.Point bestPoint = extractPointByMatchMethod(minMaxLocResult, TM_CCOEFF_NORMED);
        return getPointToReturn(bestPoint, threshold, minMaxLocResult, mode, pathToSubImage, resultTempMetrix, subImageMatrix, screenshotImageMatrix);
    }

    private  Mat getMatFromScrenshot(String pathToScreenshotImage) {
        return Imgcodecs.imread(pathToScreenshotImage);
    }

    private Mat createMatrixsFromImagesFiles(Mat screenshotImageMatrix, String pathToSubImage, int Width) {
        Mat subImageMatrix;
        if (Width == 0)
            subImageMatrix = resizeBaseTargetImage(pathToSubImage, screenshotImageMatrix.width());
        else
            subImageMatrix = resizeBaseTargetImage(pathToSubImage, Width);
        return subImageMatrix;
    }

    public ArrayList<org.opencv.core.Point> getMultiPoints(String pathToSubImage, String pathToScreenshotImage, int numberOfImages, int Width) {
        return getMultiPoints(pathToSubImage, pathToScreenshotImage, numberOfImages, IMAGE_RECONITION_TOLERANCE, Width);
    }

    public ArrayList<org.opencv.core.Point> getMultiPoints(String pathToSubImage, String pathToScreenshotImage, int numberOfImages, double threshold, int Width) {
        Mat screenshotImageMatrix = getMatFromScrenshot(pathToScreenshotImage);
        Mat subImageMatrix = createMatrixsFromImagesFiles(screenshotImageMatrix, pathToSubImage, Width);
        Mat resultMatrix = createResultMatrix(screenshotImageMatrix, subImageMatrix);
        Imgproc.matchTemplate(screenshotImageMatrix, subImageMatrix, resultMatrix, TM_CCOEFF_NORMED);
        return getMultipalePoints(resultMatrix, subImageMatrix, numberOfImages, TM_CCOEFF_NORMED);
    }

    private org.opencv.core.Point getPointToReturn(Point bestPoint, double threshold, Core.MinMaxLocResult minMaxLocResult, RECOGNITION_MODE mode, String pathToSubImage, Mat resultTempMetrix, Mat subImageMatrix, Mat screenshotImageMatrix) {
        Point clickOffset = new Point(subImageMatrix.cols() / 2, subImageMatrix.rows() / 2);
        MaxVal.put(pathToSubImage, minMaxLocResult.maxVal);
//        logger.info(minMaxLocResult.maxVal);
        Point datumPoint = MetadataUtil.extractDatumPointForClickPositionFromPath(pathToSubImage);
        if (datumPoint != null) {
            int baseImageWidth = MetadataUtil.extractWidthFromPath(pathToSubImage);
            double ratio = ((double) screenshotImageMatrix.width() / (double) baseImageWidth);
            clickOffset.x = (int) (datumPoint.x * ratio);
            clickOffset.y = (int) (datumPoint.y * ratio);
        }

        if (threshold < minMaxLocResult.maxVal) {
            logger.info("Sub Image Found -> " + bestPoint);
            return new org.opencv.core.Point(bestPoint.x + clickOffset.x, bestPoint.y + clickOffset.y);
        } else if (minMaxLocResult.maxVal > IMAGE_RECONITION_RELAXED_TOLERANCE && mode == RECOGNITION_MODE.RELAXED) {
            logger.info("RELAXED MODE: Its may have a problem with the matching... ");
            logger.info("RELAXED MODE: Compere with other Match Method...");
            org.opencv.core.Point point = CompareWithDifferentCompareMethod(screenshotImageMatrix, subImageMatrix, resultTempMetrix, TM_SQDIFF_NORMED, bestPoint);
            if (point.x == 0 && point.y == 0)
                return point;
            else
                return new org.opencv.core.Point(point.x + clickOffset.x, point.y + clickOffset.y);
        } else
            return new org.opencv.core.Point(0, 0);
    }


    private Mat createResultMatrix(Mat screenshotImageMatrix, Mat subImageMatrix) {
        int resCols = screenshotImageMatrix.cols() - subImageMatrix.cols() + 1;
        int resRows = screenshotImageMatrix.rows() - subImageMatrix.rows() + 1;
        Mat resultMatrix = new Mat();
        resultMatrix.create(resCols, resRows, CvType.CV_32FC1);
        return resultMatrix;
    }

    private org.opencv.core.Point CompareWithDifferentCompareMethod(Mat screenshotImageMatrix, Mat subImageMatrix, Mat resultMatrix, int matchMethod, Point bestPoint) {
        Imgproc.matchTemplate(screenshotImageMatrix, subImageMatrix, resultMatrix, matchMethod);
        Core.MinMaxLocResult minMaxLocResult = Core.minMaxLoc(resultMatrix);
        org.opencv.core.Point point2Return;
        point2Return = extractPointByMatchMethod(minMaxLocResult, matchMethod);
        logger.info(point2Return.toString() + "\n" + bestPoint.toString());
        if (minMaxLocResult.minVal < SECOND_COMPARE_RELAXED_TOLERANCE_SQDIFF_NORM
                && (Math.abs(point2Return.x - bestPoint.x) < 5)
                && (Math.abs(point2Return.y - bestPoint.y) < 5)) {
            logger.info("RELAXED MODE: After Compare with Other Match Method validate complete successfully");
            logger.info("RELAXED MODE: you may needed to change to other sub image next time...");
            return bestPoint;
        } else {
            logger.info("Sub Image Not Found !");
            return new org.opencv.core.Point(0, 0);

        }
    }

    private org.opencv.core.Point extractPointByMatchMethod(Core.MinMaxLocResult minMaxLocResult, int macthMethod) {
        org.opencv.core.Point point2Return;
        if (is_SQDIFF(macthMethod)) {
            point2Return = minMaxLocResult.minLoc;
        } else {
            point2Return = minMaxLocResult.maxLoc;
        }
        return point2Return;
    }

    private boolean is_SQDIFF(int matchMethod) {
        if (matchMethod == Imgproc.TM_SQDIFF || matchMethod == Imgproc.TM_SQDIFF_NORMED) {
            return true;
        } else
            return false;
    }

    private ArrayList<org.opencv.core.Point> getMultipalePoints(Mat resultMatrix, Mat targetMatrix, int numberOfPoints, int matchMethod) {
        ArrayList<org.opencv.core.Point> points2return = new ArrayList<org.opencv.core.Point>();
        org.opencv.core.Point bestPoint;
        Core.MinMaxLocResult minMaxLocResult;
        double targetCols = targetMatrix.cols();
        double targetRows = targetMatrix.rows();
        org.opencv.core.Point finalPoint, endElement;
        while (numberOfPoints > 0) {
            minMaxLocResult = Core.minMaxLoc(resultMatrix);
            bestPoint = extractPointByMatchMethod(minMaxLocResult, matchMethod);
            finalPoint = new org.opencv.core.Point(bestPoint.x + (targetCols / 2), bestPoint.y + (targetRows / 2));
            endElement = new org.opencv.core.Point(bestPoint.x + targetCols, bestPoint.y + targetRows);
            points2return.add(finalPoint);
            if (is_SQDIFF(matchMethod))
                color = black;
            else
                color = white;
            Imgproc.rectangle(resultMatrix, bestPoint, endElement, color, -1);
            numberOfPoints = numberOfPoints - 1;
        }
        return points2return;
    }

    public Mat resizeBaseTargetImage(String targetPath, int srcWidth) {
        Mat targetImage = Imgcodecs.imread(targetPath);
        Mat resizedImage = new Mat();
        int baseImageWidth = MetadataUtil.extractWidthFromPath(targetPath);

        double ratio = ((double) srcWidth / (double) baseImageWidth);
        if (baseImageWidth != 0)
            Imgproc.resize(targetImage, resizedImage, new Size(), ratio, ratio, INTER_AREA);
        else
            return targetImage;
        return resizedImage;
    }

}



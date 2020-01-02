package GrimlockFramework.ImageRecognition.Interface;

import java.awt.*;
import java.util.ArrayList;

import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE;

public interface ImageRecognitionInterface {

    Point getCoords(String target, String source, RECOGNITION_MODE recognition_mode,int Width);

    ArrayList<Point> getMultiplePoint(String target, String source, int numOfSubImage,int Width);
}

package GrimlockFramework.ImageRecognition.Engine;

import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.testng.log4testng.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

/**
 * using OCR for find a sub image in a larger image
 */
public class OcrImageRecognition {
    private static final Logger logger = Logger.getLogger(OcrImageRecognition.class);
    public OcrImageRecognition() {

    }

    /**
     * \get coords of the sub image that will found
     *
     * @param targetImgPath target to the path of the sub image
     * @param source        target to the path of the screenshot
     * @return Point
     */
    public Point getCoords(String targetImgPath, String source) {
        Match m;
        Finder f = null;
        try {
            f = new Finder(ImageIO.read(new File(source)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Point2D coords = new Point2D.Double(-1, -1);

        f.find(targetImgPath);
        if (f.hasNext()) {
            m = f.next();
            coords.setLocation(m.getTarget().getX(), m.getTarget().getY());
        }

        return new Point((int) coords.getX(), (int) coords.getY());
    }

    /**
     * return true if image exits
     *
     * @param target target to the path of the sub image
     * @param source target to the path of the screenshot
     * @return boolean
     * @throws Exception Exception
     */
    public boolean imageExits(String target, String source) throws Exception {
        Point coords = getCoords(target, source);
        if (coords.getX() > 0 & coords.getY() > 0) {
            logger.info(coords);
        }
        return (coords.getX() >= 0) && (coords.getY() >= 0);
    }


}

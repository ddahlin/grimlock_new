package GrimlockInitialisation.InitalisationUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class networkUtils {

    public static void getURLContent(String URL, String filePath) {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new URL(URL).openStream();
            output = new FileOutputStream(filePath);
            byte[] buffer = new byte[3072];
            for (int length = 0; (length = input.read(buffer)) > 0; ) {
                output.write(buffer, 0, length);
            }

        } catch (Exception e) {
            //  Log.info("ERROR OCCURRED IN FETCHING TAGS");
        } finally {
            if (output != null)
                try {
                    output.close();
                } catch (IOException logOrIgnore) {
                }
            if (input != null)
                try {
                    input.close();
                } catch (IOException logOrIgnore) {
                }
        }
    }
}

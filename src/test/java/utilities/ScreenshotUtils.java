package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtils {

    public static String capture(
            WebDriver driver,
            String testName)
            throws Exception {

        File src =
                ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String path =
                System.getProperty("user.dir")
                + "/screenshots/"
                + testName + ".png";
        
        FileUtils.copyFile(
                src,
                new File(path));

        return path;
    }
}

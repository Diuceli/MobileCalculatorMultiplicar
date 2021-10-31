package simples;

import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import junit.framework.TestCase;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import java.net.MalformedURLException;
        import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertEquals;

public class Multiplicar{

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("appiumVersion", "1.19.2");
        desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("SAUCE_USERNAME", "dmribeiro");
        desiredCapabilities.setCapability("SAUCE_ACESS_KEY", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");

        URL remoteUrl = new URL("https://dmribeiro:9b67ee52-b8f8-43d2-85dc-f594a69ee9ad@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void Multiplicar() {
        MobileElement btn8 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
        btn8.click();
        MobileElement btnMultiplicar = (MobileElement) driver.findElementByAccessibilityId("multiply");
        btnMultiplicar.click();
        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        MobileElement resultadoEsperado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals( "16", resultadoEsperado.getText());

        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

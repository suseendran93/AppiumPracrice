package org.pom.AppiumPractice;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class QuoraTest {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  protected AndroidDriver<AndroidElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  @Before
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "4f4b9fb4");
      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.quora.android");
      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LauncherActivity");
      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }

  @Test
  public void testUntitled() {
      driver.findElement(By.xpath("//*[@text='Search']")).click();
      driver.findElement(By.xpath("//*[@id='lookup_edittext']")).click();
      driver.findElement(By.xpath("//*[@id='label' and ./parent::*[@id='host' and ./parent::*[./parent::*[@id='key_pos_1_0']]]]")).click();
      driver.findElement(By.xpath("//*[@id='label' and ./parent::*[@id='key_pos_0_9']]")).click();
      driver.findElement(By.xpath("//*[@id='label' and ./parent::*[@id='key_pos_0_9']]")).click();
      driver.findElement(By.xpath("//*[@id='label' and ./parent::*[@id='key_pos_0_7']]")).click();
      driver.findElement(By.xpath("//*[@id='label' and ./parent::*[@id='key_pos_0_6']]")).click();
      driver.findElement(By.xpath("//*[@id='label' and ./parent::*[@id='key_pos_2_7']]")).click();
      driver.findElement(By.xpath("//*[@text='Appium (test automation) Topic: Appium (test automation)']")).click();
  }

  @After
  public void tearDown() {
      driver.quit();
  }
}

package in.bmw.scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.bmw.objectrepo.BMWSeventhSeries;
import in.bmw.objectrepo.LandingPage;
import in.bmw.objectrepo.TechnicalData;
import in.bmw.testdata.Base;

/**
 * 
 * @author sarthak-pc
 *
 */
public class BMWPageTest {

	static WebDriver driver;
	public static Logger log = LogManager.getLogger(BMWPageTest.class.getName());

	@BeforeClass
	public void beforeClass() throws IOException {

		log.info("driver is initialised");

		Base base = new Base();
		driver = base.invokeBrowser();
	}

	@Test(priority = 1)
	public void testLandingPage() throws InterruptedException {

		log.info("navigated to Landing page");
		LandingPage landingpage = new LandingPage(driver);
		log.info("succesfully navigated");

		landingpage.getnavModels().click();
		log.info("models link clicked");
		landingpage.getSeriesLink().click();
		log.info("series link clicked");
		log.info("10 sec implicit wait");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		log.info("Using mouse over event");
		Actions action = new Actions(driver);
		action.moveToElement(landingpage.getImgMouseOver()).build().perform();

		Thread.sleep(1000);
		landingpage.getFindMore().click();

		Thread.sleep(2000);
		log.info("going to 7th series page");
	}

	@Test(priority = 2)
	public void testSeventhSeriesPage() {

		BMWSeventhSeries seventhSeries = new BMWSeventhSeries(driver);
		log.info("reached 7th series page");

		String expected = " BMW 7 Series Sedan ";
		Assert.assertEquals(seventhSeries.getSeventhSeriesPageValidation().getText().trim(), expected.trim());

		log.info("reached 7th series page successfully");
		seventhSeries.getTechnicalData().click();

	}

	@Test(priority = 3)
	public void testTechnicalData() throws InterruptedException {
		TechnicalData techData = new TechnicalData(driver);

		String expectedTitle = "TECHNICAL DATA";
		Assert.assertEquals(techData.getTechnicalDataPageValidation().getText(), expectedTitle);
		log.info("reached technical data page successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		int expectedSpeed = Integer.parseInt("500");
		System.out.println("top speed " + techData.getTopSpeed().getText());

		int actualSpeed = Integer.parseInt(techData.getTopSpeed().getText());
		log.info("The top Speed is : " + actualSpeed);

		if (actualSpeed < expectedSpeed) {

			log.error("assertion failed");
			Assert.fail("Does not meet my requirements");

		} else {

			Assert.assertTrue(true, "passed");
		}

		// Assert.assertTrue(techData.getTopSpeed().getText(),e);

	}

	@AfterClass
	public void afterClass() {

		driver.close();
		driver = null;
		log.info("driver closed");
	}

}

package in.bmw.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author sarthak-pc
 *
 */
public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Models")
	private WebElement navModels;

	@FindBy(xpath = "//a[@alt='BMW Logo']")
	private WebElement homepageLogoImgValidation;

	@FindBy(linkText = "7")
	private WebElement seriesLink;

	@FindBy(xpath = "//div[@class='description-wrapper tw-relative tw-font-bmw-light tw-pt-200 tw-pb-100']")
	private WebElement imgdiv_onmouseover;

	@FindBy(xpath = "//a[@href='https://www.bmw.in/en/all-models/7-series/sedan/2019/bmw-7-series-sedan-inspire.html']")
	private WebElement findMore;

	public WebElement getnavModels() {

		return navModels;
	}

	public WebElement gethomePageValidation() {

		return homepageLogoImgValidation;
	}

	public WebElement getSeriesLink() {

		return seriesLink;
	}

	public WebElement getImgMouseOver() {

		return imgdiv_onmouseover;
	}

	public WebElement getFindMore() {

		return findMore;
	}

}

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
public class TechnicalData {

	public WebDriver driver;

	public TechnicalData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h2[@class='ds2-technical-data--title ds2-no-uppercase ds2-font-xl']")
	private WebElement technicalData;

	@FindBy(xpath = "//*[@id=\"top-of-content\"]/div/div[3]/div/div/div[2]/section[1]/div[3]/div/div[2]/div/table/tbody/tr[1]/td[2]/div")
	private WebElement topSpeed;

	public WebElement getTechnicalDataPageValidation() {

		return technicalData;
	}

	public WebElement getTopSpeed() {

		return topSpeed;
	}
}

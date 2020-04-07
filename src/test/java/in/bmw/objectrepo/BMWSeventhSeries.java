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
public class BMWSeventhSeries {

	public WebDriver driver;
	
	public BMWSeventhSeries(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	

	@FindBy(xpath = "//*[@id=\"content-navigation\"]/div/div/div/div/div/div[1]/div[2]")
	private WebElement BMW_7_series_sedan;

	@FindBy(linkText = "Technical Data")
	private WebElement technicalData;

	public WebElement getSeventhSeriesPageValidation() {

		return BMW_7_series_sedan;
	}

	public WebElement getTechnicalData() {

		return technicalData;
	}
}

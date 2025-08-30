package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CityPage extends BasePage{
	public CityPage(WebDriver d) { super(d); }
	
	@FindBy(xpath ="//input[@id='dummy']")
    private WebElement citySelec;
    
    @FindBy(xpath ="//div[@class='sc-5d56x9-0 hIDoFD']")
    private WebElement citySelecFinal;
    
    @FindBy(xpath ="//span[@class='sc-1or3vea-16 gPcyDI']")
    private WebElement citySelecValidation;
    
    @FindBy(xpath ="//div[@class='sc-fv93km-1 fZhJNQ']")
    private WebElement citySelecError;
    
    @FindBy(xpath ="//img[@alt='Kolkata']")
    private WebElement citySelecIcon;
    
    @FindBy(xpath ="//p[text()='View All Cities']")
    private WebElement allCity;
    
    @FindBy(xpath ="//ul[@class='sc-yuf6si-1 idrZHM']/li")
    private List<WebElement> allCityName;
    
    
    
    public void cityExploreValid(String a) {
        try {
            citySelec.sendKeys(a);
            citySelecFinal.click();
        } catch (Exception e) {
            System.out.println("Error in cityExploreValid: " + e.getMessage());
        }
    }

    public void cityExploreInvalid(String a) {
        try {
            citySelec.sendKeys(a);
            String b = citySelecError.getText();
            Assert.assertEquals(b.toLowerCase(), a.toLowerCase());
        } catch (Exception e) {
            System.out.println("Error in cityExploreInvalid: " + e.getMessage());
        }
    }

    public void noCity() {
        try {
            System.out.println(citySelecError.equals("No results found."));
        } catch (Exception e) {
            System.out.println("Error in noCity: " + e.getMessage());
        }
    }

    public void openCity() {
        try {
            citySelec.sendKeys("mumbai");
            citySelecFinal.click();
            citySelecValidation.click();
        } catch (Exception e) {
            System.out.println("Error in openCity: " + e.getMessage());
        }
    }

    public void cityResult(String a) {
        try {
            String b = citySelecValidation.getText();
            Assert.assertEquals(b.toLowerCase(), a.toLowerCase(), "Expected " + a + " but got " + b);
            System.out.println("✅ City matched: " + b);
        } catch (Exception e) {
            System.out.println("Error in cityResult: " + e.getMessage());
        }
    }

    public void citySelecIcon(String a) {
        try {
            citySelecIcon.click();
            System.out.println(a + " Selected as City");
        } catch (Exception e) {
            System.out.println("Error in citySelecIcon: " + e.getMessage());
        }
    }

    public void allCityBtn() {
        try {
            allCity.click();
        } catch (Exception e) {
            System.out.println("Error in allCityBtn: " + e.getMessage());
        }
    }

    public List<String> getAllCityNames() {
        try {
            return allCityName.stream()
                    .map(WebElement::getText)
                    .map(String::trim)
                    .toList();
        } catch (Exception e) {
            System.out.println("Error in getAllCityNames: " + e.getMessage());
            return List.of();
        }
    }

    /** Check if a city is present in All Cities */
    public boolean isCityPresent(String city) {
        try {
            return getAllCityNames().contains(city);
        } catch (Exception e) {
            System.out.println("Error in isCityPresent: " + e.getMessage());
            return false;
        }
    }
    
    
}

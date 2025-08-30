package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.WaitUtils;

public class MoviePage extends BasePage{
	public MoviePage(WebDriver d) { super(d); }
	
	@FindBy(xpath ="//input[@id='dummy']")
    private WebElement citySelec;
    
    @FindBy(xpath ="//div[@class='sc-5d56x9-0 hIDoFD']")
    private WebElement citySelecFinal;
    
    @FindBy(xpath ="//div[@class='sc-1or3vea-13 kbbBtJ']")
    private WebElement movieSerchbar;
    
    @FindBy(xpath ="//h1[@class='sc-qswwm9-6 ea-drWB']")
    private WebElement movieName;
    
    @FindBy(xpath ="//div[@class='sc-echj48-6 gKNZpq']")
    private WebElement moviePoster;
    
    @FindBy(xpath ="(//div[@class='sc-1vmod7e-2 ixpVNC'])[1]")
    private WebElement ticketBook;
    
    @FindBy(xpath ="//a[text()='Movies']")
    private WebElement mv;
    
    @FindBy(xpath ="//h1[@class='sc-b1h692-7 kZpDcG']")
    private WebElement mvuiCheck;
    
    @FindBy(xpath ="//img[@alt='Coming Soon']")
    private WebElement upcomingMvClick;
    
    @FindBy(xpath ="//img[@alt='Now Showing']")
    private WebElement nowShowing;
    
    
    
    
    public void citySelection(String a) {
        try {
            WaitUtils.waitForVisible(d, citySelec, 8).clear();
            citySelec.sendKeys(a);
            WaitUtils.waitForClickable(d, citySelecFinal, 8).click();
        } catch (Exception e) {
            System.out.println("Error in citySelection(): " + e.getMessage());
            Assert.fail("citySelection failed", e);
        }
    }

    public void recMovie(String a) {
    	try {
            WebElement movie = d.findElement(
                By.xpath("//img[@alt=\"" + a + "\"] | //img[contains(@alt, \"" + a + "\")]")
            );
            WaitUtils.waitForClickable(d, movie, 8).click();
            System.out.println("Selected movie: " + a);
        } catch (Exception e) {
            System.out.println("Error in recMovie(): " + e.getMessage());
            Assert.fail("recMovie failed", e);
        }
    }

    public void recMovieDetails(String m) {
        try {
            String a = WaitUtils.waitForVisible(d, movieName, 8).getText();
            System.out.println(a);
            Assert.assertEquals(m.toLowerCase(), a.toLowerCase(), "Expected " + m + " but got " + a);

            WebElement btn = WaitUtils.waitForVisible(d, ticketBook, 8);
            Assert.assertTrue(btn.isDisplayed(), "Ticket Book button is not displayed");
            System.out.println("Ticket Book button is visible."); 
        } catch (Exception e) {
            System.out.println("Error in recMovieDetails(): " + e.getMessage());
            Assert.fail("recMovieDetails failed", e);
        }
    }

    public void elementCheck(String a) {
        try {
            WebElement tab = WaitUtils.waitForVisible(d,
                    d.findElement(By.xpath("//a[text()='" + a + "']")), 8);
            Assert.assertTrue(tab.isDisplayed(), "Menu tab is not visible: " + a);
            System.out.println("Menu tab is visible: " + a);
        } catch (Exception e) {
            System.out.println("Error in elementCheck(): " + e.getMessage());
            Assert.fail("elementCheck failed for: " + a, e);
        }
    }

    public void searchBarcheck() {
        try {
            Assert.assertTrue(WaitUtils.waitForVisible(d, movieSerchbar, 8).isDisplayed(),
                    "Movie search bar not visible");
            System.out.println("Movie search bar is visible.");
        } catch (Exception e) {
            System.out.println("Error in searchBarcheck(): " + e.getMessage());
            Assert.fail("searchBarcheck failed", e);
        }
        }

    public void mvGo() {
        try {
            WaitUtils.waitForClickable(d, mv, 8).click();
        } catch (Exception e) {
            System.out.println("Error in mvGo(): " + e.getMessage());
            Assert.fail("mvGo failed", e);
        }
    }

    public void upcomingMovie() {
        try {
            WaitUtils.waitForClickable(d, upcomingMvClick, 8).click();
            Assert.assertTrue(WaitUtils.waitForVisible(d, mvuiCheck, 8).isDisplayed(),
                    "Upcoming Movies UI element not visible after click!");
            System.out.println("Upcoming Movies UI is visible.");
        } catch (Exception e) {
            System.out.println("Error in upcomingMovie(): " + e.getMessage());
            Assert.fail("Failed to validate Upcoming Movies UI", e);
        }
    }

    public void inMovies() {
        try {
            WebElement elem = WaitUtils.waitForVisible(d, nowShowing, 8);
            Assert.assertTrue(elem.isDisplayed(), "In Movies UI element not visible after click!");
            System.out.println("In Movies UI element is visible.");
        } catch (Exception e) {
            System.out.println("Error in inMovies(): " + e.getMessage());
            Assert.fail("In Movies UI validation failed", e);
        }
    }
}

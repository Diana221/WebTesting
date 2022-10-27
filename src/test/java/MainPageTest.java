import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.*;

public class MainPageTest {

    private static final Logger LOGGER = LogManager.getLogger(MainPageTest.class.getName());


    public static MyLoginPage loginPage;
    public static MainPage mainPage;
    public static CartPage cartPage;
    public static ItemPage itemPage;
    public static SortingElement sortingElement;
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new MyLoginPage(driver);
        // driver.get("https://www.saucedemo.com/inventory.html");
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        itemPage = new ItemPage(driver);
        sortingElement = new SortingElement(driver);
    }

    @Test
    // @MethodOwner(owner = "diana")
    //  @TestLabel(name = "3. login, add to cart item(backpack) and check price/name", value = {"web"})
    public void addToCartTest() {

        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);// main page

        Assert.assertTrue(mainPage.backpackItemVisibility());

        String price = mainPage.getBackpackPrice();
        String itemName = mainPage.getBackpackName();

        mainPage.clickAddToCartButton();
        mainPage.clickCartButton();

        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", currentUrl);// cart page

        Assert.assertEquals(itemName, cartPage.getBackpackName());
        Assert.assertEquals(price, cartPage.getBackpackPrice());

        //  LOGGER.info(itemName + " = " + cartPage.getBackpackName());
        // LOGGER.info(price + " = " + cartPage.getBackpackPrice());


    }

    @Test
    //  @MethodOwner(owner = "diana")
    // @TestLabel(name = "4. login, open item(Onesie), check price/name and logout", value = {"web"})
    public void openItemTest() {

        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);// main page

        Assert.assertTrue(mainPage.onesieItemVisibility());

        String price = mainPage.getOnesiePrice();
        String itemName = mainPage.getOnesieName();

        mainPage.clickTitleToOpenShirtLink();//open item
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory-item.html?id=2", currentUrl);// item page

        Assert.assertEquals(itemName, itemPage.getOnesieName());
        Assert.assertEquals(price, itemPage.getOnesiePrice());

        // LOGGER.info(itemName + " = " + itemPage.getOnesieName());
        // LOGGER.info(price + " = " + itemPage.getOnesiePrice());

        itemPage.clickBackToProductsButton();
        //    currentUrl = driver.getCurrentUrl();
        //Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);// main page

        mainPage.clickMenuButton();
        mainPage.clickLogoutButton();

//        currentUrl = driver.getCurrentUrl();
//        LOGGER.info(currentUrl);
//        Assert.assertEquals("https://www.saucedemo.com/", currentUrl);
    }

    @Test
    public void logoutTest() {
        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        mainPage.clickMenuButton();
        mainPage.clickLogoutButton();
        //  driver.findElement(By.id("logout_sidebar_link")).click();
    }

    //    @Test
//    //  @MethodOwner(owner = "diana")
//    // @TestLabel(name = "5.", value = {"web"})
//    public void checkSortingTest() {
//
//        loginPage.inputLogin("standard_user");
//        loginPage.inputPassword("secret_sauce");
//        loginPage.clickLoginButton();
//
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);// main page
//
//        Assert.assertTrue(mainPage.onesieItemVisibility());
//        sortingElement.clickSortingButton();
//        //Assert.assertEquals(itemName, itemPage.getOnesieName());
//        //String itemName = mainPage.getOnesieName();
//
//
//    }
    @After
    public void close() {
        //      driver.quit();
    }

}

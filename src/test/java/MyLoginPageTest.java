import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.MyLoginPage;

public class MyLoginPageTest {

    // private static final Logger LOGGER = LogManager.getLogger(MainPageTest.class.getName());

    public static MyLoginPage loginPage;
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new MyLoginPage(driver);
    }

    @Test
    //  @MethodOwner(owner = "diana")
    // @TestLabel(name = "1. empty fields", value = {"web"})
    public void emptyFieldsTest() {

        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/", currentUrl);//same page
        Assert.assertTrue(loginPage.msgVisibility()); //error message showed
        Assert.assertTrue(loginPage.msgtext("Epic sadface: Username is required")); //right error message
    }

    @Test
    //  @MethodOwner(owner = "diana")
    // @TestLabel(name = "2. wrong password", value = {"web"})
    public void wrongPassword() {

        loginPage.inputLogin("standard_user");
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/", currentUrl);//same page
        Assert.assertTrue(loginPage.msgVisibility()); //error message showed
        Assert.assertTrue(loginPage.msgtext("Epic sadface: Username and password do not " +
                "match any user in this service")); //right error message

    }

}

package web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;
    /**
     * определение локатора поля ввода логина
     */


    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement menuButton;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private WebElement cartButton;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"item_2_title_link\"]")
    private WebElement titleOpenShirtLink;


    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]")
    private WebElement backpackItem;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    private WebElement backpackPriceLabel;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement backpackNameLabel;


    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[5]")
    private WebElement onesieItem;
    @FindBy(xpath = "//*[@id=\"item_2_title_link\"]")
    private WebElement onesieNameLabel;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[5]/div[2]/div[2]/div")
    private WebElement onesiePriceLabel;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getBackpackPrice() {
        return backpackPriceLabel.getText();
    }

    public String getBackpackName() {
        return backpackNameLabel.getText();
    }

    public boolean backpackItemVisibility() {
        return backpackItem.isDisplayed();
    }

    public String getOnesiePrice() {
        return onesiePriceLabel.getText();
    }

    public String getOnesieName() {
        return onesieNameLabel.getText();
    }

    public boolean onesieItemVisibility() {
        return onesieItem.isDisplayed();
    }


    public void clickCartButton() {
        cartButton.click();
    }

    public void clickTitleToOpenShirtLink() {
        titleOpenShirtLink.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
}

package web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage { //Onesie

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    private WebElement priceOnesieLabel;
    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    private WebElement onesieNameLabel;
    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private WebElement backButton;

    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickBackToProductsButton() {
        backButton.click();
    }

    public String getOnesiePrice() {
        return priceOnesieLabel.getText();
    }

    public String getOnesieName() {
        return onesieNameLabel.getText();
    }

}

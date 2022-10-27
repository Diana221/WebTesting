package web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage { //backpack

    public WebDriver driver;
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement backpackPriceLabel;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]")
    private WebElement backpackNameLabel;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getBackpackPrice() {
        return backpackPriceLabel.getText();
    }

    public String getBackpackName() {
        return backpackNameLabel.getText();
    }

}

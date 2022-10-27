package web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortingElement { //backpack

    public WebDriver driver;
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    private WebElement sortingLabel;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]")
    private WebElement backpackNameLabel;

    public SortingElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSortingButton() {

        sortingLabel.click();

    }

    public String getSortingLabel() {
        return sortingLabel.getText();
    }

    public String getBackpackName() {
        return backpackNameLabel.getText();
    }

}

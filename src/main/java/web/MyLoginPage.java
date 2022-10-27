package web;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLoginPage {

    public WebDriver driver;
    /**
     * определение локатора поля ввода логина
     */


    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;
    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameField;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    public MyLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        usernameField.sendKeys(login);
    }

    /**
     * метод для ввода пароля
     */
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public boolean msgVisibility() {
        return errorMessage.isDisplayed();
    }

    public boolean msgtext(String message) {
        return errorMessage.getText().equals(message);
    }


    public void clickLoginButton() {
        loginButton.click();
    }
}

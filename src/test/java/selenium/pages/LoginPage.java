package selenium.pages;

import org.openqa.selenium.By;

public class LoginPage {
    private final By userNameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginBtn = By.xpath("//input[@value='Log In']");
    private static final By requestLoanBtn = By.linkText("Request Loan");
    private final String loginUrl = "https://parabank.parasoft.com";

    public void openLoginPage() {
        BasePage.openUrl(loginUrl);
    }

    public void setValueToUserName(String value) {
        BasePage.sendKey(userNameField, value);
    }

    public void setValueToPassword(String value) {
        BasePage.sendKey(passwordField, value);
    }

    public void clickOnLoginBtn() {
        BasePage.clickOnElement(loginBtn);
    }

    public static void clickOnRequestLoanBtn() { BasePage.clickOnElement(requestLoanBtn); }

    public void login(String userName, String password) {
        openLoginPage();
        setValueToUserName(userName);
        setValueToPassword(password);
        clickOnLoginBtn();
    }

}

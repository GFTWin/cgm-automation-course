package selenium.pages;

import org.openqa.selenium.By;
import selenium.models.LoanApplication;

public class RequestLoanPage {
    private final By loadAmountField = By.id("amount");
    private final By downPaymentField = By.id("downPayment");
    private final By fromAccountMenu = By.id("fromAccountId");
    private final By applyNowBtn = By.xpath("//input[@value='Apply Now']");

    public void setValueToLoadAmountField(int value) {
        BasePage.sendKey(loadAmountField, String.valueOf(value));
    }

    public void setValueToDownPaymentField(String value) {
        BasePage.sendKey(downPaymentField, value);
    }

    public void selectOptionFromAccountMenu(String option) {
        BasePage.selectElement(fromAccountMenu, option);
    }

    public void clickOnApplyNowBtn() {
        BasePage.clickOnElement(applyNowBtn);
    }

    public void requestLoan(LoanApplication loanApplication) {
        LoginPage.clickOnRequestLoanBtn();
        setValueToLoadAmountField(loanApplication.getLoanAmount());
        setValueToDownPaymentField(String.valueOf(loanApplication.getDownPayment()));
        selectOptionFromAccountMenu(String.valueOf(loanApplication.getAccount()));
        clickOnApplyNowBtn();
    }

}

package selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.models.LoanApplication;
import selenium.pages.BasePage;

public class RequestLoanTest extends BaseTest {
    public RequestLoanTest(WebDriver driver) {
        super(driver);
    }

//    private static Stream<Argument> testCases() {
//        LoanApplication loanApplication1 = new LoanApplication(10000, 1000, "13344");
//        LoanApplication loanApplication2 = new LoanApplication(1000, 100, "13344");
//        LoanApplication loanApplication3 = new LoanApplication(50000, 5000, "13344");
//
//        return testCases();
//    }

    @ParameterizedTest
    @CsvSource({
            "10000,1000,13344,Denied",
            "10000,1000,13344,Denied",
            "'1000','100',13344,Approved"
    })
    public void requestLoan(int loan, int downPayment, String account,  String status) {
        LoanApplication loanApplication = new LoanApplication(loan, downPayment, account);
        loginPage.login("john", "demo");
        requestLoanPage.requestLoan(loanApplication);
        String result = BasePage.getValue(By.id("loanStatus"));
        Assertions.assertEquals(status, result);
    }
}


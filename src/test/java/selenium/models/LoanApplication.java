package selenium.models;

public class LoanApplication {
    private final int loanAmount;
    private final int downPayment;
    private final String account;

    public LoanApplication(int loanAmount, int downPayment, String account) {
        this.loanAmount = loanAmount;
        this.downPayment = downPayment;
        this.account = account;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public String getAccount() {
        return account;
    }
}

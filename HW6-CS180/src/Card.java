public class Card {
    private double rate;
    private double balance;
    private double monthlyPayment;

    public Card(double rate, double balance, double monthlyPayment) {
        this.rate = rate;
        this.balance = balance;
        this.monthlyPayment = monthlyPayment;
    }

    public double getRate() {
        return rate;
    }

    public double getBalance() {
        return balance;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int calculatePayoff(boolean output) {


    }

    public String toString() {


    }
}

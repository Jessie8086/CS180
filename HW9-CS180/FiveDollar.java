package HW9.CS180;

public class FiveDollar extends DollarBill{
    public FiveDollar(){
        super(5, "Abraham Lincoln");
    }

    public boolean acceptedVending() {
        return true;
    }
}

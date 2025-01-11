package HW9.CS180;

public class TenDollar extends DollarBill{
    public TenDollar(){
        super(10, "Alexander Hamilton");
    }

    public boolean acceptedVending() {
        return true;
    }
}

package pl.damian.DTO;

public class ConversionRequest {
    private double amount;
    private String fromC;
    private String toC;
    
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getFromC() {
        return fromC;
    }
    public void setFromC(String fromC) {
        this.fromC = fromC;
    }
    public String getToC() {
        return toC;
    }
    public void setToC(String toC) {
        this.toC = toC;
    }
    
}

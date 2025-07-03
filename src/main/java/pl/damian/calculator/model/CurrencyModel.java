package pl.damian.calculator.model;

public class CurrencyModel {
    private String currency;
    private String code;
    private Double mid;

    public CurrencyModel(String currency, String code, Double mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public Double getMid() {
        return mid;
    }
}

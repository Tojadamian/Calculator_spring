package pl.damian.DTO;

public class ConversionResult {
    private Double result;
    private String error;

    public Double getResult() {
        return result;
    }
    public void setResult(Double result) {
        this.result = result;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public ConversionResult(Double result){
        this.result = result;
    }
    public ConversionResult(String error){
        this.error = error;
    }

}


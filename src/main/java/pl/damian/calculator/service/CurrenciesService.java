package pl.damian.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.damian.calculator.model.CurrencyModel;

@Service
public class CurrenciesService {
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String[] TABLES = {"A", "B", "C"};
    private static final String NBP_API_URL = "http://api.nbp.pl/api/exchangerates/tables/%s/";

    public List<CurrencyModel> getCurrencies(){
        List<CurrencyModel> allCurrencies = new ArrayList<>();

        CurrencyModel pln = new CurrencyModel("Polski Złoty", "PLN", 1.0);
        allCurrencies.add(pln);

        for (String tabele: TABLES){
            String url = String.format(NBP_API_URL, tabele);
            try{
                CurrencyTable[] response = restTemplate.getForObject(url, CurrencyTable[].class);
                if (response != null && response.length > 0) {
                    response[0].getRates().forEach(rate -> {
                        CurrencyModel currency = new CurrencyModel(
                            rate.getCurrency(),
                            rate.getCode(),
                            rate.getMid()
                        );
                        allCurrencies.add(currency);
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allCurrencies;
    }
    private static class CurrencyTable {
        private List<Rate> rates;

        public List<Rate> getRates() {
            return rates;
        }
        // public void setRates(List<Rate> rates) {
        //     this.rates = rates;
        // }
    }
    private static class Rate {
        private String currency;
        private String code;
        private Double mid;

        public String getCurrency() {
            return currency;
        }
        // public void setCurrency(String currency) {
        //     this.currency = currency;
        // }
        public String getCode() {
            return code;
        }
        // public void setCode(String code) {
        //     this.code = code;
        // }
        public Double getMid() {
            return mid;
        }
        // public void setMid(Double mid) {
        //     this.mid = mid;
        // }
    }
    public Double convertCurrency(double amount, String fromCode, String toCode) {
        List<CurrencyModel> currencies = getCurrencies();
        CurrencyModel from = currencies.stream().filter(c -> c.getCode()
                .equalsIgnoreCase(fromCode)).findFirst().orElse(null);
        CurrencyModel to = currencies.stream().filter(c -> c.getCode()
                .equalsIgnoreCase(toCode)).findFirst().orElse(null);

    if (from == null || to == null || from.getMid() == null || to.getMid() == null) {
        return null;
    }

    double result = amount * from.getMid() / to.getMid();
    return result;
    }
}

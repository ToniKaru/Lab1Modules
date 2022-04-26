package se.karu.toni.webservices.modules.provider;

import se.karu.toni.webservices.modules.interfaces.Currency;
import se.karu.toni.webservices.modules.interfaces.Exchange;

import java.text.NumberFormat;
import java.util.Locale;

@Currency("usd")
public class UsdExchange implements Exchange {

    private double rate;
    private Locale locale;

    public UsdExchange(){
        rate = 0;
        locale = new Locale("en", "EN");
    }

    @Currency("sek")
    @Override
    public String exchangeForCrowns(Double amount) {
        rate = 9.5468d;
        locale = new Locale("sv", "SV");
        var crowns = amount * rate;
        return NumberFormat.getCurrencyInstance(locale).format(crowns);
    }
}

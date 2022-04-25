package se.karu.toni.webservices.modules.provider;

import se.karu.toni.webservices.modules.interfaces.CurrencyToExchange;
import se.karu.toni.webservices.modules.interfaces.Exchange;

import java.text.NumberFormat;
import java.util.Locale;

@CurrencyToExchange("usd")
public class UsdExchange implements Exchange {

    private double rate;
    private Locale locale;

    public UsdExchange(){
        rate = 0;
        locale = new Locale("en", "EN");
    }

    @Override
    public String exchangeForCrowns(double amount) {
        rate = 9.5468d;
        locale = new Locale("sv", "SV");
        var crowns = amount * rate;
        return NumberFormat.getCurrencyInstance(locale).format(crowns);
    }
}

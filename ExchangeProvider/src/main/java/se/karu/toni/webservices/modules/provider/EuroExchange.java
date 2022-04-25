package se.karu.toni.webservices.modules.provider;

import se.karu.toni.webservices.modules.interfaces.CurrencyToExchange;
import se.karu.toni.webservices.modules.interfaces.Exchange;

import java.text.NumberFormat;
import java.util.Locale;

@CurrencyToExchange("euro")
public class EuroExchange implements Exchange {
    private double rate = 0;
    Locale locale = new Locale("sv");

    @Override
    public String exchangeForCrowns(double amount) {
        rate = 10.31009d;
        locale = new Locale("sv", "SV");
        var crowns = amount * rate;
        return NumberFormat.getCurrencyInstance(locale).format(crowns);
    }
}

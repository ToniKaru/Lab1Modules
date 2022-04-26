package se.karu.toni.webservices.modules.provider;

import se.karu.toni.webservices.modules.interfaces.Currency;
import se.karu.toni.webservices.modules.interfaces.Exchange;

import java.text.NumberFormat;
import java.util.Locale;

@Currency("euro")
public class EuroExchange implements Exchange {
    private double rate = 0;
    Locale locale = new Locale("sv");

    @Currency("sek")
    @Override
    public String exchangeForCrowns(Double amount) {
        rate = 10.31009d;
        locale = new Locale("sv", "SV");
        var crowns = amount * rate;
        return NumberFormat.getCurrencyInstance(locale).format(crowns);
    }
}

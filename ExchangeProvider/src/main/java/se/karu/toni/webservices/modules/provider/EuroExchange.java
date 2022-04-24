package se.karu.toni.webservices.modules.provider;

import se.karu.toni.webservices.modules.interfaces.Exchange;

public class EuroExchange implements Exchange {
    private final double rate = 1.5d;
    @Override
    public Double exchangeForCrowns(double amount) {
        return amount * rate;
    }
}

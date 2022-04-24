package se.karu.toni.webservices.modules.provider;

import se.karu.toni.webservices.modules.interfaces.Exchange;

public class UsdExchange implements Exchange {



    @Override
    public Double exchangeForCrowns(double amount) {
        return 10d;
    }
}

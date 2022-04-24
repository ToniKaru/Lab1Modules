package se.karu.toni.webservices.modules.consumer;

import se.karu.toni.webservices.modules.interfaces.Exchange;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Exchange> serviceLoader = ServiceLoader.load(Exchange.class);

        for (Exchange exchange : serviceLoader) {
            System.out.println(exchange.exchangeForCrowns(20));
        }

    }
}

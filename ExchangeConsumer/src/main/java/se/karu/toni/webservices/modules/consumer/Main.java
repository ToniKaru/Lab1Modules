package se.karu.toni.webservices.modules.consumer;

import se.karu.toni.webservices.modules.interfaces.Currency;
import se.karu.toni.webservices.modules.interfaces.Exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Exchange> serviceLoader = ServiceLoader.load(Exchange.class);

        var startCurrency = Console.getStartCurrency(serviceLoader);

        if (startCurrency == null || startCurrency.equals("0"))
            System.out.println("Hejdå");

        else {
            var amount = Console.getAmount();

            var exchanges = serviceLoader.stream()
                .filter(exchangeProvider -> exchangeProvider.type()
                    .getAnnotation(Currency.class).value()
                    .startsWith(startCurrency))
                .map(ServiceLoader.Provider::get).toList();

            for (Exchange exchange : exchanges) {
                if (startCurrency.equals("euro")) {
                    System.out.println(amount + " EURO i kronor är " + exchange.exchangeForCrowns(amount));
                }
                else if (startCurrency.equals("usd")) {
                    System.out.println(amount + " USD i kronor är " + exchange.exchangeForCrowns(amount));
                }
                else
                    System.out.println("Ingen stöd för valutan än.");
            }
        }
    }
}


class Console {
    private static Scanner scanner = new Scanner(System.in);


    protected Console (){}

    static String getStartCurrency(ServiceLoader<Exchange> serviceLoader) {
        int i = 0;
        Currency currencyAnnotation;
        List<String> annotations = new ArrayList<>();
        annotations.add("0");
        System.out.println("--- VALUTAN ATT OMVANDLA TILL SEK ---");

        for (Exchange exchange : serviceLoader) {
            i++;
            currencyAnnotation =
                exchange.getClass().getAnnotation(Currency.class);
            annotations.add(currencyAnnotation.value());

            System.out.println(i + ". " + currencyAnnotation.value().toUpperCase());

        }

        System.out.println("0. Ingen ovan");
        var choice = scanner.nextInt();

        return annotations.get(choice);
    }

    public static double getAmount() {
        System.out.println("Beloppet:");
        var amount = scanner.nextDouble();
        return amount;
    }
}
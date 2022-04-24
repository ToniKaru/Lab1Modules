import se.karu.toni.webservices.modules.interfaces.Exchange;
import se.karu.toni.webservices.modules.provider.EuroExchange;
import se.karu.toni.webservices.modules.provider.UsdExchange;

module se.karu.toni.webservices.modules.provider {
    requires se.karu.toni.webservices.modules.interfaces;
    provides Exchange with UsdExchange, EuroExchange;
}
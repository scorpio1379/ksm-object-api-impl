package ru.ip.ksm.ksmobjectapiimpl.providerfactory;

import org.neo4j.ogm.session.Session;
import ru.ip.ksm.ksmobjectapiimpl.providers.KSMServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.providers.impl.KSMServiceProviderImpl;

public class KSMObjectProviderFactory {

    public static KSMServiceProvider getKSMServiceProvider(Session session) {
     return new KSMServiceProviderImpl( session);
    }
}

package ru.ip.ksm.ksmobjectapiimpl.apifactory;

import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;

public class KSMObjectApiServiceFactory {
    private static ConcurrentHashMap<URI , KSMObjectApiServiceProvider> KSMObjectApiServiceProviderConcurrentHashMap = new ConcurrentHashMap<>();

    public static KSMObjectApiServiceProvider getKSMObjectApiServiceProvider(URI ksmCoreServerUri){
        return getKSMObjectApiServiceProviderByURI(ksmCoreServerUri);

    }

    public static KSMObjectApiServiceProvider getKSMObjectApiServiceProvider(String ksmCoreServerUri){
        return getKSMObjectApiServiceProviderByURI(URI.create(ksmCoreServerUri));
    }

    private static KSMObjectApiServiceProvider getKSMObjectApiServiceProviderByURI(URI ksmCoreServerUri){
        if(
                (KSMObjectApiServiceProviderConcurrentHashMap.isEmpty())
                        ||
                        (!KSMObjectApiServiceProviderConcurrentHashMap.containsKey(ksmCoreServerUri))
                ) {
            KSMObjectApiServiceProvider ksmObjectApiServiceProvider = new KSMObjectApiServiceProvider(ksmCoreServerUri);
            KSMObjectApiServiceProviderConcurrentHashMap.put(ksmCoreServerUri,ksmObjectApiServiceProvider);
            return ksmObjectApiServiceProvider;
        }else if (KSMObjectApiServiceProviderConcurrentHashMap.containsKey(ksmCoreServerUri)){
            return KSMObjectApiServiceProviderConcurrentHashMap.get(ksmCoreServerUri);
        } else{
            throw new IllegalArgumentException("WTF!!!");
        }

    }
}

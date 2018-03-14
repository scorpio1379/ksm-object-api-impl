package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;

public class KSMServiceBuilderImpl<T extends KSMServiceBuilder<T>>
        extends KSMCIBuilderImpl<T>
        implements KSMServiceBuilder<T>{

    public KSMServiceBuilderImpl(Class<? extends IKSMCI> ksmciClassImpl, KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        super(ksmciClassImpl, ksm_object_api_service_provider);
    }
}

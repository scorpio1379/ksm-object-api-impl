package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;

public class KSMServiceBuilderImpl<T extends KSMServiceBuilder<T>>
        extends KSMCIBuilderImpl<T>
        implements KSMServiceBuilder<T>{

    private final Class<? extends IKSMCI> CI_SERVICE_IMPL;

    public KSMServiceBuilderImpl(Class<? extends IKSMCI> ksmServiceClassImpl, KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        super((Class<IKSMCI>) ksmServiceClassImpl.getSuperclass() ,ksm_object_api_service_provider );
        this.CI_SERVICE_IMPL = ksmServiceClassImpl;

    }
}

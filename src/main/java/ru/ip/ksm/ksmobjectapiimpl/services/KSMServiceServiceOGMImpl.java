package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;

public class KSMServiceServiceOGMImpl<T extends IKSMService>
        extends KSMCIServiceOGMImpl<T>
        implements KSMServiceService {
    private  Class<? extends IKSMService> KSMSERVICE_CLASS_IMPL;


    public KSMServiceServiceOGMImpl() {
    }

    public KSMServiceServiceOGMImpl(
            Class<? extends IKSMCI> ci_class_impl
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider
            , Class<? extends KSMService> KSMSERVICE_CLASS_IMPL) {
        super(ci_class_impl, ksmObjectApiServiceProvider);
        this.KSMSERVICE_CLASS_IMPL = KSMSERVICE_CLASS_IMPL;
    }
    public KSMServiceServiceOGMImpl(
            KSMObjectApiServiceProvider ksmObjectApiServiceProvider
            , Class<? extends IKSMService> KSMSERVICE_CLASS_IMPL) {
        super(KSMSERVICE_CLASS_IMPL.asSubclass(IKSMCI.class), ksmObjectApiServiceProvider);
        this.KSMSERVICE_CLASS_IMPL = KSMSERVICE_CLASS_IMPL;
    }

    @Override
    protected Class getEntityType() {
        return this.KSMSERVICE_CLASS_IMPL;
    }
}

package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMServiceService;

public class KSMServiceServiceOGMImpl<KSMOBJ extends IKSMService<KSMOBJ>>
        extends KSMCIServiceOGMImpl<KSMOBJ>
        //implements IKSMServiceService<KSMService>{
        implements IKSMServiceService<KSMOBJ>
{
    private  Class<? extends IKSMService> KSMSERVICE_CLASS_IMPL;



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

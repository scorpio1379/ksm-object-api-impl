package ru.ip.ksm.ksmobjectapiimpl.services;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMObjectServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMCIService;

public class KSMCIServiceOGMImpl<KSMOBJ extends IKSMCI<KSMOBJ>>
        extends BaseKSMObjectServiceOGMImpl<KSMOBJ>
        //implements IKSMCIService<IKSMCI>
    implements IKSMCIService<KSMOBJ>
{
    protected  Class<? extends IKSMCI> CI_CLASS_IMPL;
    //private  KSMObjectApiServiceProvider ksmObjectApiServiceProvider;
//    public KSMCIServiceOGMImpl() {
//
//    }

    public KSMCIServiceOGMImpl(Class<? extends IKSMCI> ci_class_impl , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        this.CI_CLASS_IMPL = ci_class_impl;
        this.session = ksmObjectApiServiceProvider.getSession();


    }


    @Override
    protected Class getEntityType() {
        return this.CI_CLASS_IMPL;
    }

    @Override
    public KSMOBJ doSmthWithCI(KSMOBJ ksmci) {
        return ksmci;
    }
}

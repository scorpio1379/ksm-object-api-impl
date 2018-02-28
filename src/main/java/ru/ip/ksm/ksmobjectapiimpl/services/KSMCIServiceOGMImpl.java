package ru.ip.ksm.ksmobjectapiimpl.services;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMObjectServiceOGMImpl;

public class KSMCIServiceOGMImpl<T extends KSMCI>
        extends BaseKSMObjectServiceOGMImpl<T>
//implements KSMCIService
{
    private  Class<? extends KSMCI> CI_CLASS_IMPL;
    //private  KSMObjectApiServiceProvider ksmObjectApiServiceProvider;
    public KSMCIServiceOGMImpl() {

    }

    public KSMCIServiceOGMImpl(Class<? extends KSMCI> ci_class_impl , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        this.CI_CLASS_IMPL = ci_class_impl;
        this.session = ksmObjectApiServiceProvider.getSession();


    }


    @Override
    protected Class getEntityType() {
        return this.CI_CLASS_IMPL;
    }


}

package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMHIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMIndicatorService;

public class KSMHIServiceOGMImpl<T extends IKSMHI>
        //extends BaseKSMIndicatorService<KSMHIImpl, KSMBaseIndicatorImpl>
        extends BaseKSMIndicatorService<T, IKSMIndicator>
        implements KSMHIService {
    private final Class<? extends IKSMHI> ksmhi_class_impl;


    public KSMHIServiceOGMImpl(Class<? extends IKSMHI> ksmkpi_class_impl
            , KSMCI related_ksmci
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(related_ksmci);
        this.ksmhi_class_impl = ksmkpi_class_impl;
        this.session = ksmObjectApiServiceProvider.getSession();
    }

    @Override
    protected Class getEntityType() {
        return KSMHIImpl.class;
    }

//    @Override
//    public T createOrUpdate(T ksmObject) {
//        T hi = super.createOrUpdate(ksmObject);
//        /*TODO: заменить на сто-то более простое!!!!!! не очевидно!!!*/
//        return  hi;
//    }
}

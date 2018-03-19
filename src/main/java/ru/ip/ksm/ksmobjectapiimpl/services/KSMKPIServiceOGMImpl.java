package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMIndicatorService;

public class KSMKPIServiceOGMImpl<T extends IKSMKPI<T>>
        //extends BaseKSMIndicatorService<KSMKPIImpl, KSMBaseIndicatorImpl>
        extends BaseKSMIndicatorService<T , IKSMIndicator>
        implements KSMKPIService {
    private final Class<? extends IKSMKPI> ksmkpi_class_impl;

    public KSMKPIServiceOGMImpl(Class<? extends IKSMKPI> ksmkpi_class_impl
            , IKSMCI related_ksmci
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(related_ksmci);
        this.ksmkpi_class_impl = ksmkpi_class_impl;
        this.session = ksmObjectApiServiceProvider.getSession();
    }

    @Override
    protected Class getEntityType() {
        return ksmkpi_class_impl;
    }

//    @Override
//    public T createOrUpdate(T ksmObject) {
//        T kpi = super.createOrUpdate(ksmObject);
//        /*TODO: заменить на сто-то более простое!!!!!! не очевидно!!!*/
//        return kpi;
//    }
}

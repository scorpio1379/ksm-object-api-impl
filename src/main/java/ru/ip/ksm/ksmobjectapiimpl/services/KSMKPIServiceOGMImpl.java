package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMRelationShipBuilderFactory;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMKPIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMIndicatorService;

public class KSMKPIServiceOGMImpl<T extends KSMKPI>
        extends BaseKSMIndicatorService<T, KSMBaseIndicatorImpl>
        implements KSMKPIService {
    private final Class<? extends KSMKPI> ksmkpi_class_impl;
    private final KSMCI related_ksmci;
    public KSMKPIServiceOGMImpl(Class<? extends KSMKPI> ksmkpi_class_impl, KSMCI related_ksmci, KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super();
        this.ksmkpi_class_impl = ksmkpi_class_impl;
        this.related_ksmci = related_ksmci;
        this.session = ksmObjectApiServiceProvider.getSession();
    }

    @Override
    protected Class<KSMKPIImpl> getEntityType() {
        return KSMKPIImpl.class;
    }

    @Override
    public T createOrUpdate(KSMKPIImpl ksmObject) {
        KSMKPIImpl kpi = super.createOrUpdate(ksmObject);
        KSMRelationShipBuilderFactory.getKSMKPI2KSMCIRelationShipBuilder(kpi,this.related_ksmci).build();
        return  (T) kpi;
    }
}

package ru.ip.ksm.ksmobjectapiimpl.builders.impls;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMIndicatorBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMHIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

public class KSMHIBuilderImpl<T extends KSMHIBuilder<T>>
        extends BaseKSMIndicatorBuilderImpl<T>
        implements KSMHIBuilder<T> {

    private final Class<? extends IKSMHI> KSMHI_CLASS_IMPL ;
//    public KSMHIBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
//        super(ksmObjectApiServiceProvider);
//    }

    public KSMHIBuilderImpl(Class<? extends KSMHI> ksmhiClassImpl, KSMObjectApiServiceProvider ksm_object_api_service_provider, KSMCI ksmci) {
        super(ksm_object_api_service_provider , ksmci);
        this.KSMHI_CLASS_IMPL = ksmhiClassImpl;
    }

    @Override
    public KSMHI build() throws IllegalAccessException, InstantiationException {
        IKSMHI tmpHi = KSMHI_CLASS_IMPL.newInstance();
        tmpHi.setDescription(this.ksmObjDescription);
        tmpHi.setName(this.ksmObjName);
        tmpHi.setKsmObjectId(this.ksmObjId);
        tmpHi.setKsmIndicatorType("KSMHI");
        tmpHi.setRelatedKSMCI(this.RELATED_KSMCI);
        tmpHi.setStatus("sts");
        tmpHi.setValue("442");
        return (KSMHI) KSMObjectServiceFactory.getKSMHIService((Class<? extends KSMHI>) KSMHI_CLASS_IMPL,  this.RELATED_KSMCI , this.ksmObjectApiServiceProvider).createOrUpdate(tmpHi);

    }
}

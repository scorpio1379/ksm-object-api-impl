package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMRelationShipBuilderFactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMIndicatorBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPI2KSMCIRelationShipBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

public class KSMKPIBuilderImpl <T extends KSMKPIBuilder<T>>
        extends BaseKSMIndicatorBuilderImpl<T>
        implements KSMKPIBuilder<T>{
//    public KSMKPIBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
//        super(ksmObjectApiServiceProvider);
//    }
    private final KSMCI RELATED_KSMCI;
    private final Class<? extends IKSMKPI> KSMKPI_CLASS_IMPL ;

    private String ksmKpiCalulationRuleId;

    public KSMKPIBuilderImpl(Class<? extends KSMKPI> ksmkpiClassImpl, KSMObjectApiServiceProvider ksm_object_api_service_provider, KSMCI ksmci) {
        super(ksm_object_api_service_provider);
        this.RELATED_KSMCI = ksmci;
        this.KSMKPI_CLASS_IMPL = ksmkpiClassImpl;


    }

    @Override
    public T setRuleId(String ksmKpiCalulationRuleId){
        this.ksmKpiCalulationRuleId= ksmKpiCalulationRuleId;
        return (T) this;
    }

    @Override
    public KSMKPI build() throws IllegalAccessException, InstantiationException {
        IKSMKPI tmpKpi = this.KSMKPI_CLASS_IMPL.newInstance();
        tmpKpi.setDescription(this.ksmObjDescription);
        tmpKpi.setName(this.ksmObjName);
        tmpKpi.setStatus(this.status);
        tmpKpi.setValue(this.value);
        tmpKpi.setKMMKPICalculationRuleId(this.ksmKpiCalulationRuleId);
        tmpKpi.setKsmIndicatorType("KSMKPI");
        KSMObjectServiceFactory.getKSMKPIService((Class<? extends KSMKPI>) KSMKPI_CLASS_IMPL,  this.RELATED_KSMCI , this.ksmObjectApiServiceProvider).createOrUpdate(tmpKpi)


        return null;
    }
}

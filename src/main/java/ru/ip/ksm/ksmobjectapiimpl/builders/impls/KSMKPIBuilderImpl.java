package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMIndicatorBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

public class KSMKPIBuilderImpl <T extends KSMKPIBuilderImpl<T,U>, U extends IKSMKPI<U>>
        extends BaseKSMIndicatorBuilderImpl<T,U>
        implements KSMKPIBuilder<T,U>{
//    public KSMKPIBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
//        super(ksmObjectApiServiceProvider);
//    }

    private final Class<? extends IKSMKPI> KSMKPI_CLASS_IMPL ;

    private String ksmKpiCalulationRuleId;

    public KSMKPIBuilderImpl(Class<? extends IKSMKPI> ksmkpiClassImpl
            , KSMObjectApiServiceProvider ksm_object_api_service_provider
            , IKSMCI ksmci) {
        super(ksm_object_api_service_provider , ksmci);
        this.KSMKPI_CLASS_IMPL = ksmkpiClassImpl;


    }

    @Override
    public T setRuleId(String ksmKpiCalulationRuleId){
        this.ksmKpiCalulationRuleId= ksmKpiCalulationRuleId;
        return (T) this;
    }

    @Override
    public U build() throws IllegalAccessException, InstantiationException {
        /*TODO: переделать на что-то более логичное*/
        IKSMKPI tmpKpi = this.KSMKPI_CLASS_IMPL.newInstance();
        tmpKpi.setDescription(this.ksmObjDescription);
        tmpKpi.setName(this.ksmObjName);
        tmpKpi.setStatus(this.status);
        tmpKpi.setValue(this.value);
        tmpKpi.setKMMKPICalculationRuleId(this.ksmKpiCalulationRuleId);
        tmpKpi.setKsmIndicatorType("KSMKPI");
        tmpKpi.setRelatedKSMCI(this.RELATED_KSMCI);
        return (U) KSMObjectServiceFactory.getKSMKPIService( KSMKPI_CLASS_IMPL,  this.RELATED_KSMCI , this.ksmObjectApiServiceProvider).createOrUpdate(tmpKpi);



    }
}

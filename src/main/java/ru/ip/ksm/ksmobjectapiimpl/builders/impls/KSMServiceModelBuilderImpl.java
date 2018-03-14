package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;

import java.util.HashSet;
import java.util.Set;

public class KSMServiceModelBuilderImpl<T extends  KSMServiceModelBuilder<T> , U extends KSMService>
        //extends KSMCIBuilderImpl<KSMServiceModelBuilder<T>>
        extends KSMCIBuilderImpl<T>
        implements KSMServiceModelBuilder<T> {


    private final Class<? extends IKSMService> CI_SERVICE_IMPL ;
    //private final KSMCIBuilder ksmciBuilder;

    protected Set<KSMCI> relatedKSMCIs = new HashSet<>();
    protected Set<Object> relationShips = new HashSet<>();

    public KSMServiceModelBuilderImpl(Class<? extends KSMService> ksmserviceClassImpl
            , KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        super(ksmserviceClassImpl ,ksm_object_api_service_provider );
        //this.ksmciBuilder = KSMObjectBuilderfactory.getCIBuilder(ksm_object_api_service_provider);
        this.CI_SERVICE_IMPL = ksmserviceClassImpl;

    }


    public T addKSMCI(KSMCI ksmci) {
        this.relatedKSMCIs.add(ksmci);
        return (T) this;
    }

    @Override
    public T addKSMCI(String ksmCiObjectId) {
        throw new IllegalArgumentException("not implemented");
    }


}

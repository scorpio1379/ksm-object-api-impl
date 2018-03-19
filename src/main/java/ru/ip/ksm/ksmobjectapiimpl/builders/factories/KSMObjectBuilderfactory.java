package ru.ip.ksm.ksmobjectapiimpl.builders.factories;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.*;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMHIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.types.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.*;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.*;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;

public class KSMObjectBuilderfactory {
    private static final Class<? extends IKSMCI> KSMCI_CLASS_IMPL = KSMCIImpl.class;
    private static final Class<? extends IKSMService> KSMSERVICE_CLASS_IMPL = KSMServiceImpl.class;
    private static final Class<? extends IKSMServiceModel> KSMSERVICE_MODEL_CLASS_IMPL = KSMServiceModelImpl.class;
    private static final Class<? extends IKSMKPI> KSMKPI_CLASS_IMPL = KSMKPIImpl.class;
    private static final Class<? extends IKSMHI> KSMHI_CLASS_IMPL = KSMHIImpl.class;


    public static IKSMServiceModelBuilder getKSMServiceModelBuilder(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        return new KSMServiceModelBuilderImpl(KSMSERVICE_MODEL_CLASS_IMPL , ksm_object_api_service_provider);
    }

    public static KSMKPIBuilder getKSMKPIBuilder(KSMObjectApiServiceProvider ksm_object_api_service_provider , IKSMCI ksmci) {
        return new KSMKPIBuilderImpl(KSMKPI_CLASS_IMPL , ksm_object_api_service_provider , ksmci );
    }

    public static KSMHIBuilder getKSMHIBuilder(KSMObjectApiServiceProvider ksm_object_api_service_provider, IKSMCI ksmci) {
        return new KSMHIBuilderImpl(KSMHI_CLASS_IMPL , ksm_object_api_service_provider , ksmci );
    }

    public static IKSMServiceBuilder<KSMServiceBuilder,KSMService> getKSMServiceBuilder(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        return new KSMServiceBuilderImpl(KSMSERVICE_CLASS_IMPL , ksmObjectApiServiceProvider);
    }

    public static IKSMCIBuilder getKSMCIBuilder(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        return new KSMCIBuilderImpl(KSMCI_CLASS_IMPL , ksm_object_api_service_provider);
    }
}

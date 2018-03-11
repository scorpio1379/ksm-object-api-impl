package ru.ip.ksm.ksmobjectapiimpl.builders.factories;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMCIBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMKPIBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMServiceModelBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMKPIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;

public class KSMObjectBuilderfactory {
    private static final Class<? extends KSMCI> KSMCI_CLASS_IMPL = KSMCIImpl.class;
    private static final Class<? extends KSMService> KSMSERVICE_CLASS_IMPL = KSMServiceImpl.class;
    private static final Class<? extends KSMKPI> KSMKPI_CLASS_IMPL = KSMKPIImpl.class;

    public static KSMCIBuilder getCIBuilder(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        return new KSMCIBuilderImpl(KSMCI_CLASS_IMPL , ksm_object_api_service_provider);

    }

    public static KSMServiceModelBuilder getKSMServiceModelBuilder(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        return new KSMServiceModelBuilderImpl(KSMSERVICE_CLASS_IMPL , ksm_object_api_service_provider);
    }

    public static KSMKPIBuilder getKSMKPIBuilder(KSMObjectApiServiceProvider ksm_object_api_service_provider , KSMCI ksmci) {
        return new KSMKPIBuilderImpl(KSMKPI_CLASS_IMPL , ksm_object_api_service_provider , ksmci );
    }
}

package ru.ip.ksm.ksmobjectapiimpl.ksmservices;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.*;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

import java.util.HashSet;
import java.util.Set;

public class KSMToplogyServiceImpl  implements KSMTopologyService {

    private final KSMObjectApiServiceProvider KSM_OBJECT_API_SERVICE_PROVIDER;

    public KSMToplogyServiceImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        KSM_OBJECT_API_SERVICE_PROVIDER = ksmObjectApiServiceProvider;
    }

    @Override
    public Set<KSMCI> getAllKSMCIs() {
        Set<KSMCI> returnSet = new HashSet<>();
        Iterable<KSMCI> iterables = KSMObjectServiceFactory.getKSMCIService(KSMCIImpl.class, KSM_OBJECT_API_SERVICE_PROVIDER).findAll();
        iterables.forEach(ksmci -> returnSet.add(ksmci));
        return returnSet;
    }

    @Override
    public Set<AbstarctKSMIndicator> getAllIndicators() {
        throw new IllegalArgumentException("Not Implemented YET");
    }

    @Override
    public Set<KSMHI> getAllKSMHIs() {
        throw new IllegalArgumentException("Not Implemented YET");
    }

    @Override
    public Set<KSMKPI> getAllKPIs() {
        throw new IllegalArgumentException("Not Implemented YET");
    }

    @Override
    public Set<KSMService> getAllKSMServices() {
        throw new IllegalArgumentException("Not Implemented YET");
    }

    @Override
    public KSMCIBuilder createNewCI() {
        return KSMObjectBuilderfactory.getCIBuilder(KSM_OBJECT_API_SERVICE_PROVIDER);
    }

    @Override
    public KSMServiceModelBuilder createNewKSMServiceModel() {
        return KSMObjectBuilderfactory.getKSMServiceModelBuilder(KSM_OBJECT_API_SERVICE_PROVIDER);
    }

    @Override
    public KSMService getKSMService(String ksmObjectId) {
        throw new IllegalArgumentException("Not Implemented YET");
    }

    @Override
    public KSMKPIBuilder addNewKSMKPIToKSMCI(KSMCI ksmci) {
        return KSMObjectBuilderfactory.getKSMKPIBuilder(KSM_OBJECT_API_SERVICE_PROVIDER ,ksmci);
    }
}

package ru.ip.ksm.ksmobjectapiimpl.ksmservices;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMRelationShipBuilderFactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.*;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.*;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.KSMServiceModelManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.managerfactory.KSMObjectManagerFactory;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

import java.util.HashSet;
import java.util.Set;

public class KSMToplogyServiceImpl  implements KSMTopologyService {

    private final KSMObjectApiServiceProvider KSM_OBJECT_API_SERVICE_PROVIDER;

    public KSMToplogyServiceImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        KSM_OBJECT_API_SERVICE_PROVIDER = ksmObjectApiServiceProvider;
    }

    /*TODO: необходимо спроэктировать класс Manager для каждого типа доменного класса в который убрать методы создания экземпляров через соответствующие фабрикиа в классе Manager реализовать метод get()
     */

    @Override
    public Set<IKSMCI> getAllKSMCIs() {
        Set<IKSMCI> returnSet = new HashSet<>();
        Iterable<KSMCI> iterables = KSMObjectServiceFactory.getKSMCIService(KSMCIImpl.class, KSM_OBJECT_API_SERVICE_PROVIDER).findAll();
        iterables.forEach(ksmci -> returnSet.add(ksmci));
        return returnSet;
    }

    @Override
    public Set<AbstarctKSMIndicator> getAllIndicators(KSMCI ksmci) {
        throw new IllegalArgumentException("Not Implemented YET");
    }

    @Override
    public Set<KSMHI> getAllKSMHIs(KSMCI ksmci) {
        throw new IllegalArgumentException("Not Implemented YET");
    }

    @Override
    public Set<KSMKPI> getAllKPIs(KSMCI ksmci) {
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
        return KSMObjectManagerFactory.getKSMServiceModelManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMServiceModelBuilder();
    }

    @Override
    public KSMServiceModel getKSMServiceModel(String ksmObjectId) {
        return KSMObjectManagerFactory.getKSMServiceModelManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMObject(ksmObjectId);
    }

    @Override
    public KSMServiceBuilder createNewKSMService() {
        return KSMObjectManagerFactory.getKSMServiceManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMServiceBuilder();
    }

    @Override
    public KSMService getKSMService(String ksmObjectId) {
        return (KSMService) KSMObjectManagerFactory.getKSMServiceManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMObject(ksmObjectId);
    }

    @Override
    public KSMKPIBuilder addNewKSMKPIToKSMCI(KSMCI ksmci) {
        return KSMObjectBuilderfactory.getKSMKPIBuilder(KSM_OBJECT_API_SERVICE_PROVIDER ,ksmci);
    }

    @Override
    public KSMHIBuilder addNewKSMHIToKSMCI(KSMCI ksmci) {
        return KSMObjectBuilderfactory.getKSMHIBuilder(KSM_OBJECT_API_SERVICE_PROVIDER ,ksmci);
    }

    @Override
    public void linkKSMCI2KSMCI(KSMCI sourceKSMCI, KSMCI targetKSMCI) {
        KSMObjectManagerFactory.getKSMCI2KSMCIKSMRelationShipManager(KSM_OBJECT_API_SERVICE_PROVIDER).linkKSMCI2KSMCI(sourceKSMCI, targetKSMCI);

    }
}

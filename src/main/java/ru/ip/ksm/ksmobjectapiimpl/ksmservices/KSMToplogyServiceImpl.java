package ru.ip.ksm.ksmobjectapiimpl.ksmservices;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMHIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.*;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceModelManager;
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
        Iterable<IKSMCI> iterables = KSMObjectServiceFactory.getKSMCIService(KSMCIImpl.class, KSM_OBJECT_API_SERVICE_PROVIDER).findAll();
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
        return KSMObjectManagerFactory.getKSMServiceManager(KSM_OBJECT_API_SERVICE_PROVIDER).getAllKSMObjectOfThatType();
    }

    @Override
    public IKSMCIBuilder createNewCI() {
        return  KSMObjectBuilderfactory.getKSMCIBuilder(KSM_OBJECT_API_SERVICE_PROVIDER);
    }

    @Override
    public IKSMServiceModelBuilder createNewKSMServiceModel() {
        return KSMObjectManagerFactory.getKSMServiceModelManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMServiceModelBuilder();
    }

    @Override
    public IKSMServiceModel getKSMServiceModel(String ksmObjectId) {
        IKSMServiceModelManager mgr = KSMObjectManagerFactory.getKSMServiceModelManager(KSM_OBJECT_API_SERVICE_PROVIDER);
        IKSMServiceModel ret = KSMObjectManagerFactory.getKSMServiceModelManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMObject(ksmObjectId);
        return ret;
    }

    @Override
    public IKSMServiceBuilder createNewKSMService() {
        return KSMObjectManagerFactory.getKSMServiceManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMServiceBuilder();
    }

    @Override
    public KSMService getKSMService(String ksmObjectId) {
        return (KSMService) KSMObjectManagerFactory.getKSMServiceManager(KSM_OBJECT_API_SERVICE_PROVIDER).getKSMObject(ksmObjectId);
    }

    @Override
    public KSMKPIBuilder addNewKSMKPIToKSMCI(IKSMCI<? extends IKSMCI> ksmci) {
        return KSMObjectBuilderfactory.getKSMKPIBuilder(KSM_OBJECT_API_SERVICE_PROVIDER ,ksmci);
    }

    @Override
    public KSMHIBuilder addNewKSMHIToKSMCI(IKSMCI<? extends IKSMCI> ksmci) {
        return KSMObjectBuilderfactory.getKSMHIBuilder(KSM_OBJECT_API_SERVICE_PROVIDER ,ksmci);
    }

    @Override
    public void linkKSMCI2KSMCI(IKSMCI<? extends IKSMCI> sourceKSMCI, IKSMCI<? extends IKSMCI> targetKSMCI) {
        KSMObjectManagerFactory.getKSMCI2KSMCIKSMRelationShipManager(KSM_OBJECT_API_SERVICE_PROVIDER).linkKSMCI2KSMCI(sourceKSMCI, targetKSMCI);

    }
}

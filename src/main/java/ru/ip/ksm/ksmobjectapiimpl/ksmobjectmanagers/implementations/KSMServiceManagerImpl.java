package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMCIManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.KSMServiceManager;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

public class KSMServiceManagerImpl<T extends IKSMServiceManager<T,U>,U extends IKSMService>
        extends KSMCIManagerImpl<T,U>
        implements IKSMServiceManager<T,U> {

    protected static final Class<? extends IKSMService> KSMSERVICE_CLASS_IMPL = KSMServiceImpl.class;

    public KSMServiceManagerImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
    }

    @Override
    public U getKSMObject(String ksmObjectId) {
        return (U) KSMObjectServiceFactory.getKSMServiceService(KSMSERVICE_CLASS_IMPL , this.ksmObjectApiServiceProvider).find(ksmObjectId);
    }

    @Override
    public KSMServiceBuilder getKSMServiceBuilder() {
        return KSMObjectBuilderfactory.getKSMServiceBuilder(this.ksmObjectApiServiceProvider);
    }
}

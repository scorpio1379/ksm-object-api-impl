package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.types.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceManager;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMServiceService;

import java.util.HashSet;
import java.util.Set;

public class KSMServiceManagerImpl<T extends IKSMServiceManager<T,U>,U extends IKSMService<U>>
        extends KSMCIManagerImpl<T,U>
        implements IKSMServiceManager<T,U> {

    protected static final Class<? extends IKSMService> KSMSERVICE_CLASS_IMPL = KSMServiceImpl.class;
    private final IKSMServiceService<IKSMService> ksmServiceService;


    public KSMServiceManagerImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
        this.ksmServiceService =  KSMObjectServiceFactory.getKSMServiceService(KSMSERVICE_CLASS_IMPL,ksmObjectApiServiceProvider);
    }

    @Override
    public U getKSMObject(String ksmObjectId) {

        return (U) this.ksmServiceService.find(ksmObjectId);
    }

    @Override
    public IKSMServiceBuilder<KSMServiceBuilder,KSMService> getKSMServiceBuilder() {
        return KSMObjectBuilderfactory.getKSMServiceBuilder(this.ksmObjectApiServiceProvider);

    }

    @Override
    public Set<U> getAllKSMObjectOfThatType() {
        HashSet<U> ksmServices = new HashSet<>();
        Iterable<IKSMService> srvcs = this.ksmServiceService.findAll();

        for (IKSMService srvc: this.ksmServiceService.findAll()
             ) {
            ksmServices.add((U) srvc);

        }
        return ksmServices;
    }
}

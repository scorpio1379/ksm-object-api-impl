package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations.abstracts.BaseKSMObjectManagerImpl;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMCIManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.KSMCIManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.abstracts.AbstractKSMObjectManager;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

public class KSMCIManagerImpl<T extends IKSMCIManager<T,U>,U extends IKSMCI>
        extends BaseKSMObjectManagerImpl<T,U>
        implements IKSMCIManager<T,U> {

    protected static final Class<? extends IKSMCI> KSMCI_CLASS_IMPL = KSMCIImpl.class;

    public KSMCIManagerImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
    }

    @Override
    public U getKSMObject(String ksmObjectId) {
        return (U) KSMObjectServiceFactory.getKSMCIService(this.KSMCI_CLASS_IMPL , ksmObjectApiServiceProvider).find(ksmObjectId);
    }
}

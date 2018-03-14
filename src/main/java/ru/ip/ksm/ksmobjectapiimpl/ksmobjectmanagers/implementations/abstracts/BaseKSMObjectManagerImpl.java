package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.abstracts.AbstractKSMObjectManager;

public abstract class BaseKSMObjectManagerImpl<T extends AbstractKSMObjectManager<T ,U> ,U extends IKSMObject>
        implements AbstractKSMObjectManager<T ,U> {
    protected final KSMObjectApiServiceProvider ksmObjectApiServiceProvider;


    public BaseKSMObjectManagerImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        this.ksmObjectApiServiceProvider = ksmObjectApiServiceProvider;
    }
}

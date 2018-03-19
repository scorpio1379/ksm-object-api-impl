package ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;

public abstract class BaseKSMIndicatorBuilderImpl<T extends BaseKSMIndicatorBuilderImpl<T ,U> , U extends IKSMIndicator<U>>
        extends BaseKSMObjectBuilderImpl<T,U>
        implements AbstractKSMIndicatorBuilder<T ,U> {
    protected final IKSMCI RELATED_KSMCI;
    protected String status;
    protected String value;

    public BaseKSMIndicatorBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider,IKSMCI ksmci) {
        super(ksmObjectApiServiceProvider);
        this.RELATED_KSMCI = ksmci;
    }

    @Override
    public T setStatus(String status) {
        this.status = status;
        return (T) this;
    }

    @Override
    public T setValue(String value) {
        this.value = value;
        return (T) this;
    }
}

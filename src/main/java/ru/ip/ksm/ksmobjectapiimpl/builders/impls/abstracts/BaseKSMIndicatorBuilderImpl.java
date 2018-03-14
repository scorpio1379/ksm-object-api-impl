package ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

public abstract class BaseKSMIndicatorBuilderImpl<T extends AbstractKSMIndicatorBuilder<T>>
        extends BaseKSMObjectBuilderImpl<T>
        implements AbstractKSMIndicatorBuilder<T> {
    protected final KSMCI RELATED_KSMCI;
    protected String status;
    protected String value;

    public BaseKSMIndicatorBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider,KSMCI ksmci) {
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

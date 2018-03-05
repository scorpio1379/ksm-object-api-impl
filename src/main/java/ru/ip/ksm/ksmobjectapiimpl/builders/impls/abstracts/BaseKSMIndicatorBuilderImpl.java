package ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;

public class BaseKSMIndicatorBuilderImpl<T extends AbstractKSMIndicatorBuilder<T>>
        extends BaseKSMObjectBuilderImpl<T>
        implements AbstractKSMIndicatorBuilder<T> {

    protected String status;
    protected String value;

    public BaseKSMIndicatorBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
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

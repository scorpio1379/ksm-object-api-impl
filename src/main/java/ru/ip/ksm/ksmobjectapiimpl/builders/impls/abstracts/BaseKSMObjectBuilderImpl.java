package ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMObjectBuilder;

public class BaseKSMObjectBuilderImpl<T extends AbstractKSMObjectBuilder<T>>
        implements AbstractKSMObjectBuilder<T> {
    protected String ksmObjName;
    protected String ksmObjDescription;
    protected String ksmObjId;
    protected final KSMObjectApiServiceProvider ksmObjectApiServiceProvider ;

    public BaseKSMObjectBuilderImpl(ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        this.ksmObjectApiServiceProvider = ksmObjectApiServiceProvider;
    }



    @Override
    public T setName(String ksmObjName) {
        this.ksmObjName = ksmObjName;
        return (T) this;
    }

    @Override
    public T setDescription(String ksmObjDescription) {
        this.ksmObjDescription = ksmObjDescription;
        return (T) this;
    }

    @Override
    public T setKsmObjectId(String ksmObjectId) {
        this.ksmObjId=ksmObjectId;
        return (T) this;
    }

}

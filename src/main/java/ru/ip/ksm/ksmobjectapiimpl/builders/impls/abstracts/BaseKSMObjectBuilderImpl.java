package ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMObjectBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;

public abstract class BaseKSMObjectBuilderImpl<T extends BaseKSMObjectBuilderImpl<T ,U> , U extends IKSMObject<U> >
        implements AbstractKSMObjectBuilder<T,U> {
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
    @Override
    public boolean isValidKsmObjectId(String ksmObjectId){
        if ((ksmObjectId!=null) && (!ksmObjectId.isEmpty())){
            //throw new IllegalArgumentException("ksmObjId NOT a UUID String");
            return ksmObjectId.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}");

        }else{
            return false;
            //throw new IllegalArgumentException("KSMObjectId is Null or Empty");
        }
    }
    @Override
    public U build() throws IllegalAccessException, InstantiationException {
        throw new IllegalArgumentException("this build is in abstaract class");
    }


    protected boolean stringFieldNotNullOrEmpty(String builderStringField) {
        return (builderStringField != null) && (!builderStringField.isEmpty());
    }


}

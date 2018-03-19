package ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces;


import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMObjectBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;


public interface IKSMCIBuilder<T extends IKSMCIBuilder<T,U> ,U extends IKSMCI<U>>
        //extends AbstractKSMObjectBuilder<KSMCIBuilder<T>>
        extends AbstractKSMObjectBuilder<T ,U>{


    U build();
    T goSmthgwithCIBuilder(T t);
    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);
}

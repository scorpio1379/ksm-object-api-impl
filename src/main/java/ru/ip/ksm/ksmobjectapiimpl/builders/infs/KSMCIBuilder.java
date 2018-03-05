package ru.ip.ksm.ksmobjectapiimpl.builders.infs;


import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMObjectBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;


public interface KSMCIBuilder<T extends KSMCIBuilder<T>>
        //extends AbstractKSMObjectBuilder<KSMCIBuilder<T>>
        extends AbstractKSMObjectBuilder<T>{


    KSMCI build();
    T goSmthgwithCIBuilder(T t);
    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);
}

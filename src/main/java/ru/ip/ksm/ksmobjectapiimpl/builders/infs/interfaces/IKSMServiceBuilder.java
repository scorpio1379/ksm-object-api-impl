package ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;

public interface IKSMServiceBuilder<T extends IKSMServiceBuilder<T,U>, U extends IKSMService<U>>
        extends IKSMCIBuilder<T,U> {
    U build();
    T goSmthgwithCIBuilder(T t);
    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);
}

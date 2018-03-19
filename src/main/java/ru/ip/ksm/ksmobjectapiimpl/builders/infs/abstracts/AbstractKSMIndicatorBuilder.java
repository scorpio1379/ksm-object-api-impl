package ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;

public interface AbstractKSMIndicatorBuilder<T extends AbstractKSMIndicatorBuilder<T,U> , U extends IKSMIndicator<U>>
        extends AbstractKSMObjectBuilder<T,U> {
    T setStatus(String status);
    T setValue(String value);

    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);

    U build() throws IllegalAccessException, InstantiationException;
}

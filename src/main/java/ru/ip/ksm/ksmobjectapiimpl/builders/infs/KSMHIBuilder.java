package ru.ip.ksm.ksmobjectapiimpl.builders.infs;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;


public interface KSMHIBuilder<T extends KSMHIBuilder<T,U> ,U extends IKSMHI<U>>
        extends AbstractKSMIndicatorBuilder<T,U> {
    T setStatus(String status);
    T setValue(String value);

    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);

    U build() throws IllegalAccessException, InstantiationException;
}

package ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;

public interface AbstractKSMObjectBuilder<T extends AbstractKSMObjectBuilder<T ,U> , U extends IKSMObject<U>> {

    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);

    U build() throws IllegalAccessException, InstantiationException;
    boolean isValidKsmObjectId(String ksmObjectId);

}

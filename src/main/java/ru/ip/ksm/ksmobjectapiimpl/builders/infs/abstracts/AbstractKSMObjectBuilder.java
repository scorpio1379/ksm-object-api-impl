package ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts;

public interface AbstractKSMObjectBuilder<T extends AbstractKSMObjectBuilder<T>> {

    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);

    boolean isValidKsmObjectId(String ksmObjectId);
}

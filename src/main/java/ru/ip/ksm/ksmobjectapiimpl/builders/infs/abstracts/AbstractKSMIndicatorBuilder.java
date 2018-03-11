package ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts;

public interface AbstractKSMIndicatorBuilder<T extends AbstractKSMIndicatorBuilder<T>>
        extends AbstractKSMObjectBuilder<T> {
    T setStatus(String status);
    T setValue(String value);

    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);
}

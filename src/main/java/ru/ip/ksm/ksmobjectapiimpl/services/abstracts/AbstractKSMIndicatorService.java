package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.AbstractKSMObject;

public interface AbstractKSMIndicatorService<T extends AbstractKSMObject>
        extends AbstractKSMObjectService<T> {

    T doSomeThingWithIndicator(T indicator);
}

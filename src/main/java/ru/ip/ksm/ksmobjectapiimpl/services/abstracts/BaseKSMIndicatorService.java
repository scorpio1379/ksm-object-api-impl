package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.AbstractKSMObject;

public abstract class BaseKSMIndicatorService<T extends U , U extends AbstractKSMObject>
        extends BaseKSMObjectServiceOGMImpl<T>
        implements AbstractKSMIndicatorService<T> {

    @Override
    public T doSomeThingWithIndicator(T indicator){
        return indicator;
    }

}

package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;

public abstract class BaseKSMIndicatorService<T extends U , U extends IKSMIndicator>
        extends BaseKSMObjectServiceOGMImpl<T>
        implements AbstractKSMIndicatorService<T> {

    protected final IKSMCI related_ksmci;

    public BaseKSMIndicatorService(IKSMCI related_ksmci) {
        this.related_ksmci = related_ksmci;
    }

    @Override
    public T doSomeThingWithIndicator(T indicator){
        return indicator;
    }

}

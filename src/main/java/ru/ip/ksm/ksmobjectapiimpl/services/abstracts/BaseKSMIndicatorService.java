package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.AbstractKSMObject;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

public abstract class BaseKSMIndicatorService<T extends U , U extends IKSMIndicator>
        extends BaseKSMObjectServiceOGMImpl<T>
        implements AbstractKSMIndicatorService<T> {

    protected final KSMCI related_ksmci;

    public BaseKSMIndicatorService(KSMCI related_ksmci) {
        this.related_ksmci = related_ksmci;
    }

    @Override
    public T doSomeThingWithIndicator(T indicator){
        return indicator;
    }

}

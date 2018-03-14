package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;

public interface AbstractKSMObjectManager<T extends AbstractKSMObjectManager<T , U> , U extends IKSMObject> {
    U getKSMObject(String ksmObjectId);
}

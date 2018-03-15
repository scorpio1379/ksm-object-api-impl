package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;

public interface AbstractKSMObjectService<KSMOBJ extends IKSMObject> {

    KSMOBJ doSomethingWithKSMObject(KSMOBJ ksmObject);

    Iterable<KSMOBJ> findAll();

    KSMOBJ find(Long id);

    KSMOBJ find(String ksmObjId);

    KSMOBJ findByKsmObjId(String ksmObjId);

    KSMOBJ createOrUpdate(KSMOBJ ksmObject);

    void delete(Long id);

    void delete(String id);

    void deleteByKsmObjId(String ksmObjId);


}

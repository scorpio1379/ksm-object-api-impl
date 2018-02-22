package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseObjectImpl;

public interface AbstractKSMObjectService<KSMOBJ extends KSMBaseObjectImpl> {
    Iterable<KSMOBJ> findAll();

    KSMOBJ find(Long id);

    KSMOBJ find(String ksmObjId);

    KSMOBJ findByKsmObjId(String ksmObjId);

    void delete(Long id);

    void deleteByKsmObjId(String ksmObjId);

    KSMOBJ createOrUpdate(KSMOBJ ksmObject);
}

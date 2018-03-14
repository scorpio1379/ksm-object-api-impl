package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.abstracts.AbstractKSMRelationShip;

public interface AbstractKSMRelationShipService<KSMREL extends AbstractKSMRelationShip<STARTNODE,ENDNODE>
        , STARTNODE extends IKSMObject
        , ENDNODE extends IKSMObject > {


    Iterable findAll();

    KSMREL find(Long id);

    KSMREL find(String ksmRelationShipId);

    KSMREL findByKsmObjId(String ksmRelationShipId);

    void delete(Long id);

    void delete(String id);

    void deleteByKsmObjId(String ksmRelationShipId);

    KSMREL createOrUpdate(KSMREL ksmRelationShip);

}

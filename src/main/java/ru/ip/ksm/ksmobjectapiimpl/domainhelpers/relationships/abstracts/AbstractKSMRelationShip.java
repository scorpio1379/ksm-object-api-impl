package ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;

public interface AbstractKSMRelationShip<STARTNODE extends IKSMObject, ENDNODE extends IKSMObject> {
    String getKsmRelationShipId();

    String getStartNodeKsmObjectId();

    String getEndNodeKsmObjectId();

    STARTNODE getStartNode();


    ENDNODE getEndNode();
}

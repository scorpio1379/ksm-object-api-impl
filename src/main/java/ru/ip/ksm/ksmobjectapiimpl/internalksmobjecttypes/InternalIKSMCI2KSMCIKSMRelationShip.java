package ru.ip.ksm.ksmobjectapiimpl.internalksmobjecttypes;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;

public interface InternalIKSMCI2KSMCIKSMRelationShip<STARTNODE extends IKSMCI , ENDNODE extends IKSMCI>
        extends IKSMCI2KSMCIKSMRelationShip<STARTNODE , ENDNODE> {
    void setStartNode(STARTNODE startNode);
    void setEndNode(ENDNODE endNode);
    void setKsmRelationShipId(String ksmRelationShipId);
    STARTNODE getStartNode();

    ENDNODE getEndNode();
}

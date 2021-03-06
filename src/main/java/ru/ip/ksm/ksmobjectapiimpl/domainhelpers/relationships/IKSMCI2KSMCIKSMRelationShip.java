package ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships;

import org.json.JSONObject;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.abstracts.AbstractKSMRelationShip;

public interface IKSMCI2KSMCIKSMRelationShip<STARTNODE extends IKSMCI, ENDNODE extends IKSMCI>
        extends AbstractKSMRelationShip<STARTNODE , ENDNODE> {
    STARTNODE getStartNode();

    ENDNODE getEndNode();


    String toJSONString();

    JSONObject toJson();
}

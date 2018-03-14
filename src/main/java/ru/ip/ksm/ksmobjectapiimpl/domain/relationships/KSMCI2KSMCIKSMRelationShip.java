package ru.ip.ksm.ksmobjectapiimpl.domain.relationships;

import org.neo4j.ogm.annotation.*;
import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.abstracts.BaseKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.internalksmobjecttypes.InternalIKSMCI2KSMCIKSMRelationShip;

@RelationshipEntity(type="Linked_KSMCI")
public class KSMCI2KSMCIKSMRelationShip<STARTNODE extends IKSMCI, ENDNODE extends IKSMCI>
        //extends BaseKSMRelationShip<STARTNODE , ENDNODE>
implements IKSMCI2KSMCIKSMRelationShip<STARTNODE , ENDNODE> , InternalIKSMCI2KSMCIKSMRelationShip<STARTNODE , ENDNODE>{
    @Id
    @Index(unique = true , primary = true)
    @GeneratedValue(strategy = org.neo4j.ogm.id.UuidStrategy.class)
    protected String ksmRelationShipId;
    @Override
    public String getKsmRelationShipId(){
        return this.ksmRelationShipId;
    }


    @StartNode
    protected STARTNODE startNode;
    @EndNode
    protected ENDNODE endNode;


    @Override
    public String getStartNodeKsmObjectId() {
        return startNode.getKsmObjectId();
    }
    @Override
    public String getEndNodeKsmObjectId() {
        return endNode.getKsmObjectId();
    }

    @Override
    public STARTNODE getStartNode() {
        return startNode;
    }


    @Override
    public void setStartNode(STARTNODE startNode) {
        this.startNode = startNode;
    }
    @Override
    public ENDNODE getEndNode() {
        return endNode;
    }

    @Override
    public void setEndNode(ENDNODE endNode) {
        this.endNode = endNode;
    }

    @Override
    public void setKsmRelationShipId(String ksmRelationShipId) {
        this.ksmRelationShipId = ksmRelationShipId;
    }

}

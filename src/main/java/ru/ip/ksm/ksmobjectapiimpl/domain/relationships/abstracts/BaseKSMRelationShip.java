package ru.ip.ksm.ksmobjectapiimpl.domain.relationships.abstracts;

import org.neo4j.ogm.annotation.*;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.abstracts.AbstractKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.AbstractKSMObject;

@RelationshipEntity(type="Base_RelationShip")
public class BaseKSMRelationShip<STARTNODE extends IKSMObject, ENDNODE extends IKSMObject>
        implements AbstractKSMRelationShip<STARTNODE , ENDNODE> {

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


    public void setStartNode(STARTNODE startNode) {
        this.startNode = startNode;
    }
    @Override
    public ENDNODE getEndNode() {
        return endNode;
    }

    public void setEndNode(ENDNODE endNode) {
        this.endNode = endNode;
    }
}

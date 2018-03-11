package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

@RelationshipEntity(type ="LinkedKSMCI" )
public class LinkedKSMCIKSMRelationShip {
    @StartNode
    private KSMCI sourceksmci;
    @EndNode
    private KSMCI targetksmci;
}

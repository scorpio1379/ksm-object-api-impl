package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;

@RelationshipEntity(type ="AttachedKSMHI" )
public class AttachedKSMHIKSMRelationShip {
    @StartNode
    private KSMHI ksmhi;
    @EndNode
    private KSMCI ksmci;

    public AttachedKSMHIKSMRelationShip(KSMHI ksmhi, KSMCI ksmci) {
        this.ksmhi = ksmhi;
        this.ksmci = ksmci;
    }
}

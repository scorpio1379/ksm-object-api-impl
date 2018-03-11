package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

@RelationshipEntity(type ="AttachedKSMKPI" )
public class AttachedKSMKPIKSMRelationShip {
    @StartNode
    private KSMKPI ksmkpi;
    @EndNode
    private KSMCI ksmci;

    public AttachedKSMKPIKSMRelationShip(KSMKPI ksmkpi, KSMCI ksmci) {
        this.ksmkpi = ksmkpi;
        this.ksmci = ksmci;
    }
}

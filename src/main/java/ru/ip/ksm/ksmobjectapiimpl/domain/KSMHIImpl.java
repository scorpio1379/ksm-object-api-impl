package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;

import java.util.Set;

@NodeEntity
public class KSMHIImpl
        extends KSMBaseIndicatorImpl
        implements KSMHI {

    /** связь с KSMCI*/
    @Relationship(type = "AttachedKSMHI")
    protected AttachedKSMHIKSMRelationShip attachedKSMHIKSMRelationShip;


    public KSMHIImpl() {
        super();
        this.ksmIndicatorType = "KSMHI";
    }
}

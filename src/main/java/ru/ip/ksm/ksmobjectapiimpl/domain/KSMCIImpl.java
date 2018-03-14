package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.cypher.internal.frontend.v2_3.SemanticDirection;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMHIBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseObjectImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

import java.util.Set;

@NodeEntity
public class KSMCIImpl
        extends KSMBaseObjectImpl
        implements IKSMCI {

    protected String ksmCIType = "REGULAR";

    /** связь с KSMKPI*/
    @Relationship(type = "AttachedKSMKPI")
    private Set<KSMKPIImpl> attachedKSMKPIs;
    /** связи с KSMHI*/
    @Relationship(type = "AttachedKSMHI")
    private Set<KSMHIImpl> attachedKSMHIs;

    /** связи с  родительскими KSMCI*/
    @Relationship(type = "Linked_KSMCI" , direction = "OUTGOING")
    private Set<KSMCIImpl> parentKSMCIs;

    /** связи с  дочерними KSMCI*/
    @Relationship(type = "Linked_KSMCI" , direction = "INCOMING")
    private Set<KSMCIImpl> childKSMCIs;

    public KSMCIImpl() {
        super();
        this.ksmObjectType = "KSMCI";
        this.ksmCIType = "REGULAR";
    }

    public KSMCIImpl(String ksmObjectId
            ,String ksmObjectType
            , String name
            , String description
            , String debuginfo
            ,String ksmCIType) {

        super(ksmObjectId, ksmObjectType, name,  description, debuginfo);
        this.ksmCIType = ksmCIType;
    }

    public String getKsmCIType() {
        return ksmCIType;
    }
    public String getKsmObjectType() {
        return ksmObjectType;
    }


    public Set<KSMKPIImpl> getAllAttachedKSMKPIs() {
        throw new IllegalArgumentException("Not implemented yet");
        //return null;
    }


    public Set<KSMHIImpl> getAllAttachedKSMHIs() {
        throw new IllegalArgumentException("Not implemented yet");
        //return null;
    }
}

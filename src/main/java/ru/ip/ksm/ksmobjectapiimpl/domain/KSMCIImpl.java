package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.cypher.internal.frontend.v2_3.SemanticDirection;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMHIBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseObjectImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

import java.util.Set;

@NodeEntity
public class KSMCIImpl
        extends KSMBaseObjectImpl
        implements KSMCI {

    protected String ksmCIType = "REGULAR";

    /** связь с KSMKPI*/
    @Relationship(type = "AttachedKSMKPI")
    private Set<AttachedKSMKPIKSMRelationShip> attachedKSMKPIKSMRelationShips;
    /** связи с KSMHI*/
    @Relationship(type = "AttachedKSMHI")
    private Set<AttachedKSMHIKSMRelationShip> attachedKSMHIKSMRelationShips;

    /** связи с  родительскими KSMCI*/
    @Relationship(type = "LinkedKSMCI" , direction = "OUTGOING")
    private Set<KSMCI> parentKSMCIs;

    /** связи с  дочерними KSMCI*/
    @Relationship(type = "LinkedKSMCI" , direction = "INCOMING")
    private Set<KSMCI> childKSMCIs;

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


    @Override
    public KSMKPI addNewKSMKPI() {
        throw new IllegalArgumentException("Not implemented yet");
        //return null;
    }

    @Override
    public KSMHI addNewKSMHI() {
        throw new IllegalArgumentException("Not implemented yet");

    }

    @Override
    public Set<KSMKPI> getAllAttachedKSMKPIs() {
        throw new IllegalArgumentException("Not implemented yet");
        //return null;
    }

    @Override
    public Set<KSMHI> getAllAttachedKSMHIs() {
        throw new IllegalArgumentException("Not implemented yet");
        //return null;
    }
}

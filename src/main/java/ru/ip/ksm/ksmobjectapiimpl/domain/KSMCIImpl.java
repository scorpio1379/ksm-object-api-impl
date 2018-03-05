package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
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

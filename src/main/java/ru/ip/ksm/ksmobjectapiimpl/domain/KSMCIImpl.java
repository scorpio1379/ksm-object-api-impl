package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseObjectImpl;

@NodeEntity
public class KSMCIImpl extends KSMBaseObjectImpl {

    protected String ksmCIType;

    public KSMCIImpl() {
        super();
        this.ksmObjectType = "KSMCI";
    }
}

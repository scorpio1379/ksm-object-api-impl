package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;

@NodeEntity
public class KSMServiceImpl
        extends KSMCIImpl
        implements KSMService{

    protected String KSMServiceType;

    public KSMServiceImpl() {
        this.ksmCIType = "KSMService";
    }

    public String getKSMServiceType() {
        return KSMServiceType;
    }
}

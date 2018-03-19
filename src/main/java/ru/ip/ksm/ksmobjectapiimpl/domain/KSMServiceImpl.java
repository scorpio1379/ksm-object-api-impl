package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCIService;

@NodeEntity
public class KSMServiceImpl
        extends KSMCIImpl
        implements IKSMService ,KSMService{

    protected String KSMServiceType;

    public KSMServiceImpl() {
        this.ksmCIType = "KSMService";
    }

    public String getKSMServiceType() {
        return KSMServiceType;
    }
}

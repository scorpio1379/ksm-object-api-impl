package ru.ip.ksm.ksmobjectapiimpl.domain;

public class KSMServiceImpl extends KSMCIImpl{

    protected String KSMServiceType;

    public KSMServiceImpl() {
        this.ksmCIType = "KSMService";
    }

    public String getKSMServiceType() {
        return KSMServiceType;
    }
}

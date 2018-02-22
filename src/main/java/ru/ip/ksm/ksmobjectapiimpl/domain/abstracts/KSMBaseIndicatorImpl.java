package ru.ip.ksm.ksmobjectapiimpl.domain.abstracts;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public abstract class KSMBaseIndicatorImpl  extends KSMBaseObjectImpl{
    protected String status;
    protected String value;
    protected String ksmIndicatorType;

    public KSMBaseIndicatorImpl() {
        super();
        this.ksmObjectType = "KSMIndicator";
    }

    public String getStatus() {
        return status;
    }

    public String getValue() {
        return value;
    }

    public String getKsmIndicatorType() {
        return ksmIndicatorType;
    }
}

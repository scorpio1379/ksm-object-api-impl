package ru.ip.ksm.ksmobjectapiimpl.domain.abstracts;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.AbstarctKSMIndicator;

@NodeEntity
public abstract class KSMBaseIndicatorImpl
        extends KSMBaseObjectImpl
        implements AbstarctKSMIndicator {
    protected String status;
    protected String value;
    protected String ksmIndicatorType;

    public KSMBaseIndicatorImpl() {
        super();
        this.ksmObjectType = "KSMIndicator";
    }

    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public String getValue() {
        return value;
    }
    @Override
    public String getKsmIndicatorType() {
        return ksmIndicatorType;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setKsmIndicatorType(String ksmIndicatorType) {
        this.ksmIndicatorType = ksmIndicatorType;
    }
}

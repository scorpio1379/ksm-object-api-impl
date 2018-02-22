package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;

@NodeEntity
public class KSMKPIImpl extends KSMBaseIndicatorImpl{
    protected String ksmRuleId;

    public KSMKPIImpl() {
        super();
        this.ksmIndicatorType = "KSMKPI";
    }
}

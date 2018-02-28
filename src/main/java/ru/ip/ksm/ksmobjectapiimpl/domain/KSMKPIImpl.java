package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

@NodeEntity
public class KSMKPIImpl
        extends KSMBaseIndicatorImpl
        implements KSMKPI {
    protected String ksmRuleId;

    public KSMKPIImpl() {
        super();
        this.ksmIndicatorType = "KSMKPI";
    }
}

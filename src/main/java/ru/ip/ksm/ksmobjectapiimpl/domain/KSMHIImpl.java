package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;

@NodeEntity
public class KSMHIImpl extends KSMBaseIndicatorImpl{


    public KSMHIImpl() {
        super();
        this.ksmIndicatorType = "KSMHI";
    }
}

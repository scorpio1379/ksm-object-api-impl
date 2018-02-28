package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;

@NodeEntity
public class KSMHIImpl
        extends KSMBaseIndicatorImpl
        implements KSMHI {


    public KSMHIImpl() {
        super();
        this.ksmIndicatorType = "KSMHI";
    }
}

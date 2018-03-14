package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;

import java.util.Set;

@NodeEntity
public class KSMHIImpl
        extends KSMBaseIndicatorImpl
        implements IKSMHI {

    /** связь с KSMCI*/
    @Relationship(type = "AttachedKSMHI")
    protected KSMCIImpl relatedKSMCI;


    public KSMHIImpl() {
        super();
        this.ksmIndicatorType = "KSMHI";
    }

    @Override
    public void setRelatedKSMCI(IKSMCI related_ksmci) {
        this.relatedKSMCI = (KSMCIImpl) related_ksmci;
    }
}

package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

@NodeEntity
public class KSMKPIImpl
        extends KSMBaseIndicatorImpl
        implements IKSMKPI, KSMKPI {
    protected String ksmRuleId;

    /** связь с KSMCI*/
    @Relationship(type = "AttachedKSMKPI")
    public KSMCIImpl relatedKSMCI;

    public KSMKPIImpl() {
        super();
        this.ksmIndicatorType = "KSMKPI";
    }

    @Override
    public void setKMMKPICalculationRuleId(String ksmKpiCalulationRuleId) {
        this.ksmRuleId = ksmKpiCalulationRuleId;
    }

    @Override
    public String getKsmRuleId() {
        return ksmRuleId;
    }

    @Override
    public void setRelatedKSMCI(IKSMCI related_ksmci) {
        this.relatedKSMCI = (KSMCIImpl)related_ksmci;
    }
}

package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

@NodeEntity
public class KSMKPIImpl
        extends KSMBaseIndicatorImpl
        implements KSMKPI {
    protected String ksmRuleId;

    /** связь с KSMCI*/
    @Relationship(type = "AttachedKSMKPI")
    protected AttachedKSMKPIKSMRelationShip attachedKSMKPIKSMRelationShip;

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
    public AttachedKSMKPIKSMRelationShip getAttachedKSMKPIKSMRelationShip() {
        return attachedKSMKPIKSMRelationShip;
    }

    public void setAttachedKSMKPIKSMRelationShip(AttachedKSMKPIKSMRelationShip attachedKSMKPIKSMRelationShip) {
        this.attachedKSMKPIKSMRelationShip = attachedKSMKPIKSMRelationShip;
    }
}

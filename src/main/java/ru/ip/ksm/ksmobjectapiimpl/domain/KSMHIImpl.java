package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.json.JSONObject;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;

@NodeEntity
public class KSMHIImpl
        extends KSMBaseIndicatorImpl
        implements IKSMHI ,KSMHI {

    /** связь с KSMCI*/
    @Relationship(type = "AttachedKSMHI")
    public KSMCIImpl relatedKSMCI;


    public KSMHIImpl() {
        super();
        this.ksmIndicatorType = "KSMHI";
    }

    @Override
    public void setRelatedKSMCI(IKSMCI related_ksmci) {
        this.relatedKSMCI = (KSMCIImpl) related_ksmci;
    }


    // create by build json plugin
    @Override
    public JSONObject toJson() {
        JSONObject jo = super.toJson();
        return jo;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}

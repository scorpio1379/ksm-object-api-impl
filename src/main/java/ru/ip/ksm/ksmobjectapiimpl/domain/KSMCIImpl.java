package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseObjectImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.KSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;

import java.util.Set;

@NodeEntity
public class KSMCIImpl<T extends KSMCIImpl<T>>
        extends KSMBaseObjectImpl<T>
        implements IKSMCI<T> {

    protected String ksmCIType = "REGULAR";

    /** связь с KSMKPI*/
    @Relationship(type = "AttachedKSMKPI", direction = "INCOMING")
    public Set<KSMKPIImpl> attachedKSMKPIs;
    /** связи с KSMHI*/
    @Relationship(type = "AttachedKSMHI", direction = "INCOMING")
    public Set<KSMHIImpl> attachedKSMHIs;

    /** связи с  родительскими KSMCI*/
    @Relationship(type = "Linked_KSMCI" , direction = "OUTGOING")
    public Set<KSMCI2KSMCIKSMRelationShip> parentKSMCIs;

    /** связи с  дочерними KSMCI*/
    @Relationship(type = "Linked_KSMCI" , direction = "INCOMING")
    public Set<KSMCI2KSMCIKSMRelationShip> childKSMCIs;

    public KSMCIImpl() {
        super();
        this.ksmObjectType = "KSMCI";
        this.ksmCIType = "REGULAR";
    }

    public KSMCIImpl(String ksmObjectId
            ,String ksmObjectType
            , String name
            , String description
            , String debuginfo
            ,String ksmCIType) {

        super(ksmObjectId, ksmObjectType, name,  description, debuginfo);
        this.ksmCIType = ksmCIType;
    }

    @Override
    public String getKsmCIType() {
        return ksmCIType;
    }
    public String getKsmObjectType() {
        return ksmObjectType;
    }


    public Set<KSMKPIImpl> getAllAttachedKSMKPIs() {
        throw new IllegalArgumentException("Not implemented yet");
        //return null;
    }


    public Set<KSMHIImpl> getAllAttachedKSMHIs() {
        throw new IllegalArgumentException("Not implemented yet");
        //return null;
    }

    @Override
    public void setKsmCIType(String ksmCIType) {
        this.ksmCIType = ksmCIType;
    }


    // create by build json plugin
    @Override
    public JSONObject toJson() {
        JSONObject jo = super.toJson();
        jo.put("ksmCIType" , this.ksmCIType);
        JSONArray kpis = new JSONArray();
        for (IKSMKPI kpi:attachedKSMKPIs
             ) {
            kpis.put(kpi.toJson());

        }
        jo.put("attachedKSMKPIs" ,kpis );
        JSONArray his = new JSONArray();
        for (IKSMHI hi:attachedKSMHIs
                ) {
            his.put(hi.toJson());

        }
        jo.put("attachedKSMHIs" ,his );
        return jo;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}

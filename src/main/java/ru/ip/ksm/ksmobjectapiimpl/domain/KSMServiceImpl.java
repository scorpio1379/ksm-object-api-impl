package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.json.JSONObject;
import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;

@NodeEntity
public class KSMServiceImpl<T extends KSMServiceImpl<T> >
        extends KSMCIImpl<T>
        implements IKSMService<T>{

    protected String ksmServiceType;

    public KSMServiceImpl() {
        this.ksmCIType = "KSMService";
    }

    public KSMServiceImpl(IKSMService ksmService) {
    }

    public String getKSMServiceType() {
        return ksmServiceType;
    }


    // create by build json plugin
    @Override
    public JSONObject toJson() {
        JSONObject jo = super.toJson();
        jo.put("ksmCIType" , this.ksmServiceType);
        return jo;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}

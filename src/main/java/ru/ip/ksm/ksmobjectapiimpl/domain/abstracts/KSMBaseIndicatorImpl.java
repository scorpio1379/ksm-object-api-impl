package ru.ip.ksm.ksmobjectapiimpl.domain.abstracts;

import org.json.JSONObject;
import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;

@NodeEntity
public abstract class KSMBaseIndicatorImpl<T extends KSMBaseIndicatorImpl<T>>
        extends KSMBaseObjectImpl<T>
        implements IKSMIndicator<T> {
    protected String status;
    protected String value;
    protected String ksmIndicatorType;

    public KSMBaseIndicatorImpl() {
        super();
        this.ksmObjectType = "KSMIndicator";
    }

    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public String getValue() {
        return value;
    }
    @Override
    public String getKsmIndicatorType() {
        return ksmIndicatorType;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setKsmIndicatorType(String ksmIndicatorType) {
        this.ksmIndicatorType = ksmIndicatorType;
    }


    // create by build json plugin
    @Override
    public JSONObject toJson() {
        JSONObject jo = super.toJson();
        jo.put("status" , this.status);
        jo.put("value" , this.value);
        jo.put("ksmIndicatorType" , this.ksmIndicatorType);
        return jo;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}

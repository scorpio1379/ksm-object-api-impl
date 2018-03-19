package ru.ip.ksm.ksmobjectapiimpl.domain.abstracts;

import org.json.JSONObject;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.AbstractKSMObject;
@NodeEntity
public abstract class KSMBaseObjectImpl<T extends KSMBaseObjectImpl<T>>
        implements IKSMObject<T>,AbstractKSMObject {
    @Id
    @Index(unique = true , primary = true)
    @GeneratedValue(strategy = org.neo4j.ogm.id.UuidStrategy.class)
    protected String ksmObjectId;
    protected String ksmObjectType;
    protected String name;
    protected String description;
    protected String debuginfo;


    public KSMBaseObjectImpl() {
    }

    public KSMBaseObjectImpl(String ksmObjectId, String ksmObjectType, String name, String description, String debuginfo) {
        this.ksmObjectId = ksmObjectId;
        this.ksmObjectType = ksmObjectType;
        this.name = name;
        this.description = description;
        this.debuginfo = debuginfo;
    }

    @Override
    public String getKsmObjectId() {
        return ksmObjectId;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public String getDebuginfo() {
        return debuginfo;
    }

    @Override
    public void setKsmObjectId(String ksmObjectId) {
        this.ksmObjectId = ksmObjectId;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setDebuginfo(String debuginfo) {
        this.debuginfo = debuginfo;
    }



    // create by build json plugin
    @Override
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("ksmObjectId" , this.ksmObjectId);
        jo.put("ksmObjectType" , this.ksmObjectType);
        jo.put("name" , this.name);
        jo.put("description" , this.description);
        jo.put("debuginfo" , this.debuginfo);

        return jo;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}

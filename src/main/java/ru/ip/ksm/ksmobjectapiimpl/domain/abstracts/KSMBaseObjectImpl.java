package ru.ip.ksm.ksmobjectapiimpl.domain.abstracts;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;

public abstract class KSMBaseObjectImpl {
    @Id
    @Index(unique = true , primary = true)
    @GeneratedValue(strategy = org.neo4j.ogm.id.UuidStrategy.class)
    protected String ksmObjectId;
    protected String ksmObjectType;
    protected String name;
    protected String description;
    protected String debuginfo;

    public String getKsmObjectId() {
        return ksmObjectId;
    }





    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDebuginfo() {
        return debuginfo;
    }

    public void setKsmObjectId(String ksmObjectId) {
        this.ksmObjectId = ksmObjectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDebuginfo(String debuginfo) {
        this.debuginfo = debuginfo;
    }
}

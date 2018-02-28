package ru.ip.ksm.ksmobjectapiimpl.domainhelpers;

public interface IKSMObject {
    String getKsmObjectId();

    String getName();

    String getDescription();

    String getDebuginfo();

    void setKsmObjectId(String ksmObjectId);

    void setName(String name);

    void setDescription(String description);

    void setDebuginfo(String debuginfo);


}

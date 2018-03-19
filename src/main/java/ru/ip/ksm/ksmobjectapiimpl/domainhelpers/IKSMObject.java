package ru.ip.ksm.ksmobjectapiimpl.domainhelpers;

import org.json.JSONObject;

public interface IKSMObject<T extends IKSMObject<T>> {
    String getKsmObjectId();

    String getName();

    String getDescription();

    String getDebuginfo();

    void setKsmObjectId(String ksmObjectId);

    void setName(String name);

    void setDescription(String description);

    void setDebuginfo(String debuginfo);


    // create by build json plugin
    JSONObject toJson();
}

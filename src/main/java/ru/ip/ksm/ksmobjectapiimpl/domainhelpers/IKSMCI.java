package ru.ip.ksm.ksmobjectapiimpl.domainhelpers;

public interface IKSMCI<T extends IKSMCI<T>>
        extends IKSMObject<T>
{

    String getKsmCIType();

    void setKsmCIType(String ksmCIType);

}

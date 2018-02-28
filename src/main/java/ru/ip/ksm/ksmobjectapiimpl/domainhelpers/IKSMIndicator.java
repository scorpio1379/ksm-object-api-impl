package ru.ip.ksm.ksmobjectapiimpl.domainhelpers;

public interface IKSMIndicator extends IKSMObject {

    String getStatus();
    String getValue();
    String getKsmIndicatorType();

    void setStatus( String status);
    void setValue(String value);
}

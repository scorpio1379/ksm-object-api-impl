package ru.ip.ksm.ksmobjectapiimpl.domainhelpers;

public interface IKSMIndicator<T extends IKSMIndicator<T>> extends IKSMObject<T> {

    String getStatus();
    String getValue();
    String getKsmIndicatorType();

    void setStatus( String status);
    void setValue(String value);

    void setKsmIndicatorType(String ksmkpi);

    void setRelatedKSMCI(IKSMCI related_ksmci);

}

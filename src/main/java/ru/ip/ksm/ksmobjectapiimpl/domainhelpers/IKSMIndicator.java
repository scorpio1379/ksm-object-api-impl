package ru.ip.ksm.ksmobjectapiimpl.domainhelpers;

import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

public interface IKSMIndicator extends IKSMObject {

    String getStatus();
    String getValue();
    String getKsmIndicatorType();

    void setStatus( String status);
    void setValue(String value);

    void setKsmIndicatorType(String ksmkpi);

    void setRelatedKSMCI(IKSMCI related_ksmci);
}

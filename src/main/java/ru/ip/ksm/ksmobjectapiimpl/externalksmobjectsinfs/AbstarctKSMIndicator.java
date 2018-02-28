package ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;

public interface AbstarctKSMIndicator extends IKSMIndicator {

    String getStatus();
    String getValue();
    String getKsmIndicatorType();
}

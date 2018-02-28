package ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;

public interface AbstractKSMObject extends IKSMObject {
    String getKsmObjectId();

    String getName();

    String getDescription();

    String getDebuginfo();

}

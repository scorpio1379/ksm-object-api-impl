package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

public interface KSMCIManager extends IKSMCIManager<KSMCIManager , IKSMCI> {
    KSMCI getKSMObject(String ksmObjectId);
}

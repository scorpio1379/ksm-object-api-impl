package ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;

import java.util.Set;

public interface KSMCI extends IKSMCI{
    KSMKPI addNewKSMKPI();
    KSMHI addNewKSMHI();
    Set<KSMKPI> getAllAttachedKSMKPIs();
    Set<KSMHI> getAllAttachedKSMHIs();
}

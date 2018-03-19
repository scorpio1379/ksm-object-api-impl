package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;

public interface KSMCI2KSMCIKSMRelationShipManager {
    void linkKSMCI2KSMCI(IKSMCI<? extends IKSMCI> sourceKSMCI, IKSMCI<? extends IKSMCI> targetKSMCI);
}

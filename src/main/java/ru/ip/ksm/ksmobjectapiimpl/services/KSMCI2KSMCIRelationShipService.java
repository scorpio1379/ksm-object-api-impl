package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI2KSMCI_KSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.AbstractKSMRelationShipService;

public interface KSMCI2KSMCIRelationShipService extends
        AbstractKSMRelationShipService<IKSMCI2KSMCIKSMRelationShip<IKSMCI ,IKSMCI>, IKSMCI , IKSMCI>{
}

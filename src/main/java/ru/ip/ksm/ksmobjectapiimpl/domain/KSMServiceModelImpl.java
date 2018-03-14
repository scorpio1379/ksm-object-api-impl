package ru.ip.ksm.ksmobjectapiimpl.domain;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

import java.util.Set;

public class KSMServiceModelImpl
        extends KSMServiceImpl
        implements IKSMServiceModel {
    private Set<KSMCI> ksmciSet;
    private Set<IKSMCI2KSMCIKSMRelationShip<KSMCI ,KSMCI>>  linkedCIKsmRelationShips;

}

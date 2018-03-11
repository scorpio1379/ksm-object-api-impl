package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPI2KSMCIRelationShipBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.AttachedKSMKPIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

public class KSMKPI2KSMCIRelationShipBuilderImpl implements KSMKPI2KSMCIRelationShipBuilder {
    private final KSMKPI ksmkpi;
    private final KSMCI ksmci;

    public KSMKPI2KSMCIRelationShipBuilderImpl(KSMKPI ksmkpi, KSMCI ksmci) {
        this.ksmci = ksmci;
        this.ksmkpi = ksmkpi;
    }

    @Override
    public AttachedKSMKPIKSMRelationShip build(){
        return new AttachedKSMKPIKSMRelationShip(ksmkpi,ksmci);
    }


}

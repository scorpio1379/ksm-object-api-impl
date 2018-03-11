package ru.ip.ksm.ksmobjectapiimpl.builders.factories;

import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMKPI2KSMCIRelationShipBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPI2KSMCIRelationShipBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

public class KSMRelationShipBuilderFactory {
    public static KSMKPI2KSMCIRelationShipBuilder getKSMKPI2KSMCIRelationShipBuilder(KSMKPI ksmkpi, KSMCI ksmci){
        return new KSMKPI2KSMCIRelationShipBuilderImpl(ksmkpi, ksmci);
    }
}

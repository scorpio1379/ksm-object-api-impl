package ru.ip.ksm.ksmobjectapiimpl.builders.factories;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMCI2KSMCIKSMRelationShipBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCI2KSMCIKSMRelationShipBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

public class KSMRelationShipBuilderFactory {

    public static KSMCI2KSMCIKSMRelationShipBuilder getKSMCI2KSMCIKSMRelationShipBuilder(
            KSMObjectApiServiceProvider ksm_object_api_service_provider
            , Class<? extends IKSMCI2KSMCIKSMRelationShip> IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL
            , KSMCI sourceKSMCI
            , KSMCI targetKSMCI) {
        return new KSMCI2KSMCIKSMRelationShipBuilderImpl(ksm_object_api_service_provider,IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL ,sourceKSMCI,targetKSMCI);
    }
}

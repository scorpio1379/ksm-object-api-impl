package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMRelationShipBuilderFactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCI2KSMCIKSMRelationShipBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.KSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.KSMCI2KSMCIKSMRelationShipManager;

public class KSMCI2KSMCIKSMRelationShipManagerImpl implements KSMCI2KSMCIKSMRelationShipManager {


    private final KSMObjectApiServiceProvider KSM_OBJECT_API_SERVICE_PROVIDER;
    private static final String CI2CI_KSM_RELATIONSHIP_TYPE_STRING = "Linked_KSMCI";
    private static final Class<? extends IKSMCI2KSMCIKSMRelationShip> IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL  = KSMCI2KSMCIKSMRelationShip.class;

    public KSMCI2KSMCIKSMRelationShipManagerImpl(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        KSM_OBJECT_API_SERVICE_PROVIDER = ksm_object_api_service_provider;
    }

    @Override
    public void linkKSMCI2KSMCI(KSMCI sourceKSMCI, KSMCI targetKSMCI) {
        KSMCI2KSMCIKSMRelationShipBuilder ksmci2ksmciKSMRelationShipBuilder = KSMRelationShipBuilderFactory.getKSMCI2KSMCIKSMRelationShipBuilder(this.KSM_OBJECT_API_SERVICE_PROVIDER, IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL, sourceKSMCI, targetKSMCI);
        ksmci2ksmciKSMRelationShipBuilder.build();
    }
}

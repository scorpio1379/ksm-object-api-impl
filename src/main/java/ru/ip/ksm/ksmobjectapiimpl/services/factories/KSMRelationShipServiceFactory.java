package ru.ip.ksm.ksmobjectapiimpl.services.factories;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCI2KSMCIRelationShipService;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCI2KSMCIRelationShipServiceOGMImpl;

public class KSMRelationShipServiceFactory {
    public static KSMCI2KSMCIRelationShipService getKSMCI2KSMCIKSMRelationShipService(KSMObjectApiServiceProvider ksmObjectApiServiceProvider, Class<? extends IKSMCI2KSMCIKSMRelationShip> IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL){
        return new KSMCI2KSMCIRelationShipServiceOGMImpl(ksmObjectApiServiceProvider,IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL);
    }
}

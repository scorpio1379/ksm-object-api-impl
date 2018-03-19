package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.managerfactory;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations.KSMCI2KSMCIKSMRelationShipManagerImpl;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations.KSMServiceManagerImpl;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations.KSMServiceModelManagerImpl;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceModelManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.KSMCI2KSMCIKSMRelationShipManager;

public class KSMObjectManagerFactory {
    public static IKSMServiceModelManager getKSMServiceModelManager(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        return new KSMServiceModelManagerImpl(ksm_object_api_service_provider);
    }

    public static KSMCI2KSMCIKSMRelationShipManager getKSMCI2KSMCIKSMRelationShipManager(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        return new KSMCI2KSMCIKSMRelationShipManagerImpl(ksm_object_api_service_provider);
    }

    public static IKSMServiceManager getKSMServiceManager(KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        return new KSMServiceManagerImpl(ksm_object_api_service_provider);
    }
}

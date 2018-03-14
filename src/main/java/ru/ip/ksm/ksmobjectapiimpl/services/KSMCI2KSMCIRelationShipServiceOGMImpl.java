package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMRelationShipServiceOGMImpl;

public class KSMCI2KSMCIRelationShipServiceOGMImpl
        extends BaseKSMRelationShipServiceOGMImpl<IKSMCI2KSMCIKSMRelationShip<IKSMCI,IKSMCI>,IKSMCI,IKSMCI>
       implements KSMCI2KSMCIRelationShipService {
    protected final Class<? extends IKSMCI2KSMCIKSMRelationShip> KSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL;
    //protected  Class<? extends IKSMCI2KSMCIKSMRelationShip<IKSMCI, IKSMCI>> KSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL;

    public KSMCI2KSMCIRelationShipServiceOGMImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider
            , Class<? extends IKSMCI2KSMCIKSMRelationShip> KSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL) {
        this.KSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL = KSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL;
        this.session = ksmObjectApiServiceProvider.getSession();
    }

    @Override
    protected Class getEntityType() {
        return KSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL;
    }


}

package ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.KSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;

public interface IKSMServiceModelBuilder<T extends IKSMServiceModelBuilder<T,U>,U extends IKSMServiceModel<U>>
        //extends KSMCIBuilder<KSMServiceModelBuilder<T>>
        extends IKSMCIBuilder<T,U>{

   // T addKSMCI(KSMCI ksmci);
    T addKSMCI(String ksmCiObjectId);
    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);


    T setKSMService(IKSMService ksmService);

 T setRelatedKSMCIs(Iterable<? extends IKSMCI> relatedKSMCIs);

 T setRelationShips(Iterable<? extends KSMCI2KSMCIKSMRelationShip> relationShips);
 U build();
}

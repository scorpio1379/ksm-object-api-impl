package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.abstracts.AbstractKSMObjectManager;

public interface IKSMCIManager<T extends IKSMCIManager<T,U> , U extends IKSMCI>  extends AbstractKSMObjectManager<T,U>{
    U getKSMObject(String ksmObjectId);
}

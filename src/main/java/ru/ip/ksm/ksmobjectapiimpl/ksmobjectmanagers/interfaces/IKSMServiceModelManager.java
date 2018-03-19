package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;

public interface IKSMServiceModelManager<T extends IKSMServiceModelManager<T,U> ,  U extends IKSMServiceModel<U>>
        extends IKSMServiceManager<T,U> {
    U getKSMObject(String ksmObjectId);

    IKSMServiceModelBuilder getKSMServiceModelBuilder();
}

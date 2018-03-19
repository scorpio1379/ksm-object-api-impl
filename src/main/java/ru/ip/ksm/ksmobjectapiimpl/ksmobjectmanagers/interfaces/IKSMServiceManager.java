package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.types.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;

import java.util.Set;

public interface IKSMServiceManager<T extends IKSMServiceManager<T,U> , U extends IKSMService<U>>
        extends IKSMCIManager<T,U> {
    U getKSMObject(String ksmObjectId);

    IKSMServiceBuilder<KSMServiceBuilder,KSMService> getKSMServiceBuilder();

    Set<U> getAllKSMObjectOfThatType();
}

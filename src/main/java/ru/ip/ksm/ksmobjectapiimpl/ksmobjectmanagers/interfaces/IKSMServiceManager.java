package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;

public interface IKSMServiceManager<T extends IKSMServiceManager<T,U> , U extends IKSMService>
        extends IKSMCIManager<T,U> {
}

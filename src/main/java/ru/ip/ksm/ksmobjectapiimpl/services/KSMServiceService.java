package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMServiceService;

public interface KSMServiceService<T extends IKSMService>
        extends IKSMServiceService<T> {
}

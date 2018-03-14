package ru.ip.ksm.ksmobjectapiimpl.services.helpers;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;

public interface IKSMCIService<T extends IKSMCI>
        extends IKSMObjectService {
    T doSmthWithCI(T ksmci);
}

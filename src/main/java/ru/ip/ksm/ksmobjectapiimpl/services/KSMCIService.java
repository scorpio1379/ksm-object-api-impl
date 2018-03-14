package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMCIService;

public interface KSMCIService<T extends IKSMCI> extends IKSMCIService<T>{
    T doSmthWithCI(T ksmci);


}

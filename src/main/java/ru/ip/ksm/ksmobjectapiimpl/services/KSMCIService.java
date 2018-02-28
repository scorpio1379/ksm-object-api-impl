package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMCIService;

public interface KSMCIService<T extends KSMCI> extends IKSMCIService<T>{
    T doSmthgWithCI(T ci);


}

package ru.ip.ksm.ksmobjectapiimpl.services.helpers;

import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.AbstractKSMObjectService;

public interface IKSMCIService<T extends KSMCIImpl>
        extends AbstractKSMObjectService<T> {
    void doSmthWithCI(T ksmci);
}

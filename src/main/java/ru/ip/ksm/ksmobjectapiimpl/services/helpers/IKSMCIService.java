package ru.ip.ksm.ksmobjectapiimpl.services.helpers;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.AbstractKSMObjectService;

public interface IKSMCIService<KSMOBJ extends IKSMCI>
        extends AbstractKSMObjectService<KSMOBJ> {
    KSMOBJ doSmthWithCI(KSMOBJ ksmci);

}

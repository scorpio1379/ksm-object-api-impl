package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMIndicator;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.AbstractKSMObject;

public interface AbstractKSMIndicatorService<KSMOBJ extends IKSMIndicator> //<KSMOBJ extends IKSMObject>
        extends AbstractKSMObjectService<KSMOBJ> {

    KSMOBJ doSomeThingWithIndicator(KSMOBJ indicator);
}

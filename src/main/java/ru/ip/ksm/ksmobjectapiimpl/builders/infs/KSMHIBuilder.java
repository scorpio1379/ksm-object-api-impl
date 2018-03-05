package ru.ip.ksm.ksmobjectapiimpl.builders.infs;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;


public interface KSMHIBuilder<T extends AbstractKSMIndicatorBuilder<T>>
        extends AbstractKSMIndicatorBuilder<T> {
    KSMHI build();
}

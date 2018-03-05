package ru.ip.ksm.ksmobjectapiimpl.builders.infs;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;


public interface KSMKPIBuilder<T extends AbstractKSMIndicatorBuilder<T>>
        extends AbstractKSMIndicatorBuilder<T> {
    KSMKPI build();
}

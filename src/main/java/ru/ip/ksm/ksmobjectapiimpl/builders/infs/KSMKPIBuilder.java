package ru.ip.ksm.ksmobjectapiimpl.builders.infs;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;


public interface KSMKPIBuilder<T extends KSMKPIBuilder<T>>
        extends AbstractKSMIndicatorBuilder<T> {
    T setRuleId(String ksmKpiCalulationRuleId);
    T setStatus(String status);
    T setValue(String value);

    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);

    KSMKPI build() throws IllegalAccessException, InstantiationException;
}

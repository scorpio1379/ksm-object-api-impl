package ru.ip.ksm.ksmobjectapiimpl.builders.infs;

import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;


public interface KSMKPIBuilder<T extends KSMKPIBuilder<T,U> , U extends IKSMKPI<U>>
        extends AbstractKSMIndicatorBuilder<T,U> {
    T setRuleId(String ksmKpiCalulationRuleId);
    T setStatus(String status);
    T setValue(String value);

    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);

    U build() throws IllegalAccessException, InstantiationException;
}

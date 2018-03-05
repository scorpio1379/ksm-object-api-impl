package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMIndicatorBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;

public class KSMKPIBuilderImpl <T extends AbstractKSMIndicatorBuilder<T>>
        extends BaseKSMIndicatorBuilderImpl<T>
        implements KSMKPIBuilder<T>{
    public KSMKPIBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
    }

    @Override
    public KSMKPI build() {
        return null;
    }
}

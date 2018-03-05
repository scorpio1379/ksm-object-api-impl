package ru.ip.ksm.ksmobjectapiimpl.builders.impls;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMIndicatorBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMHIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMIndicatorBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;

public class KSMHIBuilderImpl<T extends AbstractKSMIndicatorBuilder<T>>
        extends BaseKSMIndicatorBuilderImpl<T>
        implements KSMHIBuilder<T> {
    public KSMHIBuilderImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
    }

    @Override
    public KSMHI build() {
        return null;
    }
}

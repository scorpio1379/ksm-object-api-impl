package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.domain.KSMKPIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMIndicatorService;

public class KSMKPIServiceImpl
        extends BaseKSMIndicatorService<KSMKPIImpl, KSMBaseIndicatorImpl>
        implements KSMKPIService {
    @Override
    protected Class<KSMKPIImpl> getEntityType() {
        return KSMKPIImpl.class;
    }
}

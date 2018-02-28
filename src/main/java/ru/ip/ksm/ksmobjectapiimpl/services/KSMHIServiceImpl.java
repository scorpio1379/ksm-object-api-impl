package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.domain.KSMHIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseIndicatorImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMIndicatorService;

public class KSMHIServiceImpl
        extends BaseKSMIndicatorService<KSMHIImpl, KSMBaseIndicatorImpl>
        implements KSMHIService {
    @Override
    protected Class<KSMHIImpl> getEntityType() {
        return KSMHIImpl.class;
    }
}

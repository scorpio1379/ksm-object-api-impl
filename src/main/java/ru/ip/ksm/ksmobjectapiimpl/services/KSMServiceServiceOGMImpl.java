package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMObjectServiceOGMImpl;

public class KSMServiceServiceOGMImpl
        extends BaseKSMObjectServiceOGMImpl<KSMServiceImpl>
/* через этот класс имплементируется не верный интерфейс  KSMCIService а нужен ksmciservice<ksmservice>*/

        implements KSMServiceService
{

    public KSMServiceServiceOGMImpl() {

    }

    @Override
    public void doSmthWithCI(KSMServiceImpl ksmci) {

    }

    @Override
    protected Class<KSMServiceImpl> getEntityType() {
        return KSMServiceImpl.class;
    }
}

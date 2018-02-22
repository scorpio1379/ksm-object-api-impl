package ru.ip.ksm.ksmobjectapiimpl.services;


import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.BaseKSMObjectServiceOGMImpl;

public class KSMCIServiceOGMImpl
        extends BaseKSMObjectServiceOGMImpl<KSMCIImpl>
implements KSMCIService
{
    public KSMCIServiceOGMImpl() {

    }




    @Override
    protected Class getEntityType() {
        return KSMCIImpl.class;
    }


}

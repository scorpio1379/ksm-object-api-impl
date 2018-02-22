package ru.ip.ksm.ksmobjectapiimpl.services;

import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;

public class KSMServiceServiceOGMImpl< U extends KSMCIImpl , T extends U>
        extends KSMCIServiceOGMImpl<KSMCIImpl, KSMServiceImpl>
/* через этот класс имплементируется не верный интерфейс  KSMCIService а нужен ksmciservice<ksmservice>*/

        implements KSMCIService<>
{
    public KSMServiceServiceOGMImpl() {

    }

}

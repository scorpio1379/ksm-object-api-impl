package ru.ip.ksm.ksmobjectapiimpl.services.factories;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCIServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMKPIServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.AbstractKSMObjectService;

public class KSMObjectServiceFactory {
    public static KSMCIServiceOGMImpl<KSMCI> getKSMCIService(Class<? extends KSMCI> ci_class_impl, KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        return new KSMCIServiceOGMImpl<KSMCI>(ci_class_impl,ksmObjectApiServiceProvider);
    }

    public static KSMKPIServiceOGMImpl<KSMKPI> getKSMKPIService(Class<? extends KSMKPI> ksmkpi_class_impl
            , KSMCI related_ksmci
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        return  new KSMKPIServiceOGMImpl<>(ksmkpi_class_impl,related_ksmci,ksmObjectApiServiceProvider) ;

    }

}

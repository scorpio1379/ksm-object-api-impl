package ru.ip.ksm.ksmobjectapiimpl.services.factories;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.services.*;
import ru.ip.ksm.ksmobjectapiimpl.services.abstracts.AbstractKSMObjectService;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMCIService;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMServiceService;

public class KSMObjectServiceFactory {
//    public static KSMCIServiceOGMImpl<IKSMCI> getKSMCIService(Class<? extends IKSMCI> ci_class_impl, KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
////        return new KSMCIServiceOGMImpl<IKSMCI>(ci_class_impl,ksmObjectApiServiceProvider);
////    }
    public static IKSMCIService getKSMCIService(Class<? extends IKSMCI> ci_class_impl, KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {

         return new KSMCIServiceOGMImpl<KSMCI>(ci_class_impl, ksmObjectApiServiceProvider);
    }

    public static KSMKPIServiceOGMImpl<IKSMKPI> getKSMKPIService(Class<? extends IKSMKPI> ksmkpi_class_impl
            , KSMCI related_ksmci
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        KSMKPIServiceOGMImpl<IKSMKPI> o = new KSMKPIServiceOGMImpl<>(ksmkpi_class_impl, related_ksmci, ksmObjectApiServiceProvider);
        return  new KSMKPIServiceOGMImpl<>(ksmkpi_class_impl,related_ksmci,ksmObjectApiServiceProvider) ;

    }

    public static KSMHIServiceOGMImpl<IKSMHI> getKSMHIService(Class<? extends IKSMHI> ksmhi_class_impl
            , KSMCI related_ksmci
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        return  new KSMHIServiceOGMImpl<>(ksmhi_class_impl,related_ksmci,ksmObjectApiServiceProvider);
    }

    public static IKSMServiceService<IKSMService> getKSMServiceService (Class<? extends IKSMService> ksmservice_class_impl
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider){
        return new KSMServiceServiceOGMImpl<>(ksmObjectApiServiceProvider ,ksmservice_class_impl);

    }
}

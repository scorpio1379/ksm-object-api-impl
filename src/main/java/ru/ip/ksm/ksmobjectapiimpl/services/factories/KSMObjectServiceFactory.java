package ru.ip.ksm.ksmobjectapiimpl.services.factories;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMHI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCIServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMHIServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMKPIServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMServiceServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMCIService;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMServiceService;

public class KSMObjectServiceFactory {
//    public static KSMCIServiceOGMImpl<IKSMCI> getKSMCIService(Class<? extends IKSMCI> ci_class_impl, KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
////        return new KSMCIServiceOGMImpl<IKSMCI>(ci_class_impl,ksmObjectApiServiceProvider);
////    }
    public static IKSMCIService<IKSMCI> getKSMCIService(Class<? extends IKSMCI> ci_class_impl, KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {

         return new KSMCIServiceOGMImpl<>(ci_class_impl, ksmObjectApiServiceProvider);
    }

    public static KSMKPIServiceOGMImpl getKSMKPIService(Class<? extends IKSMKPI> ksmkpi_class_impl
            , IKSMCI related_ksmci
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        return  new KSMKPIServiceOGMImpl<>(ksmkpi_class_impl,related_ksmci,ksmObjectApiServiceProvider) ;

    }

    public static KSMHIServiceOGMImpl getKSMHIService(Class<? extends IKSMHI> ksmhi_class_impl
            , IKSMCI related_ksmci
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        return  new KSMHIServiceOGMImpl<>(ksmhi_class_impl,related_ksmci,ksmObjectApiServiceProvider);
    }

    public static IKSMServiceService<IKSMService> getKSMServiceService (Class<? extends IKSMService> ksmservice_class_impl
            , KSMObjectApiServiceProvider ksmObjectApiServiceProvider){
        return new KSMServiceServiceOGMImpl<>(ksmObjectApiServiceProvider ,ksmservice_class_impl);

    }
}

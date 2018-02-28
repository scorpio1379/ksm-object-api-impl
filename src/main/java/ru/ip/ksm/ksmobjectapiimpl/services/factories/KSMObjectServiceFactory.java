package ru.ip.ksm.ksmobjectapiimpl.services.factories;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCIServiceOGMImpl;

public class KSMObjectServiceFactory {
    public static KSMCIServiceOGMImpl<KSMCI> getKSMCIService(Class<? extends KSMCI> ci_class_impl, KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        return new KSMCIServiceOGMImpl<KSMCI>(ci_class_impl,ksmObjectApiServiceProvider);
    }
}

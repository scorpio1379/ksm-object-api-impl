package ru.ip.ksm.ksmobjectapiimpl.ksmservices;

import ru.ip.ksm.ksmobjectapi.builders.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapi.ksmservices.KSMTopologyService;
import ru.ip.ksm.ksmobjectapi.objects.KSMCI;
import ru.ip.ksm.ksmobjectapi.objects.KSMHI;
import ru.ip.ksm.ksmobjectapi.objects.KSMKPI;
import ru.ip.ksm.ksmobjectapi.objects.KSMService;
import ru.ip.ksm.ksmobjectapi.objects.abstracts.KSMIndicator;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;

import java.util.Set;

public class KSMToplogyServiceImpl  implements KSMTopologyService {

    private final KSMObjectApiServiceProvider KSM_OBJECT_API_SERVICE_PROVIDER;

    public KSMToplogyServiceImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        KSM_OBJECT_API_SERVICE_PROVIDER = ksmObjectApiServiceProvider;
    }

    @Override
    public Set<KSMCI> getAllKSMCIs() {
        return null;
    }

    @Override
    public Set<KSMIndicator> getAllIndicators() {
        return null;
    }

    @Override
    public Set<KSMHI> getAllKSMHIs() {
        return null;
    }

    @Override
    public Set<KSMKPI> getAllKPIs() {
        return null;
    }

    @Override
    public Set<KSMService> getAllKSMServices() {
        return null;
    }

    @Override
    public KSMCIBuilder createNewCI() {
        return null;
    }
}

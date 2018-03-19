package ru.ip.ksm.ksmobjectapiimpl.api;


import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMHIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.types.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.types.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.ksmservices.KSMToplogyServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.ksmservices.KSMTopologyService;

import java.util.Set;

public class KSMApiImpl implements KSMApi {
    private final KSMObjectApiServiceProvider ksmObjectApiServiceProvider;


    public KSMApiImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        this.ksmObjectApiServiceProvider = ksmObjectApiServiceProvider;
    }

    public KSMTopologyService getKSMTopologyService(){
        return new KSMToplogyServiceImpl(this.ksmObjectApiServiceProvider);
    }





    public Set<KSMService> getAllKSMServices() {
        this.ksmObjectApiServiceProvider.getSession();
        return null;
    }

    public KSMService getKSMServiceByKSMObjId(String s) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMCI getKSMCIByKSMObjId(String s) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMKPI getKSMKPIByKSMObjId(String s) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMHI getKSMHIByKSMObjId(String s) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public String deleteKSMObjectByKsmID(String s) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public void linkCIToCI(String s, String s1, String s2) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMCIBuilder getCIBuilder() {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMCIBuilder getCIBuilder(String s) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMKPIBuilder getKPIBuilder(KSMCI ksmci) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMKPIBuilder getKPIBuilder(String s) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMHIBuilder getHIBuilder(KSMCI ksmci) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    public KSMServiceBuilder getServiceBuilder() {
        throw new IllegalArgumentException("Not implemented yet");
    }

    @Override
    public String getHost() {
        return this.ksmObjectApiServiceProvider.getHost();
    }

    @Override
    public int getPort() {
        return this.ksmObjectApiServiceProvider.getPort();
    }

    @Override
    public String getProtocol() {
        return this.ksmObjectApiServiceProvider.getProtocol();
    }


}

package ru.ip.ksm.ksmobjectapiimpl.api;


import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMHIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMHI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMKPI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.ksmservices.KSMTopologyService;

import java.util.Set;

public interface KSMApi {
    Set<KSMService> getAllKSMServices();
    /* ---- общие геттеры, поидее должны быть реализованы одной функцией getKSMObjByKSMId с последующим приведением типа*/
    KSMService getKSMServiceByKSMObjId(String ksmObjId);
    KSMCI getKSMCIByKSMObjId(String ksmObjId);
    KSMKPI getKSMKPIByKSMObjId(String ksmObjId);
    KSMHI getKSMHIByKSMObjId(String ksmObjId);
    /*------ Общие сеттеры, отдельная реализация в каждом сервисе*/

    /* общая функция*/
    String deleteKSMObjectByKsmID(String ksmObjId);
    /* пока существует единственный тип связи */
    void linkCIToCI(String startCIiD, String endCiId, String CI2CIRelationShipType);

    KSMCIBuilder getCIBuilder();
    KSMCIBuilder getCIBuilder(String ciKsmObjId);

    KSMKPIBuilder getKPIBuilder(KSMCI ci) ;
    KSMKPIBuilder getKPIBuilder(String kpiKsmObjId);

    KSMHIBuilder getHIBuilder(KSMCI ci);

    KSMServiceBuilder getServiceBuilder();


    String getHost();
    int getPort();
    String getProtocol();

    KSMTopologyService getKSMTopologyService();
}

package ru.ip.ksm.ksmobjectapiimpl.ksmservices;


import ru.ip.ksm.ksmobjectapiimpl.builders.infs.*;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.*;

import java.util.Set;

public interface KSMTopologyService {
    Set<IKSMCI> getAllKSMCIs();
    Set<AbstarctKSMIndicator> getAllIndicators(KSMCI ksmci);
    Set<KSMHI> getAllKSMHIs(KSMCI ksmci);
    Set<KSMKPI> getAllKPIs(KSMCI ksmci);
    Set<KSMService> getAllKSMServices();

    KSMCIBuilder createNewCI();

    KSMServiceModelBuilder createNewKSMServiceModel();

    KSMServiceModel getKSMServiceModel(String ksmObjectId);

    KSMServiceBuilder createNewKSMService();

    KSMService getKSMService(String ksmObjectId);

    KSMKPIBuilder addNewKSMKPIToKSMCI(KSMCI ksmci) ;

    KSMHIBuilder addNewKSMHIToKSMCI(KSMCI ksmci) ;

    void linkKSMCI2KSMCI (KSMCI sourceKSMCI, KSMCI targetKSMCI);


}

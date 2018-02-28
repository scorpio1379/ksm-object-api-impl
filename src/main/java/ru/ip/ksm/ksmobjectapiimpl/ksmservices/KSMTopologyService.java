package ru.ip.ksm.ksmobjectapiimpl.ksmservices;


import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.*;

import java.util.Set;

public interface KSMTopologyService {
    Set<KSMCI> getAllKSMCIs();
    Set<AbstarctKSMIndicator> getAllIndicators();
    Set<KSMHI> getAllKSMHIs();
    Set<KSMKPI> getAllKPIs();
    Set<KSMService> getAllKSMServices();

    KSMCIBuilder createNewCI();

    KSMServiceModelBuilder createNewKSMServiceModel();

    KSMService getKSMService(String ksmObjectId);


}

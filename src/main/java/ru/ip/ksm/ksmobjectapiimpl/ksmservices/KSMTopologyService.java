package ru.ip.ksm.ksmobjectapiimpl.ksmservices;


import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMHIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMKPIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.*;

import java.util.Set;

public interface KSMTopologyService {
    Set<IKSMCI> getAllKSMCIs();
    Set<AbstarctKSMIndicator> getAllIndicators(KSMCI ksmci);
    Set<KSMHI> getAllKSMHIs(KSMCI ksmci);
    Set<KSMKPI> getAllKPIs(KSMCI ksmci);
    Set<KSMService> getAllKSMServices();

    IKSMCIBuilder createNewCI();

    IKSMServiceModelBuilder createNewKSMServiceModel();

    IKSMServiceModel getKSMServiceModel(String ksmObjectId);

    IKSMServiceBuilder createNewKSMService();

    KSMService getKSMService(String ksmObjectId);

    KSMKPIBuilder addNewKSMKPIToKSMCI(IKSMCI<? extends IKSMCI> ksmci) ;

    KSMHIBuilder addNewKSMHIToKSMCI(IKSMCI<? extends IKSMCI> ksmci) ;

    void linkKSMCI2KSMCI (IKSMCI<? extends IKSMCI> sourceKSMCI, IKSMCI<? extends IKSMCI> targetKSMCI);


}

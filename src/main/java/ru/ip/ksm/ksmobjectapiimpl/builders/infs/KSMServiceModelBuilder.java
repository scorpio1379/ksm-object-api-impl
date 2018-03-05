package ru.ip.ksm.ksmobjectapiimpl.builders.infs;

import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

public interface KSMServiceModelBuilder<T extends KSMServiceModelBuilder<T>>
        //extends KSMCIBuilder<KSMServiceModelBuilder<T>>
        extends KSMCIBuilder<T>{

   // T addKSMCI(KSMCI ksmci);
    T addKSMCI(String ksmCiObjectId);
    T setName(String name);
    T setDescription(String name);
    T setKsmObjectId(String ksmObjectId);



}

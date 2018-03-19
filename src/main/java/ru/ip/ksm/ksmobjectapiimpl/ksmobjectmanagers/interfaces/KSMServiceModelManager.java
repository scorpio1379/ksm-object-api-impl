package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMServiceModel;

public interface KSMServiceModelManager extends IKSMServiceModelManager<KSMServiceModelManager , KSMServiceModel> {
    KSMServiceModel getKSMObject(String ksmObjectId);
}

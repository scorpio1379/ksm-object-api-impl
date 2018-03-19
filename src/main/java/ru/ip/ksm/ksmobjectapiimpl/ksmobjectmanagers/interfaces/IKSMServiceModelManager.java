package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

public interface IKSMServiceModelManager<T extends IKSMServiceModelManager<T,U> ,  U extends IKSMService>
        extends IKSMServiceManager<T,U> {
    U getKSMObject(String ksmObjectId);

    KSMServiceModelBuilder getKSMServiceModelBuilder();
}

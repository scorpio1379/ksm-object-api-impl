package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMServiceService;

public class KSMServiceBuilderImpl<T extends KSMServiceBuilderImpl<T,U> , U extends IKSMService<U>>
        extends KSMCIBuilderImpl<T,U>
        implements IKSMServiceBuilder<T,U> {

    protected final Class<? extends IKSMService> CI_SERVICE_IMPL;

    public KSMServiceBuilderImpl(Class<? extends IKSMService> ksmServiceClassImpl, KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        super((Class<IKSMCI>) ksmServiceClassImpl.getSuperclass() ,ksm_object_api_service_provider );
        this.CI_SERVICE_IMPL = ksmServiceClassImpl;

    }

    @Override
    public U build() {
        IKSMServiceService<IKSMService> ksmServiceService = KSMObjectServiceFactory.getKSMServiceService(CI_SERVICE_IMPL, this.ksmObjectApiServiceProvider);
        IKSMService ksmServiceInstance = null;
        try{
            if (isValidKsmObjectId(this.ksmObjId)){
                IKSMService oldKsmSrvc = ksmServiceService.find(this.ksmObjId.toUpperCase().toLowerCase());

                if (oldKsmSrvc!=null){
                    ksmServiceInstance = updateKSMService(oldKsmSrvc);

                }else{
                    ksmServiceInstance = createNewKSMService();
                }

            }else{
                ksmServiceInstance = createNewKSMService();
            }
            /** todo: убрать эту ХРЕНЬ!!!!!!!*/
            ksmServiceInstance = ksmServiceService.createOrUpdate(ksmServiceInstance);
            return (U) ksmServiceInstance;
        }catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            IllegalArgumentException exc = new IllegalArgumentException("something goes wrong");
            exc.setStackTrace(e.getStackTrace());
            throw exc;
        }
    }

    private IKSMService createNewKSMService() throws IllegalAccessException, InstantiationException{
        IKSMService newKsmServiceInstance = this.CI_SERVICE_IMPL.newInstance();
        if(isValidKsmObjectId(this.ksmObjId)){
            newKsmServiceInstance.setKsmObjectId(this.ksmObjId);
        }
        if (stringFieldNotNullOrEmpty(this.ksmCIType)){
            newKsmServiceInstance.setKsmCIType(this.ksmCIType);
        }
        if (stringFieldNotNullOrEmpty(this.ksmObjName)){
            newKsmServiceInstance.setName(this.ksmObjName);
        }else{
            throw new IllegalArgumentException("CI MUST HAVE A NAME");
        }
        if (stringFieldNotNullOrEmpty(this.ksmObjDescription)){
            newKsmServiceInstance.setDescription(this.ksmObjDescription);
        }
        newKsmServiceInstance.setKsmCIType("KSMService");
        return newKsmServiceInstance;
    }

    private IKSMService updateKSMService(IKSMService oldKsmSrvc) {
        if (stringFieldNotNullOrEmpty(this.ksmObjName)){
            oldKsmSrvc.setName(this.ksmObjName);
        }
        if (stringFieldNotNullOrEmpty(this.ksmObjDescription)){
            oldKsmSrvc.setDescription(this.ksmObjDescription);
        }
        if (stringFieldNotNullOrEmpty(this.ksmCIType)){
            oldKsmSrvc.setKsmCIType(this.ksmCIType);
        }
        return oldKsmSrvc;
    }
}

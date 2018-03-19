package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMServiceService;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMServiceServiceOGMImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class KSMServiceModelBuilderImpl<T extends  KSMServiceModelBuilder<T> , U extends KSMService>
        //extends KSMCIBuilderImpl<KSMServiceModelBuilder<T>>
        extends KSMCIBuilderImpl<T>
        implements KSMServiceModelBuilder<T> {


    private final Class<? extends IKSMService> CI_SERVICE_IMPL ;
    //private final KSMCIBuilder ksmciBuilder;

    protected Set<KSMCI> relatedKSMCIs = new HashSet<>();
    protected Set<Object> relationShips = new HashSet<>();

    public KSMServiceModelBuilderImpl(Class<? extends KSMService> ksmserviceClassImpl
            , KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        /*TODO:преобразование типов с неочевидным допущением!!!!*/
        super((Class<IKSMCI>) ksmserviceClassImpl.getSuperclass() ,ksm_object_api_service_provider );
        this.CI_SERVICE_IMPL = ksmserviceClassImpl;
        this.ksmCIType = "KSMService";

    }


    public T addKSMCI(KSMCI ksmci) {
        this.relatedKSMCIs.add(ksmci);
        return (T) this;
    }

    @Override
    public T addKSMCI(String ksmCiObjectId) {
        throw new IllegalArgumentException("not implemented");
    }

    @Override
    public KSMCI build(){
//        KSMServiceService ksmServiceService = (KSMServiceService) KSMObjectServiceFactory.getKSMServiceService(this.CI_SERVICE_IMPL, this.ksmObjectApiServiceProvider);
//        IKSMService newKSMService;
//        try{
//            if (isValidKsmObjectId(this.ksmObjId)){
//                IKSMService oldKSMService = ksmServiceService.find(this.ksmObjId);
//                if (oldKSMService!=null){
//                    newKSMService = (IKSMService) updateKSMCI(oldKSMService);
//
//                }else{
//                    newKSMService = (IKSMService) createNewKSMCI();
//                }
//            }else{
//                newKSMService = (IKSMService) createNewKSMCI();
//            }
//
//            newKSMService = ksmServiceService.createOrUpdate(newKSMService);
//        IKSMCI ci = super.build();
//            return (KSMCI) newKSMService;
//        }catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//            IllegalArgumentException exc = new IllegalArgumentException("something goes wrong");
//            exc.setStackTrace(e.getStackTrace());
//            throw exc;
//        }
        return super.build();

    }

    private void setKSMCITypeAsKSMService(){
        this.ksmCIType = "KSMService";
    }


}

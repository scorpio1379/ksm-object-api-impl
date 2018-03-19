package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMObjectBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.services.helpers.IKSMCIService;

public class KSMCIBuilderImpl<T extends KSMCIBuilderImpl<T,U> , U extends IKSMCI<U>>
        //extends BaseKSMObjectBuilderImpl<KSMCIBuilder<T>>
        extends BaseKSMObjectBuilderImpl<T,U>
        implements IKSMCIBuilder<T,U>
{

    private final Class<? extends IKSMCI> CI_CLASS_IMPL ;
    protected String ksmCIType = "REGULAR";



    public KSMCIBuilderImpl(Class<? extends IKSMCI> ksmciClassImpl, KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        super(ksm_object_api_service_provider);
        this.CI_CLASS_IMPL = ksmciClassImpl;

    }


    @Override
    public U build() {
        IKSMCIService<IKSMCI> ksmCIService = KSMObjectServiceFactory.getKSMCIService(CI_CLASS_IMPL, ksmObjectApiServiceProvider);
        IKSMCI newKSMCI = null;


        /*TODO: придумать как создавать экземпляры классов с наследованием */
        /*TODO: (если есть id) сделать так что бы обьект забирался по id и потом уже модифицировался, а если id нет то создавалмся по правилу билдера*/
        try {
            if (isValidKsmObjectId(this.ksmObjId)){
                IKSMCI oldCi = ksmCIService.find(this.ksmObjId.toUpperCase().toLowerCase());

                if (oldCi!=null){
                    newKSMCI = updateKSMCI(oldCi);

                }else{
                    newKSMCI = createNewKSMCI();
                }

            }else{
                newKSMCI = createNewKSMCI();
            }
            /** todo: убрать эту ХРЕНЬ!!!!!!!*/
            newKSMCI = ksmCIService.createOrUpdate(newKSMCI);
            return (U) newKSMCI;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            IllegalArgumentException exc = new IllegalArgumentException("something goes wrong");
            exc.setStackTrace(e.getStackTrace());
            throw exc;
        }
    }


    protected IKSMCI updateKSMCI(IKSMCI ksmci) {
        if (stringFieldNotNullOrEmpty(this.ksmObjName)){
            ksmci.setName(this.ksmObjName);
        }
        if (stringFieldNotNullOrEmpty(this.ksmObjDescription)){
            ksmci.setDescription(this.ksmObjDescription);
        }
        if (stringFieldNotNullOrEmpty(this.ksmCIType)){
            ksmci.setKsmCIType(this.ksmCIType);
        }
        return ksmci;
    }


    protected IKSMCI createNewKSMCI() throws IllegalAccessException, InstantiationException {
        IKSMCI newKSMCI = CI_CLASS_IMPL.newInstance();
        if(isValidKsmObjectId(this.ksmObjId)){
            newKSMCI.setKsmObjectId(this.ksmObjId);
        }
        if (stringFieldNotNullOrEmpty(this.ksmCIType)){
            newKSMCI.setKsmCIType(this.ksmCIType);
        }
        if (stringFieldNotNullOrEmpty(this.ksmObjName)){
            newKSMCI.setName(this.ksmObjName);
        }else{
            throw new IllegalArgumentException("CI MUST HAVE A NAME");
        }
        if (stringFieldNotNullOrEmpty(this.ksmObjDescription)){
            newKSMCI.setDescription(this.ksmObjDescription);
        }
        return newKSMCI;
    }


    @Override
    public T goSmthgwithCIBuilder(T t) {
        return null;
    }


}

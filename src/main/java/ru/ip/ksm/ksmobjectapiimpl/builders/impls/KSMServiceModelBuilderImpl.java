package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.KSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class KSMServiceModelBuilderImpl<T extends  KSMServiceModelBuilderImpl<T,U> , U extends IKSMServiceModel<U>>
        //extends KSMCIBuilderImpl<KSMServiceModelBuilder<T>>
        extends KSMServiceBuilderImpl<T,U>
        implements IKSMServiceModelBuilder<T,U> {


    private final Class<? extends IKSMServiceModel> ksmServiceModelClassImpl;
    //private final KSMCIBuilder ksmciBuilder;
    protected Set<KSMCI> ksmciSet;
    protected Set<IKSMCI2KSMCIKSMRelationShip<IKSMCI ,IKSMCI>>  linkedCIKsmRelationShips;
    private IKSMService ksmService;
    private Iterable<? extends IKSMCI> relatedKSMCIs;
    private Iterable<? extends KSMCI2KSMCIKSMRelationShip> relationShips;


    public KSMServiceModelBuilderImpl(Class<? extends IKSMServiceModel> ksmServiceModelClassImpl
            , KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        /*TODO:преобразование типов с неочевидным допущением!!!!*/
        super((Class<IKSMService>) ksmServiceModelClassImpl.getSuperclass() ,ksm_object_api_service_provider );
        this.ksmServiceModelClassImpl = ksmServiceModelClassImpl;

    }


    public T addKSMCI(KSMCI ksmci) {
        return (T) this;
    }

    @Override
    public T addKSMCI(String ksmCiObjectId) {
        throw new IllegalArgumentException("not implemented");
    }

    @Override
    public T setKSMService(IKSMService ksmService) {
         this.ksmService = ksmService;
         return (T) this;
    }

    @Override
    public T setRelatedKSMCIs(Iterable<? extends IKSMCI> relatedKSMCIs) {
        this.relatedKSMCIs = relatedKSMCIs;
        return (T) this;
    }

    @Override
    public T setRelationShips(Iterable<? extends KSMCI2KSMCIKSMRelationShip> relationShips) {
        this.relationShips = relationShips;
        return (T) this;
    }

    @Override
    public U build(){
        try {
            Constructor<?>[] cons = this.ksmServiceModelClassImpl.getConstructors();
            Constructor<?> a = cons[1];
            Object b = a.newInstance(this.ksmService, this.relatedKSMCIs, this.relationShips);
            System.out.println();
            return (U) b;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

    }

    private void setKSMCITypeAsKSMService(){
        this.ksmCIType = "KSMService";
    }


}

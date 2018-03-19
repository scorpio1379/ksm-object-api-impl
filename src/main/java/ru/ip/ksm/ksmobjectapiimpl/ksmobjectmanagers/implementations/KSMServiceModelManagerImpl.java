package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.interfaces.IKSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceModelImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.KSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceModelManager;

import java.util.Collections;
import java.util.Set;


public class KSMServiceModelManagerImpl<T extends KSMServiceModelManagerImpl<T , U> , U extends IKSMServiceModel<U>>
        extends KSMServiceManagerImpl<T,U>
        implements IKSMServiceModelManager<T,U>//KSMServiceModelManager // эеквивалентно implements IKSMServiceModelManager<KSMServiceModelManager,KSMServiceModel>

{
    private static final Class<? extends IKSMServiceModel> KSM_SERVISE_MODEL_CLASS_IMPL = KSMServiceModelImpl.class;
    private static final Class<? extends KSMCI2KSMCIKSMRelationShip> KSMCI2KSMCI_KSMRelationShip_CLASS_IMPL = KSMCI2KSMCIKSMRelationShip.class;

    protected Set<IKSMCI> relatedKSMCIs;
    protected Set<KSMCI2KSMCIKSMRelationShip> ksmServiceModelRelationShips;


    public KSMServiceModelManagerImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
    }

    @Override
    public U getKSMObject(String ksmObjectId) {
        IKSMService ksmService = super.getKSMObject(ksmObjectId);
        String getAllRelatededKSMCisCypherString = String.format(
                "MATCH " +
                        "(ind:`KSMBaseIndicatorImpl`)-[rel2:`AttachedKSMKPI`|`AttachedKSMHI`]->(n:`%s`)-[rel:`%s`*]->(s:`%s` { ksmObjectId: '%s' }) \n" +
                        //"WITH DISTINCT n as CIs \n" +
                        "RETURN ind,rel2,n,rel"
                , KSMCI_CLASS_IMPL.getSimpleName()
                , "Linked_KSMCI"
                , KSMSERVICE_CLASS_IMPL.getSimpleName()
                , ksmObjectId
        );


        String getAllRelatededLinkedKSMCI_KSMRelationShips2 =  String.format(
                "MATCH path = \n" +
                        "(n:`%s`)-[rel:`%s`*]->(s:`%s` { ksmObjectId: '%s' }) \n" +
                        "WITH relationships(path) AS res " +
                        "UNWIND res AS rel " +
                       "WITH DISTINCT rel " +
                      "RETURN  *"
                , KSMCI_CLASS_IMPL.getSimpleName()
                , "Linked_KSMCI"
                , KSMSERVICE_CLASS_IMPL.getSimpleName()
                , ksmObjectId
        );
        String getAllRelatededLinkedKSMCI_KSMRelationShips =  String.format(
                "MATCH path = \n" +
                        "(n:`%s`)-[rel:`%s`*]->(s:`%s` { ksmObjectId: '%s' }) \n" +
                        "RETURN  *"
                , KSMCI_CLASS_IMPL.getSimpleName()
                , "Linked_KSMCI"
                , KSMSERVICE_CLASS_IMPL.getSimpleName()
                , ksmObjectId
        );

        Iterable<? extends IKSMCI> relatedKSMCIs = ksmObjectApiServiceProvider.getSession().query(KSMCI_CLASS_IMPL, getAllRelatededKSMCisCypherString, Collections.emptyMap());
        Iterable<? extends KSMCI2KSMCIKSMRelationShip> relationShips = ksmObjectApiServiceProvider.getSession().query(KSMCI2KSMCI_KSMRelationShip_CLASS_IMPL, getAllRelatededLinkedKSMCI_KSMRelationShips, Collections.emptyMap());




        KSMServiceModelImpl srvcModel = new KSMServiceModelImpl(ksmService, relatedKSMCIs, relationShips);

        IKSMServiceModel srvc = KSMObjectBuilderfactory.getKSMServiceModelBuilder(this.ksmObjectApiServiceProvider)
                .setKSMService(ksmService)
                .setRelatedKSMCIs(relatedKSMCIs)
                .setRelationShips(relationShips)
                .build();

        //throw new IllegalArgumentException("NOT IMPLEMENTED YET");
        return (U) srvc;

    }

    @Override
    public IKSMServiceModelBuilder getKSMServiceModelBuilder() {
       return  KSMObjectBuilderfactory.getKSMServiceModelBuilder(this.ksmObjectApiServiceProvider);
    }

}

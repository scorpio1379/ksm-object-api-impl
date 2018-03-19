package ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.implementations;

import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.response.model.RelationshipModel;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMObjectBuilderfactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMServiceModelImpl;
import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.KSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.IKSMServiceModelManager;
import ru.ip.ksm.ksmobjectapiimpl.ksmobjectmanagers.interfaces.KSMServiceModelManager;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

import java.util.Collections;
import java.util.Map;


public class KSMServiceModelManagerImpl
        extends KSMServiceManagerImpl<KSMServiceModelManager,KSMServiceModel>
        implements KSMServiceModelManager // эеквивалентно implements IKSMServiceModelManager<KSMServiceModelManager,KSMServiceModel>

{


    public KSMServiceModelManagerImpl(KSMObjectApiServiceProvider ksmObjectApiServiceProvider) {
        super(ksmObjectApiServiceProvider);
    }

    @Override
    public KSMServiceModel getKSMObject(String ksmObjectId) {
        IKSMService ksmService = super.getKSMObject(ksmObjectId);
        String getAllRelatededKSMCisCypherString = String.format(
                "MATCH " +
                        "(n:`%s`)-[rel:`%s`]->(s:`%s` { ksmObjectId: '%s' }) \n" +
                        "WITH DISTINCT n as CIs \n" +
                        "RETURN CIs"
                , KSMCI_CLASS_IMPL.getSimpleName()
                , "Linked_KSMCI"
                , KSMSERVICE_CLASS_IMPL.getSimpleName()
                , ksmObjectId
        );
        Iterable<? extends IKSMCI> result = ksmObjectApiServiceProvider.getSession().query(KSMCI_CLASS_IMPL, getAllRelatededKSMCisCypherString, Collections.emptyMap());
        String getAllRelatededLinkedKSMCI_KSMRelationShips =  String.format(
                "MATCH " +
                        "(n:`%s`)-[rel:`%s`]->(s:`%s` { ksmObjectId: '%s' }) \n" +
                        "WITH DISTINCT rel as rels \n" +
 //                       "UNWIND rels AS relations \n" +
//                        "WITH DISTINCT relations as relationships \n" +
                        "RETURN rels"
                , KSMCI_CLASS_IMPL.getSimpleName()
                , "Linked_KSMCI"
                , KSMSERVICE_CLASS_IMPL.getSimpleName()
                , ksmObjectId
        );
        String getAllRelatededLinkedKSMCI_KSMRelationShips2 =  String.format(
                "MATCH path = \n" +
                        "(n:`%s`)-[rel:`%s`]->(s:`%s` { ksmObjectId: '%s' }) \n" +
                        "WITH relationships(path) AS res " +
                        "UNWIND res AS rel " +
                        "WITH DISTINCT rel " +
                        "RETURN  rel as rels"
                , KSMCI_CLASS_IMPL.getSimpleName()
                , "Linked_KSMCI"
                , KSMSERVICE_CLASS_IMPL.getSimpleName()
                , ksmObjectId
        );

        Iterable<Map<String, Object>> rtn = ksmObjectApiServiceProvider.getSession().query(getAllRelatededLinkedKSMCI_KSMRelationShips, Collections.EMPTY_MAP);
        Iterable<Map<String, Object>> rtn2 = ksmObjectApiServiceProvider.getSession().query(getAllRelatededLinkedKSMCI_KSMRelationShips2, Collections.EMPTY_MAP);
        KSMCI2KSMCIKSMRelationShip r = ksmObjectApiServiceProvider.getSession().queryForObject(KSMCI2KSMCIKSMRelationShip.class, getAllRelatededLinkedKSMCI_KSMRelationShips2, Collections.EMPTY_MAP);

        return null;

    }

    @Override
    public KSMServiceModelBuilder getKSMServiceModelBuilder() {
       return KSMObjectBuilderfactory.getKSMServiceModelBuilder(this.ksmObjectApiServiceProvider);
    }
}

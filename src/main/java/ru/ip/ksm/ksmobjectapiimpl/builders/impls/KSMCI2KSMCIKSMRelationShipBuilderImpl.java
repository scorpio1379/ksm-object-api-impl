package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.factories.KSMRelationShipBuilderFactory;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCI2KSMCIKSMRelationShipBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.LinkedCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.IKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.internalksmobjecttypes.InternalIKSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCI2KSMCIRelationShipService;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMRelationShipServiceFactory;

import java.util.Collections;
import java.util.Map;

public class KSMCI2KSMCIKSMRelationShipBuilderImpl implements KSMCI2KSMCIKSMRelationShipBuilder {
    private final KSMCI sourceKSMCI;
    private final KSMCI targetKSMCI;

    private final KSMObjectApiServiceProvider ksmObjectApiServiceProvider;
    private final Class<? extends IKSMCI2KSMCIKSMRelationShip> IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL;


    public KSMCI2KSMCIKSMRelationShipBuilderImpl(
            KSMObjectApiServiceProvider ksm_object_api_service_provider
            , Class<? extends IKSMCI2KSMCIKSMRelationShip> IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL
            , KSMCI sourceKSMCI
            , KSMCI targetKSMCI) {
        this.sourceKSMCI = sourceKSMCI;
        this.targetKSMCI = targetKSMCI;
        this.ksmObjectApiServiceProvider =ksm_object_api_service_provider;
        this.IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL = IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL;
    }

    /*TODO:разработать механизм проверки того что обьекты sourceKSMCI и targetKSMCI в базе ДЕЙСТВИТЕЛЬНО являются какой-либо реализацией интерфейса KSMCI*/
    @Override
    public void build() {
        InternalIKSMCI2KSMCIKSMRelationShip ci2ciRelation = null;
        IKSMCI2KSMCIKSMRelationShip rel = null;
        try {
            if (true)throw new IllegalArgumentException("not implemented");
            IKSMCI2KSMCIKSMRelationShip<IKSMCI , IKSMCI> ci2ciRelationShip = (IKSMCI2KSMCIKSMRelationShip<IKSMCI , IKSMCI>) this.IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL.newInstance();
            ci2ciRelation = (InternalIKSMCI2KSMCIKSMRelationShip<IKSMCI , IKSMCI>) ci2ciRelationShip;

        ci2ciRelation.setStartNode(this.sourceKSMCI);
        ci2ciRelation.setEndNode(this.targetKSMCI);

        rel = KSMRelationShipServiceFactory.getKSMCI2KSMCIKSMRelationShipService(this.ksmObjectApiServiceProvider, this.IKSMCI2KSMCI_KSMRELATIONSHIP_CLASS_IMPL).createOrUpdate(ci2ciRelation);

        } catch (InstantiationException|IllegalAccessException|IllegalArgumentException e) {
                System.out.println("implementing default method.");
            e.printStackTrace();
            String createCI2CIRelationShipCypherQueryString = String.format(
                        "MATCH (sourceKSMCI),(targetKSMCI) \n" +
                                "WHERE sourceKSMCI.ksmObjectId = '%s' AND targetKSMCI.ksmObjectId = '%s' \n"
                                + "MERGE (sourceKSMCI)-[r:%s]->(targetKSMCI) \n" +
                                "RETURN r",
                        this.sourceKSMCI.getKsmObjectId()
                        , this.targetKSMCI.getKsmObjectId()
                        //, CI2CI_KSM_RELATIONSHIP_TYPE_STRING
                    ,"Linked_KSMCI"
            );
            Iterable<Map<String, Object>> ret = ksmObjectApiServiceProvider.getSession().query(createCI2CIRelationShipCypherQueryString, Collections.emptyMap());
        }




    }
}

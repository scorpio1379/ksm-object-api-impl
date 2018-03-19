package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.ip.ksm.ksmobjectapiimpl.domain.relationships.KSMCI2KSMCIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;

import java.util.HashSet;
import java.util.Set;

public class KSMServiceModelImpl<T extends KSMServiceModelImpl<T>>
        extends KSMServiceImpl<T>
       implements IKSMServiceModel<T> {
//        implements KSMServiceModel {
    private final Set<? extends KSMCI2KSMCIKSMRelationShip> relationShips;
    private final Set<? extends IKSMCI> relatedKSMCIs;
    private final IKSMService ksmService;

    public KSMServiceModelImpl(IKSMService ksmService
            , Set<? extends IKSMCI> relatedKSMCIs
            , Set<? extends KSMCI2KSMCIKSMRelationShip> relationShips) {
        this.ksmService = ksmService;
        this.relatedKSMCIs = relatedKSMCIs;
        this.relationShips = relationShips;
    }

    public KSMServiceModelImpl(IKSMService ksmService
            , Iterable<? extends IKSMCI> relatedKSMCIs
            , Iterable<? extends KSMCI2KSMCIKSMRelationShip> relationShips) {
        Set<IKSMCI> relatedKSMCISet =   new HashSet<>();
        relatedKSMCIs.forEach(ci -> {relatedKSMCISet.add(ci);});

        Set<KSMCI2KSMCIKSMRelationShip> relationShipSet =   new HashSet<>();
        relationShips.forEach(relationship -> {relationShipSet.add(relationship);});

        this.ksmService = ksmService;
        this.relatedKSMCIs = relatedKSMCISet;
        this.relationShips = relationShipSet;
    }


    // create by build json plugin
    @Override
    public JSONObject toJson() {
        JSONObject srvc = this.ksmService.toJson();
        JSONArray relatedCIsJSON = new JSONArray();
        for (IKSMCI relatedKSMCI:relatedKSMCIs
                ) {
            relatedCIsJSON.put(relatedKSMCI.toJson());

        }
        srvc.put("relatedKSMCIs",relatedCIsJSON);
        JSONArray relationShipsJSON = new JSONArray();
        for (KSMCI2KSMCIKSMRelationShip relationShip:relationShips
                ) {
            relationShipsJSON.put(relationShip.toJson()) ;

        }
        srvc.put("relationShips" ,relationShipsJSON );

        return srvc;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}

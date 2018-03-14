package ru.ip.ksm.ksmobjectapiimpl.domain;

import org.neo4j.ogm.annotation.*;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;


public class LinkedCIKSMRelationShip {

    protected String ksmRelationShipId;
    //@Property
    //private String title;

    private IKSMCI sourceKSMCI;

    private IKSMCI targetKSMCI;


    public IKSMCI getSourceKSMCI() {
        return sourceKSMCI;
    }

    public void setSourceKSMCI(KSMCIImpl sourceKSMCI) {
        this.sourceKSMCI = sourceKSMCI;
    }

    public IKSMCI getTargetKSMCI() {
        return targetKSMCI;
    }

    public void setTargetKSMCI(KSMCIImpl targetKSMCI) {
        this.targetKSMCI = targetKSMCI;
    }
}

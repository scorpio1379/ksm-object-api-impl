package ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs;

import ru.ip.ksm.ksmobjectapiimpl.domain.AttachedKSMKPIKSMRelationShip;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMKPI;

public interface KSMKPI extends IKSMKPI{
    String getKsmRuleId();

    AttachedKSMKPIKSMRelationShip getAttachedKSMKPIKSMRelationShip();
}

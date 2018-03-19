package ru.ip.ksm.ksmobjectapiimpl.domainhelpers;

public interface IKSMKPI<T extends IKSMKPI<T>> extends IKSMIndicator<T> {
    String getKsmRuleId();
    void setKMMKPICalculationRuleId(String ksmKpiCalulationRuleId);
}

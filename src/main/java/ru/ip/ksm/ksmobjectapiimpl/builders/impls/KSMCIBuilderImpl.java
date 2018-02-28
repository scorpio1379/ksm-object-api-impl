package ru.ip.ksm.ksmobjectapiimpl.builders.impls;

import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMObjectBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.services.factories.KSMObjectServiceFactory;

public class KSMCIBuilderImpl
        extends BaseKSMObjectBuilderImpl<KSMCIBuilder>
        implements KSMCIBuilder {

    private final Class<? extends IKSMCI> CI_CLASS_IMPL ;
    //private final KSMObjectApiServiceProvider KSMObjectApiServiceProvider ;


    public KSMCIBuilderImpl(Class<? extends IKSMCI> ksmciClassImpl, KSMObjectApiServiceProvider ksm_object_api_service_provider) {
        super(ksm_object_api_service_provider);
        this.CI_CLASS_IMPL = ksmciClassImpl;
        //this.KSMObjectApiServiceProvider = ksm_object_api_service_provider;
    }


    @Override
    public KSMCI build() {
        try {
            KSMCI tmpCi = (KSMCI) CI_CLASS_IMPL.newInstance();
            if (!this.ksmObjId.isEmpty()){
                /*todo: проверить что id подходит по д формат uuid и применить механизм, который позволит id стать case _IN_sensitive*.
                 */
                if (this.ksmObjId.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}")){
                    String low_case_ksmobjid = this.ksmObjId.toUpperCase().toLowerCase();
                    tmpCi.setKsmObjectId( low_case_ksmobjid);

                }else{
                    throw new IllegalArgumentException("ksmObjId NOT a UUID String");
                }
            }
            if (!this.ksmObjName.isEmpty()){
                tmpCi.setName(this.ksmObjName);
            }else {
                throw new IllegalArgumentException("CI MUST HAVE A NAME");
            }

            return KSMObjectServiceFactory.getKSMCIService((Class<? extends KSMCI>) CI_CLASS_IMPL, ksmObjectApiServiceProvider).createOrUpdate(tmpCi);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            IllegalArgumentException exc = new IllegalArgumentException("something goes wrong");
            exc.setStackTrace(e.getStackTrace());
            throw exc;
        }

    }

}

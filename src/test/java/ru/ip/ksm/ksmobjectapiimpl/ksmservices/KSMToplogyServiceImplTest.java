package ru.ip.ksm.ksmobjectapiimpl.ksmservices;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMCIBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMObjectBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMServiceModelBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMObjectBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMServiceModel;

import java.net.URI;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class KSMToplogyServiceImplTest {
    private ru.ip.ksm.ksmobjectapiimpl.api.KSMApi ksmApi;
    private KSMTopologyService ksmTopoService;
    private ExecutorService executorService;

    @Before
    public void setUp() throws Exception {
        KSMObjectApiServiceProvider provider = KSMObjectApiServiceFactory.getKSMObjectApiServiceProvider(URI.create("bolt://localhost:7687"));
        this.ksmApi = provider.connect();
        this.ksmTopoService = this.ksmApi.getKSMTopologyService();
        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("TestThread-%d")
                //.setDaemon(true)
                .build();
        this.executorService = Executors.newFixedThreadPool(20, threadFactory);


//        String deleteString = "MATCH (n)\n" +
//                "DETACH DELETE n";
//        provider.getSession().query(deleteString , Collections.EMPTY_MAP);


    }

    @Test
    public void getAllKSMCIs() {
        Set<IKSMCI> cis = ksmTopoService.getAllKSMCIs();
        for (IKSMCI ci: cis
             ) {
            System.out.println("KSMCI " + ci.getName() + " have ksmid " + ci.getKsmObjectId());

        }
    }

    @Test
    public void getAllIndicators() {
    }

    @Test
    public void getAllKSMHIs() {
    }

    @Test
    public void getAllKPIs() {
    }

    @Test
    public void getAllKSMServices() {
    }
    @Test
    public void createNewKSMServiceModel(){
        ksmTopoService.createNewKSMService()
                .setName("serviceName")
                .setDescription("desc")
                .build();

    }

    @Test
    public void createNewCI() {


    }
    @Test
    public void addNewKSMKPIToKSMCI() throws InstantiationException, IllegalAccessException {
        ksmTopoService.addNewKSMKPIToKSMCI(
                ksmTopoService.createNewKSMServiceModel()
                        .setName("serviceName")
                        .setDescription("desc")
                        .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                        .build())
                .setName("kpiname")
                .setDescription("kpidescr")
                .setRuleId("someruleid")
                .setStatus("sts")
                .setValue("42")
                .build();
    }

    @Test
    public void addNewKSMHIToKSMCI() throws InstantiationException, IllegalAccessException {
        ksmTopoService.addNewKSMHIToKSMCI(
                ksmTopoService.createNewKSMServiceModel()
                        .setName("serviceName")
                        .setDescription("desc")
                        .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                        .build())
                .setName("hiname")
                .setDescription("hidescr")
                .setStatus("sts")
                .setValue("442")
                .setKsmObjectId("e5b86f7e-6a3f-4050-aac1-b068e634d548")
                .build();
    }
    @Test
    public void linkKSMCI2KSMCI() throws InstantiationException, IllegalAccessException {
//        ksmTopoService.linkKSMCI2KSMCI(
//                ksmTopoService.createNewCI()
//                        .setKsmObjectId("0f6a0622-62da-48c1-8f7c-5f790091750d")
//                        .build()
//                ,
//                ksmTopoService.createNewKSMServiceModel()
//                        .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
//                        .build()
//
//
//        );
    }


    @Test
    public void getKSMServiceModel() {
        KSMServiceModel ksmServiceModel = ksmTopoService.getKSMServiceModel("c2a407f2-3e4a-48c8-8687-65da01995f88");
    }

    @Test
    public void populateGDB() throws InstantiationException, IllegalAccessException {
        KSMCI srvc = ksmTopoService.createNewKSMServiceModel()
                .setName("serviceName")
                .setDescription("desc")
                .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                .build();

        ksmTopoService.addNewKSMHIToKSMCI(
                ksmTopoService.createNewKSMServiceModel()
                        .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                        .build())
                .setName("service_hi_name")
                .setDescription("hidescr")
                .setStatus("sts")
                .setValue("442")
                .setKsmObjectId("e5b86f7e-6a3f-4050-aac1-b068e634d548")
                .build();

        ksmTopoService.addNewKSMKPIToKSMCI(
                ksmTopoService.createNewKSMServiceModel()
                        .setName("serviceName")
                        .setDescription("desc")
                        .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                        .build())
                .setName("service_kpi_name")
                .setDescription("kpidescr")
                .setRuleId("someruleid")
                .setStatus("sts")
                .setValue("42")
                .build();

        KSMCI appCI = ksmTopoService.createNewCI()
                .setName("Application CI")
                .setDescription("desc")
                .setKsmObjectId(UUID.randomUUID().toString())
                .build();

        KSMCI dbCI = ksmTopoService.createNewCI()
                .setName("DATABASE CI")
                .setDescription("desc")
                .setKsmObjectId(UUID.randomUUID().toString())
                .build();

        ksmTopoService.linkKSMCI2KSMCI(dbCI , appCI);
        ksmTopoService.linkKSMCI2KSMCI(dbCI , srvc);
        ksmTopoService.linkKSMCI2KSMCI(appCI , srvc);

        ksmTopoService.addNewKSMHIToKSMCI(
                dbCI)
                .setName("database_hi_name")
                .setDescription("hidescr")
                .setStatus("sts")
                .setValue("442")
                .build();

        ksmTopoService.addNewKSMKPIToKSMCI(
                dbCI)
                .setName("database_kpi_name")
                .setDescription("kpidescr")
                .setRuleId("someruleid")
                .setStatus("sts")
                .setValue("42")
                .build();

        ksmTopoService.addNewKSMHIToKSMCI(
                appCI)
                .setName("application_hi_name")
                .setDescription("hidescr")
                .setStatus("sts")
                .setValue("442")
                .build();

        ksmTopoService.addNewKSMKPIToKSMCI(
                appCI)
                .setName("application_kpi_name")
                .setDescription("kpidescr")
                .setRuleId("someruleid")
                .setStatus("sts")
                .setValue("42")
                .build();

    }



}
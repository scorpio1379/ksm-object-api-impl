package ru.ip.ksm.ksmobjectapiimpl.ksmservices;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMCI;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMService;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMServiceModel;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMService;

import java.net.URI;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class KSMToplogyServiceImplTest {
    private ru.ip.ksm.ksmobjectapiimpl.api.KSMApi ksmApi;
    private KSMTopologyService ksmTopoService;
    private ExecutorService executorService;

    @Before
    public void setUp() {
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
        Set<KSMService> ksmSrvcs = ksmTopoService.getAllKSMServices();
    }
    @Test
    public void createNewKSMServiceModel(){
        IKSMService srvc = ksmTopoService.createNewKSMService()
                .setName("serviceName")
                .setDescription("desc")
                .build();

    }

    @Test
    public void createNewCI() {
        IKSMCI ksmci = ksmTopoService.createNewCI().setName("newCI").setDescription("newDescr").build();


    }
    @Test
    public void addNewKSMKPIToKSMCI() throws InstantiationException, IllegalAccessException {



        ksmTopoService.addNewKSMKPIToKSMCI( ksmTopoService.createNewKSMService()
                    .setName("serviceName")
                    .setDescription("desc")
                    .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                    .build()
                )
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
                ksmTopoService.createNewKSMService()
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
    public void linkKSMCI2KSMCI() {
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
        IKSMServiceModel ksmServiceModel = ksmTopoService.getKSMServiceModel("c2a407f2-3e4a-48c8-8687-65da01995f88");
        String jsonString = ksmServiceModel.toString();
    }

    @Test
    public void populateGDB() throws InstantiationException, IllegalAccessException {
        IKSMService srvc = ksmTopoService.createNewKSMService()
                .setName("serviceName")
                .setDescription("desc")
                .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                .build();

        ksmTopoService.addNewKSMHIToKSMCI(
                ksmTopoService.createNewKSMService()
                        .setKsmObjectId("c2a407f2-3e4a-48c8-8687-65da01995f88")
                        .build())
                .setName("service_hi_name")
                .setDescription("hidescr")
                .setStatus("sts")
                .setValue("442")
                .setKsmObjectId("e5b86f7e-6a3f-4050-aac1-b068e634d548")
                .build();

        ksmTopoService.addNewKSMKPIToKSMCI(
                ksmTopoService.createNewKSMService()
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

        IKSMCI appCI = ksmTopoService.createNewCI()
                .setName("Application CI")
                .setDescription("desc")
                .setKsmObjectId("6887cce8-b94d-450c-a078-bf97eb3211d8")
                .build();

        IKSMCI dbCI = ksmTopoService.createNewCI()
                .setName("DATABASE CI")
                .setDescription("desc")
                .setKsmObjectId("41d72f1c-8dfc-4049-acb5-60f87c055201")
                .build();

        IKSMCI host1CI = ksmTopoService.createNewCI()
                .setName("host1 CI")
                .setDescription("desc")
                .setKsmObjectId("15fdd0e9-d40a-4dca-981b-5859f5c4a1ed")
                .build();

        IKSMCI host2CI = ksmTopoService.createNewCI()
                .setName("host2 CI")
                .setDescription("desc")
                .setKsmObjectId("2bf748ca-6d49-4633-bb4e-6f0530927754")
                .build();


        ksmTopoService.linkKSMCI2KSMCI(dbCI , appCI);
        ksmTopoService.linkKSMCI2KSMCI(dbCI , srvc);
        ksmTopoService.linkKSMCI2KSMCI(appCI , srvc);
        ksmTopoService.linkKSMCI2KSMCI(host1CI , appCI);
        ksmTopoService.linkKSMCI2KSMCI(host2CI , dbCI);
        ksmTopoService.linkKSMCI2KSMCI(host1CI , dbCI);
        ksmTopoService.linkKSMCI2KSMCI(host2CI , appCI);
        ksmTopoService.linkKSMCI2KSMCI(host1CI , host2CI);

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

        ksmTopoService.addNewKSMKPIToKSMCI(
                host1CI)
                .setName("host1_kpi_name")
                .setDescription("kpidescr")
                .setRuleId("someruleid")
                .setStatus("sts")
                .setValue("42")
                .build();

        ksmTopoService.addNewKSMHIToKSMCI(
                host2CI)
                .setName("host2_hi_name")
                .setDescription("hidescr")
                .setStatus("sts")
                .setValue("442")
                .build();

        ksmTopoService.addNewKSMKPIToKSMCI(
                host2CI)
                .setName("host2_kpi_name")
                .setDescription("kpidescr")
                .setRuleId("someruleid")
                .setStatus("sts")
                .setValue("42")
                .build();

        ksmTopoService.addNewKSMHIToKSMCI(
                host1CI)
                .setName("host1_hi_name")
                .setDescription("hidescr")
                .setStatus("sts")
                .setValue("442")
                .build();

    }



}
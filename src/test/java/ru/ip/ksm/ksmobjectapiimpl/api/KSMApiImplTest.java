package ru.ip.ksm.ksmobjectapiimpl.api;

import org.junit.Rule;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.TestGraphDatabaseFactory;
import org.neo4j.test.rule.TestDirectory;
import ru.ip.ksm.ksmobjectapi.KSMApi;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.services.KSMCIServiceOGMImpl;

import java.net.URI;
import java.util.UUID;

public class KSMApiImplTest {
    @Rule
    public TestDirectory testDirectory = TestDirectory.testDirectory();
    protected GraphDatabaseService graphDb;

    protected KSMApi ksmApi;

    @org.junit.Before
    public void setUp() throws Exception {
        GraphDatabaseService graphDb = new TestGraphDatabaseFactory().newImpermanentDatabase(testDirectory.directory());
        KSMObjectApiServiceProvider provider = KSMObjectApiServiceFactory.getKSMObjectApiServiceProvider(URI.create("bolt://localhost:7687"));
        this.ksmApi = provider.connect();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        graphDb.shutdown();
    }

    @org.junit.Test
    public void getKSMTopologyService() {
        this.ksmApi.getKSMTopologyService().createNewCI().setName("name").setDescription("desc").build();
        KSMCIImpl ci = new KSMCIImpl();
        ci.setName("name1");
        ci.setKsmObjectId(UUID.randomUUID().toString());

        new KSMCIServiceOGMImpl().createOrUpdate(ci);
        System.out.println();
    }

    @org.junit.Test
    public void getAllKSMServices() {
    }

    @org.junit.Test
    public void getKSMServiceByKSMObjId() {
    }

    @org.junit.Test
    public void getKSMCIByKSMObjId() {
    }

    @org.junit.Test
    public void getKSMKPIByKSMObjId() {
    }

    @org.junit.Test
    public void getKSMHIByKSMObjId() {
    }

    @org.junit.Test
    public void deleteKSMObjectByKsmID() {
    }

    @org.junit.Test
    public void linkCIToCI() {
    }

    @org.junit.Test
    public void getCIBuilder() {
    }

    @org.junit.Test
    public void getCIBuilder1() {
    }

    @org.junit.Test
    public void getKPIBuilder() {
    }

    @org.junit.Test
    public void getKPIBuilder1() {
    }

    @org.junit.Test
    public void getHIBuilder() {
    }

    @org.junit.Test
    public void getServiceBuilder() {
    }

    @org.junit.Test
    public void getHost() {
    }

    @org.junit.Test
    public void getPort() {
    }

    @org.junit.Test
    public void getProtocol() {
    }
}
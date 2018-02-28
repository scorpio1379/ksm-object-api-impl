package ru.ip.ksm.ksmobjectapiimpl.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.rule.TestDirectory;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;
import ru.ip.ksm.ksmobjectapiimpl.ksmservices.KSMTopologyService;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@RunWith(JUnit4.class)
public class KSMApiImplTest {
    @Rule
    public TestDirectory testDirectory = TestDirectory.testDirectory();
    protected GraphDatabaseService graphDb;

    protected KSMApi ksmApi;

    @Before
    public void setUp() throws Exception {
//        System.out.println("testDir = " + testDirectory.directory());
//        graphDb = new TestGraphDatabaseFactory().newImpermanentDatabase(testDirectory.directory());
//        KSMObjectApiServiceProvider provider = KSMObjectApiServiceFactory.getKSMObjectApiServiceProvider(URI.create("bolt://localhost:7687"));
//        this.ksmApi = provider.connect();
    }

    @After
    public void tearDown() throws Exception {
        //graphDb.shutdown();
    }

    @Test
    public void getKSMTopologyService() {
        //graphDb = new TestGraphDatabaseFactory().newImpermanentDatabase(testDirectory.directory());
        KSMObjectApiServiceProvider provider = KSMObjectApiServiceFactory.getKSMObjectApiServiceProvider(URI.create("bolt://localhost:7687"));
        this.ksmApi = provider.connect();
        KSMTopologyService ksmTopoService = this.ksmApi.getKSMTopologyService();
        KSMCI ci = ksmTopoService.createNewCI()
                .setName("name")
                .setDescription("desc")
                .setKsmObjectId(UUID.randomUUID().toString())
                .build();

        Set<KSMCI> cis = ksmTopoService.getAllKSMCIs();

        System.out.println();
    }

}
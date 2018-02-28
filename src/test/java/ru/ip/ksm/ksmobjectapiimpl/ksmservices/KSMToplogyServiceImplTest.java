package ru.ip.ksm.ksmobjectapiimpl.ksmservices;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceFactory;
import ru.ip.ksm.ksmobjectapiimpl.apifactory.KSMObjectApiServiceProvider;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.KSMCIBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.impls.abstracts.BaseKSMObjectBuilderImpl;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMObjectBuilder;
import ru.ip.ksm.ksmobjectapiimpl.domain.KSMCIImpl;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;

import java.net.URI;
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
    }

    @Test
    public void getAllKSMCIs() {
        Set<KSMCI> cis = ksmTopoService.getAllKSMCIs();
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
        ksmTopoService.createNewKSMServiceModel()
                .setName("serviceName")
                .setDescription("desc")
                .addKSMCI(ksmTopoService.createNewCI()
                        .setName("name")
                        .setDescription("desc")
                        .setKsmObjectId(UUID.randomUUID().toString())
                        .build())
                .addKSMCI("ksmId")
                .addRelationship();

    }

    @Test
    public void createNewCI() {
        for (int i = 0; i < 10 ; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    BaseKSMObjectBuilderImpl baseKSMObjectBuilder = new BaseKSMObjectBuilderImpl(KSMObjectApiServiceFactory.getKSMObjectApiServiceProvider(URI.create("bolt://localhost:7687")));
                    AbstractKSMObjectBuilder abstractKSMObjectBuilder = (AbstractKSMObjectBuilder) baseKSMObjectBuilder;
                    KSMCIBuilderImpl ksmciBuilder = new KSMCIBuilderImpl(KSMCIImpl.class , KSMObjectApiServiceFactory.getKSMObjectApiServiceProvider(URI.create("bolt://localhost:7687")));
                    KSMCIBuilder ksmciBuilder1 = (KSMCIBuilder) ksmciBuilder;
                    KSMCIBuilder a = ksmTopoService.createNewCI();
                    KSMCIBuilder o = a.setName("fdsfs");
                    ksmTopoService.createNewCI()
                            .setName("name")
                            .setDescription("desc")
                            .setKsmObjectId(UUID.randomUUID().toString())
                            .build();
                }
            });
            t.run();
        }

    }
}
package ru.ip.ksm.ksmobjectapiimpl.apifactory;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import ru.ip.ksm.ksmobjectapiimpl.api.KSMApi;
import ru.ip.ksm.ksmobjectapiimpl.api.KSMApiImpl;

import java.net.URI;

public class KSMObjectApiServiceProvider {
    private static final String[] DOMAIN_PACKAGES = {"ru.ip.ksm.ksmobjectapiimpl.domain" , "ru.ip.ksm.ksmobjectapiimpl.domainhelpers"};
    private final URI ksmCoreServerUri ;
    private final  SessionFactory sessionFactory;


    public KSMObjectApiServiceProvider(URI ksmCoreServerUri) {
        System.out.println("scheme = " + ksmCoreServerUri.getScheme());
        if (ksmCoreServerUri.getScheme().equalsIgnoreCase("bolt")){
            this.ksmCoreServerUri = ksmCoreServerUri;
            Configuration cfg = new Configuration.Builder().uri(ksmCoreServerUri.toString()).autoIndex("assert").build();
            //Configuration cfg1 = new Configuration.Builder().uri(ksmCoreServerUri.toString()).build();
            Boolean isVerified = cfg.getVerifyConnection();
            //SessionFactory sf = new SessionFactory(cfg1);
            this.sessionFactory = new SessionFactory(cfg, DOMAIN_PACKAGES);
        }else{
            throw new IllegalArgumentException("protocol in uri MUST be bolt://");
        }
    }
    public KSMObjectApiServiceProvider(String ksmCoreServerUri) {
        System.out.println("scheme = " + URI.create(ksmCoreServerUri).getScheme());
        if (URI.create(ksmCoreServerUri).getScheme().equalsIgnoreCase("bolt")){
            this.ksmCoreServerUri = URI.create(ksmCoreServerUri);
            Configuration cfg = new Configuration.Builder().uri(ksmCoreServerUri.toString()).autoIndex("assert").build();
            Boolean isVerified = cfg.getVerifyConnection();
            this.sessionFactory = new SessionFactory(cfg, DOMAIN_PACKAGES);
        }else{
            throw new IllegalArgumentException("protocol in uri MUST be bolt://");
        }
    }

   private KSMObjectApiServiceProvider() {
        /* не должно произйти */
        ksmCoreServerUri = null;
        sessionFactory = null;
    }



    public KSMApi connect(){
        return new KSMApiImpl(this);

    }
    public String getHost(){
        return this.ksmCoreServerUri.getHost();
    }

    public int getPort(){
        return this.ksmCoreServerUri.getPort();
    }
    public String getProtocol (){
        return this.ksmCoreServerUri.getScheme();
    }

    public URI getUri(){
        return this.ksmCoreServerUri;
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }
}

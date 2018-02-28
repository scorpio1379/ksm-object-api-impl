package ru.ip.ksm.ksmobjectapiimpl.builders.infs;


import ru.ip.ksm.ksmobjectapiimpl.builders.infs.abstracts.AbstractKSMObjectBuilder;
import ru.ip.ksm.ksmobjectapiimpl.externalksmobjectsinfs.KSMCI;


public interface KSMCIBuilder
        extends AbstractKSMObjectBuilder<KSMCIBuilder> {


    KSMCI build();
}

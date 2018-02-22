package ru.ip.ksm.ksmobjectapiimpl.builders.factories;

import ru.ip.ksm.ksmobjectapi.builders.KSMCIBuilder;
import ru.ip.ksm.ksmobjectapi.builders.abstracts.AbstractKSMObjectBuilder;
import ru.ip.ksm.ksmobjectapi.objects.KSMCI;

public class KSMCIBuilderFactory {
    public static KSMCIBuilder getBuilder() {
        return new KSMCIBuilder() {
            private
            @Override
            public KSMCI build() {
                return null;
            }

            @Override
            public AbstractKSMObjectBuilder<KSMCIBuilder> setName(String s) {
                return this;
            }

            @Override
            public AbstractKSMObjectBuilder<KSMCIBuilder> setDescription(String s) {
                return this;
            }
        }
    }
}

package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.IKSMObject;
import ru.ip.ksm.ksmobjectapiimpl.domainhelpers.relationships.abstracts.AbstractKSMRelationShip;

public abstract class BaseKSMRelationShipServiceOGMImpl<KSMREL extends AbstractKSMRelationShip<STARTNODE,ENDNODE>
        , STARTNODE extends IKSMObject
        , ENDNODE extends IKSMObject>
        implements
        AbstractKSMRelationShipService<KSMREL, STARTNODE,ENDNODE> {

    protected Session session;

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;

    @Override
    public Iterable<KSMREL> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }

    @Override
    public KSMREL find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    @Override
    public KSMREL find(String ksmRelationShipId) {
        return session.load(getEntityType(), ksmRelationShipId, DEPTH_ENTITY);
    }

    @Override
    public KSMREL findByKsmObjId(String ksmRelationShipId) {
        return session.load(getEntityType() , ksmRelationShipId);
    }

    @Override
    public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));
    }

    @Override
    public void delete(String id) {
        session.delete(session.load(getEntityType(), id));
    }


    @Override
    public void deleteByKsmObjId(String ksmRelationShipId) {
        session.delete(session.load(getEntityType(), ksmRelationShipId));

    }
    @Override
    public KSMREL createOrUpdate(KSMREL ksmRelationShip) {
        session.save(ksmRelationShip, DEPTH_ENTITY);
        return findByKsmObjId(ksmRelationShip.getKsmRelationShipId());
    }

    protected Logger getLogger(){
        return LoggerFactory.getLogger(this.getClass().getCanonicalName());
    }

    protected abstract Class<KSMREL> getEntityType();
}

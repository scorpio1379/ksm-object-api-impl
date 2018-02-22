package ru.ip.ksm.ksmobjectapiimpl.services.abstracts;

import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ip.ksm.ksmobjectapiimpl.domain.abstracts.KSMBaseObjectImpl;

public abstract class BaseKSMObjectServiceOGMImpl<KSMOBJ extends KSMBaseObjectImpl>
        implements AbstractKSMObjectService<KSMOBJ>
    {
    protected  Session session;

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;

    @Override

    public Iterable<KSMOBJ> findAll() {
            return null;
    }
    @Override
    public KSMOBJ find(Long id) {
            return null;
    }
    @Override
    public KSMOBJ find(String ksmObjId) {
            return null;
    }

    public KSMOBJ findByKsmObjId(String ksmObjId) {
        return session.load(getEntityType() , ksmObjId);
    }



    public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));

    }

    public void deleteByKsmObjId(String ksmObjId) {
        session.delete(session.load(getEntityType(), ksmObjId));

    }

    protected abstract Class<KSMOBJ> getEntityType();



    public KSMOBJ createOrUpdate(KSMOBJ ksmObject) {
        session.save(ksmObject, DEPTH_ENTITY);
        //Long lId= ksmObject.getId();
        String uuid = ksmObject.getKsmObjectId();
        KSMOBJ obj = null;
        System.out.println("param T is" + ksmObject.getClass().getCanonicalName());
        try{
            obj = find(uuid);
        } catch (Exception e){
            System.out.println(" error trying to get object by long id " + e.getMessage());
            obj = findByKsmObjId(ksmObject.getKsmObjectId());
        }finally {
            if(obj!=null){
                return obj;
            }else{
                getLogger().error("Can not get Node from GDB  by Long Id ={} nor by uuid {}" , -1,uuid);
                throw new IndexOutOfBoundsException("Can not get Node from GDB  by Long Id =" + -1 + " nor by uuid " + uuid);
            }
        }
    }

    protected Logger getLogger(){
        return LoggerFactory.getLogger(this.getClass().getCanonicalName());
    }
}

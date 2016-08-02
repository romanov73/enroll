package ru.ulstu.enroll.services;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import ru.ulstu.enroll.entity.BaseEntity;

@Named
public class JPAController implements Serializable {

    EntityManager em = Persistence.createEntityManagerFactory("enrollPU").createEntityManager();

    public JPAController() {

    }

    public void create(BaseEntity newEntity) {
        em.getTransaction().begin();
        em.persist(newEntity);
        em.getTransaction().commit();
    }

    public BaseEntity edit(BaseEntity newEntity) {
        em.getTransaction().begin();
        newEntity = em.merge(newEntity);
        em.getTransaction().commit();
        return newEntity;
    }

    public void destroy(BaseEntity entity) {
        em.getTransaction().begin();
        BaseEntity findEntity = null;
        /*findEntity = em.getReference(entity.getClass(), entity.getId());
        findEntity.getId();*/
        em.remove(findEntity);
        em.getTransaction().commit();
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = em.createQuery(cq);

        return q.getResultList();
    }

    public <T> T findById(Class<? extends BaseEntity> entityClass, Long id) {
        return em.find((Class<T>) entityClass, id);
    }

    public <T> List<T> findAll(Class<T> type, String namedQueryName) {
        return em.createNamedQuery(namedQueryName, type).getResultList();
    }

    public <T> List<T> findAll(Class<T> type, String queryName, int resultLimit) {
        return em.createNamedQuery(queryName, type).setMaxResults(resultLimit)
                .getResultList();
    }

    public <T> List<T> findAll(Class<T> type, String namedQueryName,
            QueryParameter parameters) {
        return findAll(type, namedQueryName, parameters, 0);

    }

    public <T> List<T> findAll(Class<T> type, String namedQueryName, 
            QueryParameter parameters, int resultLimit) {
        return prepareQuery(type, namedQueryName, parameters, resultLimit)
                .getResultList();
    }

    private <T> TypedQuery<T> prepareQuery(Class<T> type, String namedQueryName,
            QueryParameter parameters, int resultLimit) {
        Set<Entry<String, Object>> rawParameters;
        if (parameters != null) {
            rawParameters = parameters.parameters().entrySet();
        } else {
            rawParameters = Collections.emptySet();
        }
        TypedQuery<T> query = em.createNamedQuery(namedQueryName, type);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        rawParameters.stream().forEach((entry) -> {
            query.setParameter(entry.getKey(), entry.getValue());
        });
        return query;
    }
}

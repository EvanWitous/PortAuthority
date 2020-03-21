package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
public class BoatManagementFacadeBean implements BoatManagementFacade {

    @PersistenceContext(name = "PortAuthority")
    @PersistenceUnit(unitName = "PortAuthority")
    private EntityManagerFactory entityManagerFactory;

    public void add(NoticeOfArrival noa) {
        // TODO Auto-generated method stub
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(noa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

}

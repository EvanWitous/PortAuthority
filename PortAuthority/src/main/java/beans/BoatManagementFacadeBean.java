package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BoatManagementFacadeBean implements BoatManagementFacade {

    @PersistenceContext(name = "PortAuthority")
    EntityManager em;

    public void add(NoticeOfArrival noa) {
        // TODO Auto-generated method stub
        em.persist(noa);
    }

}

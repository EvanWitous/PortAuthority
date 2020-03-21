package beans;

import javax.ejb.Local;

@Local
public interface BoatManagementFacade {
    public void add(NoticeOfArrival noa);
}

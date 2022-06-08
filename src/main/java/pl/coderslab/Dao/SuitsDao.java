package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Suits;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class SuitsDao {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.


    public void save(Suits suits) {

        entityManager.persist(suits);
    }

    public Suits findById(long id) {
        return entityManager.find(Suits.class, id);
    }

    public void update(Suits suits) {
        entityManager.merge(suits);
    }

    public void delete(Suits suits) {
        entityManager.remove(entityManager.contains(suits) ? suits : entityManager.merge(suits));
    }

    public List getList() {
        return entityManager.createQuery("select b from Suits b").getResultList();
    }

    //zapytanie JPQL
    public List findAllByCategory(int category) {
        return entityManager
                .createQuery("select b from Suits b where b.category=:cat")
                .setParameter("cat", category)
                .getResultList();
    }


}

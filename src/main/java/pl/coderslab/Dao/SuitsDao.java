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

    //-----------
    public List<Suits> findAllBySuitsModel(String p_model) {
        return entityManager
                .createQuery("select b from Suits b where b.pModel=:model")
                .setParameter("model", p_model)
                .getResultList();
    }

    public List<Suits> findProductId(String name) {
        return entityManager
                .createQuery("select b from ProductList b where b.name=:name")
                .setParameter("name", name)
                .getResultList();
    }

    public List<Suits> findAllByProductName(String pName) {
        return entityManager
                .createQuery("select b from Suits b where b.pName=:var")
                .setParameter("var", pName)
                .getResultList();
    }


    // FIND BY SIZE -> do wyszukiwarki
    // FIND BY SIZE && MODEL -> do maczowania

}

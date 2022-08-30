package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Productlist;
import pl.coderslab.model.Suits;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class ProductsRepository {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.


    public void save(Suits suits) { //wszystko jest w jednej bazie SUITS

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
    public List getProdList() {
        return entityManager.createQuery("select b from Productlist b").getResultList();
    }

    //zapytanie JPQL
    public List findAllByCategory(int category) {
        return entityManager
                .createQuery("select b from Suits b where b.category=:cat")
                .setParameter("cat", category)
                .getResultList();
    }

    //-----------
    public List<Suits> findAllByModel(String p_model) {
        return entityManager
                .createQuery("select b from Suits b where b.pModel=:model")
                .setParameter("model", p_model)
                .getResultList();
    }

    public List<Productlist> findAllByProductNameExcept(String name) { //Użyte w liście produktów ORAZ przy kasowaniu
        return entityManager
                .createQuery("select b from Suits b where NOT b.productlist.name=:var")
                .setParameter("var", name)
                .getResultList();
    }

    public List<Productlist> findListByProductNameExcept(String name) {
        return entityManager
                .createQuery("select b from Productlist b where NOT b.name =:var")
                .setParameter("var", name)
                .getResultList();
    }
}

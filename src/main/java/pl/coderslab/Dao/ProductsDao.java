package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.ProductList;
import pl.coderslab.model.Suits;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional

public class ProductsDao {

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
        return entityManager.createQuery("select b from ProductList b").getResultList();
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

    public List<ProductList> findAllByProductNameExcept(String p_name) {
        return entityManager
                .createQuery("select b from Suits b where NOT b.pName =:var")
                .setParameter("var", p_name)
                .getResultList();
    }

    public List<ProductList> findListByProductNameExcept(String name) {
        return entityManager
                .createQuery("select b from ProductList b where NOT b.name =:var")
                .setParameter("var", name)
                .getResultList();
    }
}

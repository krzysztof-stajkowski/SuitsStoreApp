package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.ProductList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductListDao { // ta klasa służy do przyszłego Crud tabeli z listą unikatów

    @PersistenceContext
    private EntityManager entityManager;

    public ProductList findById(long id) {
        return entityManager.find(ProductList.class, id);
    }

    public void update(ProductList productList) {
        entityManager.merge(productList);
    }

    public List<ProductList> getListExceptSuits(long id) {
        return entityManager
                .createQuery("select b from ProductList b where not b.id=:pos")
                .setParameter("pos", id)
                .getResultList();
    }

}


package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.ProductList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductListDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductList> getList() {
        return entityManager.createQuery("select b from ProductList b").getResultList(); //tu musi być samo b inaczej będzie błąd
    }

    public ProductList findById(long id) {
        return entityManager.find(ProductList.class, id);
    }

    public void update(ProductList productList) {
        entityManager.merge(productList);
    }


}

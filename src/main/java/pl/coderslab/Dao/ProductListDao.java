package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Productlist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductListDao { // ta klasa służy do przyszłego Crud tabeli z listą unikatów

    @PersistenceContext
    private EntityManager entityManager;

    //test z LMS
    public List<Productlist> getList() {
        return entityManager.createQuery("select b from Productlist b").getResultList(); //tu musi być samo b inaczej będzie błąd
    }

    public Productlist findById(long id) {
        return entityManager.find(Productlist.class, id);
    }

    public void update(Productlist productList) {
        entityManager.merge(productList);
    }

    public List<Productlist> getListExceptSuits(long id) {
        return entityManager
                .createQuery("select b from Productlist b where not b.id=:pos")
                .setParameter("pos", id)
                .getResultList();
    }

}


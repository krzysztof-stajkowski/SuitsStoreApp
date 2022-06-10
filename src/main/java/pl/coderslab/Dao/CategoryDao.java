package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository //Określamy, że nasza klasa ma być komponentem dostępu do bazy danych, zarządzanym przez Springa.
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.

    public List<Category> getList() {
        return entityManager.createQuery("select b from Category b").getResultList(); //tu musi być samo b inaczej będzie błąd
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }
}

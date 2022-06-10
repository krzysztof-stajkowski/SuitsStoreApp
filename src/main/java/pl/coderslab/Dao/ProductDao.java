package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Product;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository //Określamy, że nasza klasa ma być komponentem dostępu do bazy danych, zarządzanym przez Springa.
@Transactional
//Użycie adnotacji @Transactional powoduje, że każda publiczna metoda tej klasy będzie stanowić transakcję.
// Oznacza to, że transakcja zacznie się przed wejściem do metody, a zakończy po jej wykonaniu.
// Adnotację @Transactional - możemy umieścić nad całą klasą - wtedy będzie dotyczyć wszystkich jej metod lub nad pojedynczą metodą.

public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.


/**
EntityManager to obiekt, który posiada metody pozwalające w łatwy sposób operować na encjach.

Podstawowe metody to:

    persist - służy do zapisu
    find - do pobierania pojedynczego obiektu
    merge - do aktualizacji obiektu
    remove - do usuwania obiektu
    contains - do sprawdzania czy istnieje obiekt
*/

public void save(Product product) {
    entityManager.persist(product);
}

    public Product findById(long id) {
        return entityManager.find(Product .class, id);
    }

    public void update(Product product) {
        entityManager.merge(product);
    }

    public void delete(Product product) {
        entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
    }

    public List getList() {
        return entityManager.createQuery("select b from Product b").getResultList();
    }

    public List findAllByCategory(int category) {
        return entityManager
                .createQuery("select b from Product b where b.category=:cat")
                .setParameter("cat", category)
                .getResultList();
    }


}

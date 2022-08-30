package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository //Określamy, że nasza klasa ma być komponentem dostępu do bazy danych, zarządzanym przez Springa.
@Transactional
//Użycie adnotacji @Transactional powoduje, że każda publiczna metoda tej klasy będzie stanowić transakcję.
// Oznacza to, że transakcja zacznie się przed wejściem do metody, a zakończy po jej wykonaniu.
// Adnotację @Transactional - możemy umieścić nad całą klasą - wtedy będzie dotyczyć wszystkich jej metod lub nad pojedynczą metodą.

public class CategoryRepository {

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

    public List<Category> getList() {
        return entityManager.createQuery("select b from Category b").getResultList(); //tu musi być samo b inaczej będzie błąd
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public List<Category> findAllByCategoryName(String name) {
        return entityManager
                .createQuery("select b from Category b where b.name=:pName")
                .setParameter("pName", name)
                .getResultList();
    }

}

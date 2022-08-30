package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Matchtable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository //Określamy, że nasza klasa ma być komponentem dostępu do bazy danych, zarządzanym przez Springa.
@Transactional
//Użycie adnotacji @Transactional powoduje, że każda publiczna metoda tej klasy będzie stanowić transakcję.
// Oznacza to, że transakcja zacznie się przed wejściem do metody, a zakończy po jej wykonaniu.
// Adnotację @Transactional - możemy umieścić nad całą klasą - wtedy będzie dotyczyć wszystkich jej metod lub nad pojedynczą metodą.

public class MatchTableRepository {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.

    public List<Matchtable> getList() {
        return entityManager.createQuery("select b from Category b").getResultList(); //tu musi być samo b inaczej będzie błąd
    }

    public Matchtable findById(long id) {
        return entityManager.find(Matchtable.class, id);
    }

    public void update(Matchtable matchTable) {
        entityManager.merge(matchTable);
    }

    public List<Matchtable> findAllByMatchName(String name) {
        return entityManager
                .createQuery("select b from Matchtable b where b.mName=:Name")
                .setParameter("Name", name)
                .getResultList();
    }

}

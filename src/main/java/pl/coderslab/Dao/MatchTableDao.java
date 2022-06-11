package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.MatchTable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository //Określamy, że nasza klasa ma być komponentem dostępu do bazy danych, zarządzanym przez Springa.
@Transactional
//Użycie adnotacji @Transactional powoduje, że każda publiczna metoda tej klasy będzie stanowić transakcję.
// Oznacza to, że transakcja zacznie się przed wejściem do metody, a zakończy po jej wykonaniu.
// Adnotację @Transactional - możemy umieścić nad całą klasą - wtedy będzie dotyczyć wszystkich jej metod lub nad pojedynczą metodą.

public class MatchTableDao {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.

    public List<MatchTable> getList() {
        return entityManager.createQuery("select b from Category b").getResultList(); //tu musi być samo b inaczej będzie błąd
    }

    public MatchTable findById(long id) {
        return entityManager.find(MatchTable.class, id);
    }

    public void update(MatchTable matchTable) {
        entityManager.merge(matchTable);
    }

    public List<MatchTable> findAllByMatchName(String name) {
        return entityManager
                .createQuery("select b from MatchTable b where b.mName=:Name")
                .setParameter("Name", name)
                .getResultList();
    }

}

package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository //Określamy, że nasza klasa ma być komponentem dostępu do bazy danych, zarządzanym przez Springa.
@Transactional
//Użycie adnotacji @Transactional powoduje, że każda publiczna metoda tej klasy będzie stanowić transakcję.
// Oznacza to, że transakcja zacznie się przed wejściem do metody, a zakończy po jej wykonaniu.Adnotację @Transactional - możemy umieścić nad całą klasą - wtedy będzie dotyczyć wszystkich jej metod lub nad pojedynczą metodą.

public class SoldDao {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.

}

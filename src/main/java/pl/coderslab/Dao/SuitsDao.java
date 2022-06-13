package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Suits;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class SuitsDao {

    @PersistenceContext
    private EntityManager entityManager; //EntityManager – zarządca encji, udostępnia nam możliwość operowania na naszych encjach.


    public void save(Suits suits) {

        entityManager.persist(suits);
    }


    public void update(Suits suits) {
        entityManager.merge(suits);
    }

    public void delete(Suits suits) {
        entityManager.remove(entityManager.contains(suits) ? suits : entityManager.merge(suits));
    }

    public List getList() { //użyte do delete
        return entityManager.createQuery("select b from Productlist b").getResultList();
    }

    //zapytania JPQL
    //-----------
    public Suits findById(long id) {
        return entityManager.find(Suits.class, id);
    } //użyte do Delete
    public List<Suits> findAllByProductName(String name) { //Użyte w selekcie do dodawania garniturów
        return entityManager
                .createQuery("select b from Productlist b where b.name=:var")
                .setParameter("var", name)
                .getResultList();
    }

    public List<Suits> findAllByProductSize(String size,String name) { //Użyte w selekcie do dodawania garniturów
        return entityManager
                .createQuery("select b from Suits b where b.pSize=:var AND b.productlist.name=:var2")
                .setParameter("var", size)
                .setParameter("var2", name)
                .getResultList();
    }

    public List<Suits> ListAllByProductName(String name) { //Użyte w selecie do wyświetlania listy
        return entityManager
                .createQuery("select b from Suits b where b.productlist.name=:var")
                .setParameter("var", name)
                .getResultList();
    }

    public List getSizes(String name) { //listy rozwijanej w szukaniu modeli po rozmiarze w jsp suitsSearch
        return entityManager
                .createQuery("select b from Suits b WHERE b.productlist.name=:var ORDER BY b.pSize")
                .setParameter("var", name)
                .getResultList();
    }

    public List<Suits> ListAllSuitsBySize(String size, long id) { //Lista wynikowa już po wybraniu rozmiaru z dropdowna w jsp suitsFindByModel
        return entityManager
                .createQuery("select b from Suits b where b.pSize=:var AND b.productlist.id=:var2")
                .setParameter("var", size)
                .setParameter("var2", id)
                .getResultList();
    }

}

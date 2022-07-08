package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 10)
    @NotBlank(message = "Podaj nazwę kategorii") // to na przyszłość jak bedzie crud do tej tabeli
    private String name;

    //Konstruktora w encji - NIE MA - potrzebny jest bezargumentowy który i tak jest Default i nie trzeba go tworzyć

 /*
 RELACJA OBUSTRONNA - Mentor sugeruje aby unikać takich relazji jak nie trzeba ich mieć
 Poniższy kod powodował że nie mogłem edytować na bazie Category id w garniturze - teraz Działa

    @OneToMany(mappedBy = "category") //nie tworzymy kolejnej tabeli mapującej
    private List<Suits> suits = new ArrayList<>(); //gdy chcę po kategorii pobrać listę produktów

    public List<Suits> getSuits() {
        return suits;
    }

    public void setSuits(List<Suits> suits) {
        this.suits = suits;
    }
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

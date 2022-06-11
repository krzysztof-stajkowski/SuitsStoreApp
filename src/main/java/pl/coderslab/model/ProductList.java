package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 10)
    private String name;

    public List<Suits> getSuits() {
        return suits;
    }

    public void setSuits(List<Suits> suits) {
        this.suits = suits;
    }

    @OneToMany (mappedBy = "ProductList") //nie tworzymy kolejnej tabeli mapującej (aby mapowanie zadziałało muszą być getery i settery i relacje po obu stronach)
    private List<Suits> suits = new ArrayList<>(); //gdy chcę pobrać listę unikatowych produktów

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

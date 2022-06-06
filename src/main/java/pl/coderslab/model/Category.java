package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 10)
    private String name;

    @OneToMany(mappedBy = "category") //nie tworzymy kolejnej tabeli mapującej
    private List<Product> products  = new ArrayList<>(); //gdy chcę po kategorii pobrać listę produktów

    //Konstruktora w encji - NIE MA - potrzebny jest bezargumentowy który i tak jest Default i nie trzeba go tworzyć

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}

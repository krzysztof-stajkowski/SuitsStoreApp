package pl.coderslab.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sold { // ta encja tylko zapisuje i wyświetla

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category; //pobrane ze sprzedanego towaru
    private String model;
    private BigDecimal price;
    private int size;
    private String color;
    private String description;
    private String composition;

    @ManyToMany //Sold posiada informacje o produktach ale nie odwrotnie
    @JoinTable(name = "Sold_Products") //moja custom nazwa tabeli łaczącej
    private List<Product> products = new ArrayList<>(); //wiele produktów sprzedanych i wiele nadal w bazie produktów

    @ManyToMany //Sold posiada informacje o garniturach ale nie odwrotnie
    @JoinTable(name = "Sold_Suits") //moja custom nazwa tabeli łaczącej
    private List<Suits> suits = new ArrayList<>(); //wiele garniturów sprzedanych i wiele nadal w bazie produktów

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Suits> getSuits() {
        return suits;
    }

    public void setSuits(List<Suits> suits) {
        this.suits = suits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }



    @Override
    public String toString() {
        return "Sold{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", composition='" + composition + '\'' +
                ", products=" + products +
                '}';
    }
}

package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Suits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 10)
    @NotNull
    private String pName;

    @NotNull
    @Size(min = 8)
    @Size(max = 8)  // 25SS22BC -> 25 spring/summer 2022 Black
    private String pModel;

    @NotNull
    private BigDecimal pPrice;

    @NotNull
    private String pSize; // litery lub liczby

    @NotNull
    private String pColor;

    @NotNull
    @Size(max = 100)
    private String pDescription;

    @NotNull
    @Size(max = 25)
    private String pComposition;

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    private String pCategory;

    @NotNull
    @Min(0)
    @Max(1)
    private int pAvailable; // 1 dostępny do sprzedania - 0 na stanie ale nie na sprzedarz

    public int getpAvailable() {
        return pAvailable;
    }

    public void setpAvailable(int pAvailable) {
        this.pAvailable = pAvailable;
    }

    @ManyToOne //wiele produktów (garniturów) do jednej kategorii
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpModel() {
        return pModel;
    }

    public void setpModel(String pModel) {
        this.pModel = pModel;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpComposition() {
        return pComposition;
    }

    public void setpComposition(String pComposition) {
        this.pComposition = pComposition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", pModel='" + pModel + '\'' +
                ", pPrice=" + pPrice +
                ", pSize='" + pSize + '\'' +
                ", pColor='" + pColor + '\'' +
                ", pDescription='" + pDescription + '\'' +
                ", pComposition='" + pComposition + '\'' +
                ", category=" + category +
                '}';
    }

}

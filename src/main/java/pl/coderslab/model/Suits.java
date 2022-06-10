package pl.coderslab.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "suits")
public class Suits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 10) //to bedzie docelowo wybór z form select
    private String pName;

    @Size(min = 8, max = 8, message = "Model musi mieć 8 znaków w formacie np. 25SS22BC")  // 25SS22BC -> 25 spring/summer 2022 Black
    private String pModel;

    @Size(min = 6, max = 6, message = "Size musi mieć 6 znaków w formacie np. 176/50")
    private String pSize; // litery lub liczby

    @NotBlank(message = "Kolor nie może być pusty")
    private String pColor;

    @NotBlank(message = "Opis nie może być pusty (max 100 znaków)")
    @Size(max = 100)
    private String pDescription;

    @NotBlank(message = "Skład musi mieć maksymalnie 25 znaków np. wool50% PY50%")
    @Size(max = 25, message = "Skład musi mieć maksymalnie 25 znaków np. wool50% PY50%")
    private String pComposition;

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

    public long getCategoryId() {
        return category.getId();
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
                ", pSize='" + pSize + '\'' +
                ", pColor='" + pColor + '\'' +
                ", pDescription='" + pDescription + '\'' +
                ", pComposition='" + pComposition + '\'' +
                ", category=" + category +
                '}';
    }

}

package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MatchTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 10)
    @NotNull
    private String mJacket;
    @NotNull
    private String mTrousers;

    @ManyToOne //wiele produktów (garniturów) do jednej kategorii
    private Suits suits; //TO BĘDZIE TRZEBA PRZEROBIĆ NA PRODUCTS


}

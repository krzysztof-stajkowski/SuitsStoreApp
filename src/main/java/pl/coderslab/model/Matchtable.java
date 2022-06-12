package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Matchtable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 10)
    private String mName;

    public List<Suits> getSuits() {
        return suits;
    }

    public void setSuits(List<Suits> suits) {
        this.suits = suits;
    }

    @OneToMany (mappedBy = "matchtable") //nie tworzymy kolejnej tabeli mapującej (aby mapowanie zadziałało muszą być getery i settery i relacje po obu stronach)
    private List<Suits> suits = new ArrayList<>(); //gdy chcę pobrać listę unikatowych produktów

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "Matchtable{" +
                "id=" + id +
                ", mName='" + mName + '\'' +
                ", suits=" + suits +
                '}';
    }
}

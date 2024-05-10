package aplikacja.crud.pracownik;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="pracownik")
public class Pracownik implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pracownika;

    @Column(name="imie")
    private String imie;

    @Column(name="nazwisko")
    private String nazwisko;

    @Column(name="data_zatrudnienia")
    private LocalDate dataZatrudnienia;

    @Column(name="id_stanowiska")
    private Integer id_stanowiska;

    public Pracownik(){}
    public Pracownik(String imie, String nazwisko, LocalDate dataZatrudnienia, Integer id_stanowiska){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZatrudnienia = dataZatrudnienia;
        this.id_stanowiska = id_stanowiska;

    }

    public Integer getId() {
        return id_pracownika;
    }

    public void setId(Integer id) {
        this.id_pracownika = id;
    }

    public String getFirstname() {
        return imie;
    }

    public void setFirstname(String firstname) {
        this.imie = firstname;
    }

    public String getLastname() {
        return nazwisko;
    }

    public void setLastname(String lastname) {
        this.nazwisko = lastname;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public Integer getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(Integer id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }
}

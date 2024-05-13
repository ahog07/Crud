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
    private LocalDate data_zatrudnienia;

    @Column(name="id_stanowiska")
    private Integer id_stanowiska;

    public Pracownik(){}
    public Pracownik(String imie, String nazwisko, LocalDate data_zatrudnienia, Integer id_stanowiska){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_zatrudnienia = data_zatrudnienia;
        this.id_stanowiska = id_stanowiska;

    }

    public Integer getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(Integer id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(LocalDate data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public Integer getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(Integer id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }
}

// cos zbytecznego //
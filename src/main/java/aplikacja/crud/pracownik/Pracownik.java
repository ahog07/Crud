package aplikacja.crud.pracownik;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pracownik")
public class Pracownik implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pracownika;

    @DateTimeFormat(pattern = "yyyy-MM-dd")


    @Column(name="imie")
    private String imie;

    @Column(name="nazwisko")
    private String nazwisko;

    @Column(name="id_stanowiska")
    private Integer id_stanowiska;

    @Column(name="data_zatrudnienia")
    private Date data_zatrudnienia;


    public Pracownik() {}


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

    public Integer getId_stanowiska() {return id_stanowiska;}

    public void setId_stanowiska(Integer id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }


    public Date getData_zatrudnienia() {return data_zatrudnienia;}

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }


}

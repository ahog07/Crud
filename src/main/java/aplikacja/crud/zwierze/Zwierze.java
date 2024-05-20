package aplikacja.crud.zwierze;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="zwierze")
public class Zwierze implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_zwierzaka;

    @Column(name="id_gatunku")
    private Integer id_gatunku;

    @Column(name="imie")
    private String imie;

    @Column(name="id_pracownika")
    private Integer id_pracownika;

    @Column(name="wiekM")
    private BigDecimal wiekM;

    @Column(name="plec")
    private String plec;

    @Column(name="id_pawilonu")
    private Integer id_pawilonu;

    public Zwierze() {}


    public Integer getId_zwierzaka() {
        return id_zwierzaka;
    }

    public void setId_zwierzaka(Integer id_zwierzaka) {
        this.id_zwierzaka = id_zwierzaka;
    }

    public Integer getId_gatunku() {
        return id_gatunku;
    }

    public void setId_gatunku(Integer id_gatunku) {
        this.id_gatunku = id_gatunku;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Integer getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(Integer id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public BigDecimal getWiekM() {
        return wiekM;
    }

    public void setWiekM(BigDecimal wiekM) {
        this.wiekM = wiekM;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Integer getId_pawilonu() {
        return id_pawilonu;
    }

    public void setId_pawilonu(Integer id_pawilonu) {
        this.id_pawilonu = id_pawilonu;
    }
}

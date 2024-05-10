package aplikacja.crud.kontroler;

import aplikacja.crud.repozytorium.Repozytorium;

import aplikacja.crud.pracownik.Pracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class Kontroler {

    private final Repozytorium repozytorium;

    @Autowired
    public Kontroler(Repozytorium repozytorium){
        this.repozytorium = repozytorium;
    }

    @GetMapping("/pracownicy")
    public List<Pracownik> pracownicy(){
        return repozytorium.findAll();
    }
    @DeleteMapping("/pracownik/{id_pracownika}")
    public String usunPoId(@PathVariable("id_pracownika") int id_pracownika) {
        repozytorium.deleteById(id_pracownika);
        return "Rekord usunięty";
    }

    @PostMapping("/pracownikAdd")
    public Pracownik utworzPracownika(@RequestBody Map<String, String> body) {
        String imie = body.get("imie");
        String nazwisko = body.get("nazwisko");
        String dataZatrudnieniaStr = body.get("data_zatrudnienia");
        Integer id_stanowiska = Integer.parseInt(body.get("id_stanowiska"));

        LocalDate dataZatrudnienia = LocalDate.parse(dataZatrudnieniaStr);


        return repozytorium.save(new Pracownik(imie, nazwisko, dataZatrudnienia,id_stanowiska));
    }

    @GetMapping("/dodajTestowe")
    public String DaneTestowe() {

        LocalDate dataZatrudnienia1 = LocalDate.of(2019, 5, 12);
        LocalDate dataZatrudnienia2 = LocalDate.now();
        LocalDate dataZatrudnienia3 = LocalDate.of(2018, 4, 22);

        repozytorium.saveAll(List.of(
                new Pracownik("Adam","Kowalski",dataZatrudnienia1,01),
                new Pracownik("Eliza","Nowak",dataZatrudnienia2,02),
                new Pracownik("Bartosz","Kot",dataZatrudnienia3,01)
        ));

        return "Testowe rekordy dodane!";


    }
}

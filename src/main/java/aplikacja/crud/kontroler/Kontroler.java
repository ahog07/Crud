package aplikacja.crud.kontroler;

import aplikacja.crud.repozytorium.Repozytorium;
import aplikacja.crud.pracownik.Pracownik;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
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



    @GetMapping("/")
    public String showPracownikList(Model model){
        List<Pracownik> pracownikList = repozytorium.findAll();
        model.addAttribute("pracownikList", pracownikList);

        return "pracownikList";

    }

//    @DeleteMapping("/pracownikDel/{id_pracownika}")
//    public String usunPoId(@PathVariable("id_pracownika") int id_pracownika) {
//        repozytorium.deleteById(id_pracownika);
//        return "Rekord usunięty";
//    }

    @GetMapping("/delete/{id}")
    public String deletePracownik(@PathVariable Integer id) {
        repozytorium.deleteById(id);
        return "redirect:/";
    }



    @PostMapping("/updatePracownik")
    public String updatePracownik(@ModelAttribute Pracownik pracownik) {
        repozytorium.saveAndFlush(pracownik);
        return "redirect:/";
    }

    @GetMapping("/editPracownik/{id}")
    public String editPracownik(@PathVariable Integer id, Model model) {
        Pracownik pracownik = repozytorium.getById(id);
        model.addAttribute("pracownik", pracownik);
        return "editPracownik";

    }
//
//    @PostMapping("/updatePracownik")
//    public String updatePracownik(@ModelAttribute Pracownik pracownik) {
//        repozytorium.saveAndFlush(pracownik);
//        return "redirect:/";
//    }

    @GetMapping ("/newPracownik")
    public String newPracownik(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);
        return "newPracownik";
    }

    @PostMapping("/savePracownik")
    public String savePracownik(@ModelAttribute Pracownik pracownik) {
        repozytorium.saveAndFlush(pracownik);
        return "redirect:/";
    }


//    @PostMapping("/pracownikAdd")
//    public Pracownik utworzPracownika(@RequestBody Map<String, String> body) {
//        String imie = body.get("imie");
//        String nazwisko = body.get("nazwisko");
//        String data_zatrudnieniaStr = body.get("data_zatrudnienia");
//        Integer id_stanowiska = Integer.parseInt(body.get("id_stanowiska"));
//
//        LocalDate data_zatrudnienia = LocalDate.parse(data_zatrudnieniaStr);
//
//
//        return repozytorium.save(new Pracownik(imie, nazwisko, data_zatrudnienia,id_stanowiska));
//    }

//    @PutMapping("/pracownikEdit/{id_pracownika}")
//    public Pracownik zmienPracownika(@RequestBody Map<String, String> body){
//        String imie = body.get("imie");
//        String nazwisko = body.get("nazwisko");
//        String data_zatrudnieniaStr = body.get("data_zatrudnienia");
//        Integer id_stanowiska = Integer.parseInt(body.get("id_stanowiska"));
//
//        LocalDate data_zatrudnienia = LocalDate.parse(data_zatrudnieniaStr);
//        return repozytorium.save(new Pracownik(imie, nazwisko, data_zatrudnienia,id_stanowiska));
//    }


    @GetMapping("/dodajTestowe")
    public String DaneTestowe() {

        LocalDate dataZatrudnienia1 = LocalDate.of(2019, 5, 12);
        LocalDate dataZatrudnienia2 = LocalDate.now();
        LocalDate dataZatrudnienia3 = LocalDate.of(2018, 4, 22);

        repozytorium.saveAll(List.of(
                new Pracownik("Adam","Kowalski",dataZatrudnienia1,1),
                new Pracownik("Eliza","Nowak",dataZatrudnienia2,2),
                new Pracownik("Bartosz","Kot",dataZatrudnienia3,1)
        ));

        return "Testowe rekordy dodane!";


    }
}

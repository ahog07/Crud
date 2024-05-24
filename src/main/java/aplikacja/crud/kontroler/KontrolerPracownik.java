package aplikacja.crud.kontroler;

import aplikacja.crud.pawilon.Pawilon;
import aplikacja.crud.repozytorium.RepozytoriumPracownik;
import aplikacja.crud.pracownik.Pracownik;

import aplikacja.crud.stanowisko.Stanowisko;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Controller
public class KontrolerPracownik {

    private final RepozytoriumPracownik repozytoriumPracownik;

    @Autowired
    public KontrolerPracownik(RepozytoriumPracownik repozytoriumPracownik) {
        this.repozytoriumPracownik = repozytoriumPracownik;
    }

    @GetMapping("/pracownik")
    public String showPracownikList(Model model) {
        List<Pracownik> pracownikList = repozytoriumPracownik.findAll();
        model.addAttribute("pracownikList", pracownikList);
        return "pracownikList";
    }

//    @GetMapping("/pracownik/{id}")
//    public String showPracownikDetails(@PathVariable Integer id, Model model) {
//        Pracownik pracownik = repozytoriumPracownik.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid pracownik ID: " + id));
//        model.addAttribute("pracownik", pracownik);
//        return "pracownik";
//    }

    @GetMapping("/pracownik/new")
    public String newPracownik(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);
        return "newPracownik";
    }

    @PostMapping("/savePracownik")
    public String savePracownik(@ModelAttribute Pracownik pracownik) {
        repozytoriumPracownik.saveAndFlush(pracownik);
        return "redirect:/pracownik";
    }

    @GetMapping("/pracownik/edit/{id_pracownika}")
    public String editPracownik(@PathVariable("id_pracownika") Integer id_pracownika, Model model) {
        Pracownik pracownik = repozytoriumPracownik.findById(id_pracownika).orElseThrow(() -> new IllegalArgumentException("Invalid pracownik Id:" + id_pracownika));
        model.addAttribute("pracownik", pracownik);
        return "editPracownik";
    }

//    @GetMapping("/pracownik/edit/{id_pracownika}")
//    public String showEditPracownikForm(@PathVariable Integer id_pracownika, Model model) {
//        Pracownik pracownik = repozytoriumPracownik.findById(id_pracownika)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid pracownik ID: " + id_pracownika));
//        model.addAttribute("pracownik", pracownik);
//        return "editPracownik";
//    }

    @PostMapping("/pracownik/update/{id_pracownika}")
    public String updatePracownik(@PathVariable("id_pracownika") Integer id_pracownika, @ModelAttribute Pracownik pracownik, Model model) {
        pracownik.setId_pracownika(id_pracownika);
        repozytoriumPracownik.save(pracownik);
        return "redirect:/pracownik";
    }

    @GetMapping("/deletePracownik/{id}")
    public String deletePracownik(@PathVariable Integer id) {
        repozytoriumPracownik.deleteById(id);
        return "redirect:/pracownik";
    }
}
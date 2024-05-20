package aplikacja.crud.kontroler;

import aplikacja.crud.repozytorium.RepozytoriumPracownik;
import aplikacja.crud.pracownik.Pracownik;

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

    @GetMapping("/pracownik/{id}")
    public String showPracownikDetails(@PathVariable Integer id, Model model) {
        Pracownik pracownik = repozytoriumPracownik.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pracownik ID: " + id));
        model.addAttribute("pracownik", pracownik);
        return "pracownikDetails";
    }

    @GetMapping("/pracownik/new")
    public String showNewPracownikForm(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);
        return "newPracownik";
    }

    @PostMapping("/pracownik/save")
    public String savePracownik(@ModelAttribute("pracownik") Pracownik pracownik) {
        repozytoriumPracownik.save(pracownik);
        return "redirect:/pracownik";
    }

    @GetMapping("/pracownik/edit/{id_pracownika}")
    public String showEditPracownikForm(@PathVariable Integer id_pracownika, Model model) {
        Pracownik pracownik = repozytoriumPracownik.findById(id_pracownika)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pracownik ID: " + id_pracownika));
        model.addAttribute("pracownik", pracownik);
        return "editPracownik";
    }

    @PostMapping("/pracownik/update/{id_pracownika}")
    public String updatePracownik(@PathVariable Integer id_pracownika, @ModelAttribute("pracownik") Pracownik pracownik) {
        pracownik.setId_pracownika(id_pracownika);
        repozytoriumPracownik.save(pracownik);
        return "redirect:/pracownik";
    }

    @GetMapping("/pracownik/delete/{id_pracownika}")
    public String deletePracownik(@PathVariable Integer id_pracownika) {
        repozytoriumPracownik.deleteById(id_pracownika);
        return "redirect:/pracownik";
    }
}
package aplikacja.crud.kontroler;

import aplikacja.crud.pawilon.Pawilon;
import aplikacja.crud.pracownik.Pracownik;
import aplikacja.crud.repozytorium.RepozytoriumPawilon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KontrolerPawilon {

    private final RepozytoriumPawilon repozytoriumPawilon;

    @Autowired
    public KontrolerPawilon(RepozytoriumPawilon repozytoriumPawiolon) {
        this.repozytoriumPawilon = repozytoriumPawiolon;
    }

    @GetMapping("/")
    public String showPawilonList(Model model) {
        List<Pawilon> pawilonList = repozytoriumPawilon.findAll();
        model.addAttribute("pawilonList", pawilonList);
        return "pawilonList";
    }

    @GetMapping("/deletePawilon/{id}")
    public String deletePawilon(@PathVariable Integer id) {
        repozytoriumPawilon.deleteById(id);
        return "redirect:/";
    }

    @GetMapping ("/newPawilon")
    public String newPawilon(Model model) {
        Pawilon pawilon = new Pawilon();
        model.addAttribute("pawilon", pawilon);
        return "newPawilon";
    }

    @PostMapping("/savePawilon")
    public String savePawilon(@ModelAttribute Pawilon pawilon) {
        repozytoriumPawilon.saveAndFlush(pawilon);
        return "redirect:/";
    }


}



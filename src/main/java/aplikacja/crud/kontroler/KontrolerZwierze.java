package aplikacja.crud.kontroler;

import aplikacja.crud.zwierze.Zwierze;
import aplikacja.crud.repozytorium.RepozytoriumZwierze;
import aplikacja.crud.gatunek.Gatunek;
import aplikacja.crud.repozytorium.RepozytoriumGatunek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KontrolerZwierze {

    private final RepozytoriumZwierze repozytoriumZwierze;
    private final RepozytoriumGatunek repozytoriumGatunek;

    @Autowired
    public KontrolerZwierze(RepozytoriumZwierze repozytoriumZwierze, RepozytoriumGatunek repozytoriumGatunek) {
        this.repozytoriumZwierze = repozytoriumZwierze;
        this.repozytoriumGatunek = repozytoriumGatunek;
    }

//    private final RepozytoriumZwierze repozytoriumZwierze;
//
//    @Autowired
//    public KontrolerZwierze(RepozytoriumZwierze repozytoriumZwierze) {
//        this.repozytoriumZwierze = repozytoriumZwierze;
//    }

    @GetMapping("/Zwierze")
    public String showZwierzeList(Model model) {
        List<Zwierze> zwierzeList = repozytoriumZwierze.findAll();
        model.addAttribute("zwierzeList", zwierzeList);
        return "zwierzeList";
    }

    @GetMapping("/deleteZwierze/{id}")
    public String deleteZwierze(@PathVariable Integer id) {
        repozytoriumZwierze.deleteById(id);
        return "redirect:/Zwierze";
    }

    @GetMapping("/newZwierze")
    public String newZwierze(Model model) {
        Zwierze zwierze = new Zwierze();
        model.addAttribute("zwierze", zwierze);

        // Pobierz listę wszystkich gatunków i przekaż do widoku
        List<Gatunek> gatunekList = repozytoriumGatunek.findAll();
        model.addAttribute("gatunekList", gatunekList);

        return "newZwierze";
    }
//    @GetMapping("/newZwierze")
//    public String newZwierze(Model model) {
//        Zwierze zwierze = new Zwierze();
//        model.addAttribute("zwierze", zwierze);
//        return "newZwierze";
//    }

    @PostMapping("/saveZwierze")
    public String saveZwierze(@ModelAttribute Zwierze zwierze) {
        repozytoriumZwierze.saveAndFlush(zwierze);
        return "redirect:/Zwierze";
    }

    @GetMapping("/editZwierze/{id_zwierzaka}")
    public String showEditZwierzeForm(@PathVariable("id_zwierzaka") Integer id_zwierzaka, Model model) {
        Zwierze zwierze = repozytoriumZwierze.findById(id_zwierzaka)
                .orElseThrow(() -> new IllegalArgumentException("Invalid zwierze id: " + id_zwierzaka));
        model.addAttribute("zwierze", zwierze);

        // Pobierz listę wszystkich gatunków i przekaż do widoku
        List<Gatunek> gatunekList = repozytoriumGatunek.findAll();
        model.addAttribute("gatunekList", gatunekList);

        return "editZwierze";
    }

    @PostMapping("/updateZwierze/{id_zwierzaka}")
    public String updateZwierze(@PathVariable("id_zwierzaka") Integer id_zwierzaka, @ModelAttribute Zwierze zwierze, Model model) {
        Zwierze existingZwierze = repozytoriumZwierze.findById(id_zwierzaka)
                .orElseThrow(() -> new IllegalArgumentException("Invalid zwierze id: " + id_zwierzaka));

        existingZwierze.setImie(zwierze.getImie());
        existingZwierze.setGatunek(zwierze.getGatunek());
//        existingZwierze.setId_gatunku(zwierze.getId_gatunku());
        existingZwierze.setId_pracownika(zwierze.getId_pracownika());
        existingZwierze.setWiekM(zwierze.getWiekM());
        existingZwierze.setPlec(zwierze.getPlec());
        existingZwierze.setId_pawilonu(zwierze.getId_pawilonu());

        repozytoriumZwierze.save(existingZwierze);
        return "redirect:/Zwierze";
    }
}

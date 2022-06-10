package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Dao.CategoryDao;
import pl.coderslab.Dao.SuitsDao;
import pl.coderslab.model.Category;
import pl.coderslab.model.Suits;

import javax.validation.Valid;
import java.util.Collection;



@Controller
@RequestMapping("/suits")
//@ResponseBody - z tym nie przechodzi do jsp
public class SuitsController {

    private final SuitsDao suitsDao;

    private final CategoryDao categoryDao;


    public SuitsController(SuitsDao suitsDao, CategoryDao categoryDao) {
        this.suitsDao = suitsDao;
        this.categoryDao = categoryDao;
    }

    @ModelAttribute("categoryList") //to musi być aby jsp mogło pobrac dane do selecta
    public Collection<Category> categoryList() {
        return this.categoryDao.getList(); //pobieram listę z bazy categorii ale w Dao uszczupliłem select tylko do name
    }

    @GetMapping
    @RequestMapping(value = "/add")
    public String saveSuits(Model model) { //trzeba zaimportować klasę Model
        model.addAttribute("suits", new Suits()); // klucz do jsp
        return "suitsAdd"; //link do jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveSuits(@Valid Suits suits, BindingResult result) { //trzeba zaimportować klasę Model

        if (result.hasErrors()) {
            return "suitsAdd"; //do jsp, a formularz zostaje wypełniony i wystarczy skorygowac
        }

        suits.setpName("Garnitur"); //ustawiam na twardo nazwę a reszta jest z formularza
        suits.setpAvailable(1); // 1 - dostępny na sprzedarz / na starcie jest 1. na zero można zmnienić w oddzielnej akcji
        suitsDao.save(suits);
        return "suitCrudSuccess"; //strona bazowa Suits z wyborem Crud
    }

    @GetMapping
    @RequestMapping(value = "/edit")
    public String editSuits(Model model) { //trzeba zaimportować klasę Model
        model.addAttribute("suits", new Suits()); // klucz do jsp
        return "suitsEdit"; //link do jsp
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editSuits(@Valid Suits suits, BindingResult result) {

        if (result.hasErrors()) {
            return "suitsEdit"; //do jsp, a formularz zostaje wypełniony i wystarczy skorygowac
        }

        Suits oldSuit = suitsDao.findById(suits.getId());
        oldSuit.setpAvailable(oldSuit.getpAvailable());
        oldSuit.setpModel(suits.getpModel());
        oldSuit.setpSize(suits.getpSize());
        oldSuit.setpColor(suits.getpColor());
        oldSuit.setpComposition(suits.getpComposition());
        oldSuit.setpDescription(suits.getpDescription());

        Category catNameEdit = categoryDao.findById(suits.getCategoryId());

        System.out.println("Nowy wpis id " + catNameEdit.getId());
        System.out.println("Stary wpis id " +oldSuit.getCategory().getId());

        System.out.println("Nowy wpis name " + catNameEdit.getName());
        System.out.println("Stary wpis name " +oldSuit.getCategory().getName());

        //Testy poniższe linie zwracają błędy
//        oldSuit.getCategory().setId(catNameEdit.getId());
//        oldSuit.getCategory().setName(catNameEdit.getName());

        suitsDao.update(oldSuit);
        return "suitCrudSuccess";
    }
    //-----------------------------
    @GetMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("suits", suitsDao.getList());
        return "suitsDel";
    }

    @GetMapping("/delete/{id}")  //na podstawie book z zajęć warjee29sh
    public String delete(@PathVariable long id) {
        Suits suitsDelId = suitsDao.findById(id);
        suitsDao.delete(suitsDelId);
        return "redirect:/suits/delete";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("suits", suitsDao.getList());
        return "suitsList";
    }

    //-----------------
    //MACZOWANIE
    /**
     * Maczowanie marynarek i spodni z tego samego modelu do pełnego garnituru /zdejmowanie ze stanu i wstawianie jako garnitur
     * Będzie można maczować spodnie z marynarką ale nie można rozparowac garnituru
     */


}

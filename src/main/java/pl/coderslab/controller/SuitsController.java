package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.Dao.CategoryDao;
import pl.coderslab.Dao.SuitsDao;
import pl.coderslab.model.Category;
import pl.coderslab.model.Suits;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


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
    public String saveSuits(Suits suits) { //trzeba zaimportować klasę Model
        suits.setpName("Garnitur"); //ustawiam na twardo nazwę a reszta jest z formularza
        suits.setpAvailable(1); // 1 - dostępny na sprzedarz - na starcie jest 1. na zero można zmnienić w oddzielnej akcji

        //Wyciągam za pomocą funkcji entityManager id wybrany z formularza i pobieram za jego pomocą Name z tabeli category
        //i dopisuję do obiektu suits brakujący element
        Category catName = categoryDao.findById(suits.getCategoryId());
        suits.setpCategory(catName.getName());

        suitsDao.save(suits);
        return "suits"; //strona bazowa Suits z wyborem Crud
    }

    @RequestMapping("/edit")
    public String editSuits() {
        Suits suits = suitsDao.findById(2l);
        suits.setpColor("Yellow");
        suitsDao.update(suits);
        return "edited";
    }

    /** Tu ma być:
     * Sprzedaż pomniejszająca stan magazynowy i obliczająca ceny w tabeli SOLD
     */

    @RequestMapping("/delete")
    public String deleteSuits() {
        Suits suits = suitsDao.findById(1l);
        suitsDao.delete(suits);
        return "deleted";
    }

    //to musi być GET
    @RequestMapping("/list")
    public String getSuitsList() {
        List<Suits> list = suitsDao.getList();
        return list.stream()
                .map(b -> b.getpName())
                .peek(s -> System.out.println(s))
                .collect(Collectors.joining(" ---- "));
    }

    //-----------------
    //MACZOWANIE
    /**
     * Maczowanie marynarek i spodni z tego samego modelu do pełnego garnituru /zdejmowanie ze stanu i wstawianie jako garnitur
     * Będzie można maczować spodnie z marynarką ale nie można rozparowac garnituru
     */


}

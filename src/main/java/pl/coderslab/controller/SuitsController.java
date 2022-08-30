package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.repository.*;
import pl.coderslab.model.Category;
import pl.coderslab.model.Suits;

import javax.validation.Valid;
import java.util.Collection;


@Controller
@RequestMapping("/suits")
//@ResponseBody - z tym nie przechodzi do jsp
public class SuitsController {

    private final SuitsRepository suitsRepository;

    private final CategoryRepository categoryRepository;

    private final MatchTableRepository MatchTableRepository;

    private final ProductListRepository productListRepository;

    private final ProductsRepository productsRepository;

    public SuitsController(SuitsRepository suitsRepository, CategoryRepository categoryRepository, MatchTableRepository matchTableRepository, ProductListRepository productListRepository, ProductsRepository productsRepository) {
        this.suitsRepository = suitsRepository;
        this.categoryRepository = categoryRepository;
        this.MatchTableRepository = matchTableRepository;
        this.productListRepository = productListRepository;
        this.productsRepository = productsRepository;
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
            return "suitsAdd"; //wraca do jsp, a formularz zostaje wypełniony i wystarczy skorygowac
        }

        suits.setpAvailable(1); // 1 - dostępny na sprzedarz / na starcie jest 1. na zero można zmnienić w oddzielnej akcji
        suitsRepository.save(suits);
        return "suitCrudSuccess"; //strona bazowa Suits z wyborem Crud
    }

    @GetMapping
    @RequestMapping(value = "/edit")
    public String editSuits(Model model) { //trzeba zaimportować klasę Model
        model.addAttribute("suitsList", suitsRepository.ListAllByProductName("Garnitur"));
        model.addAttribute("suits", new Suits()); // klucz do jsp
        return "suitsEdit"; //link do jsp
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editSuits(@Valid Suits suits, BindingResult result) {

        if (result.hasErrors()) {
            return "suitsEdit"; //do jsp, a formularz zostaje wypełniony i wystarczy skorygowac
        }

        Suits oldSuit = suitsRepository.findById(suits.getId());
        oldSuit.setpAvailable(oldSuit.getpAvailable());
        oldSuit.setpModel(suits.getpModel());
        oldSuit.setpSize(suits.getpSize());
        oldSuit.setpColor(suits.getpColor());
        oldSuit.setpComposition(suits.getpComposition());
        oldSuit.setpDescription(suits.getpDescription());


        Category catNameEdit = categoryRepository.findById(suits.getCategoryId());
        oldSuit.setCategory(catNameEdit); // po usunięciu kawałka kodu w Suits mogę edytować już category

        suitsRepository.update(oldSuit);
        return "suitCrudSuccess";
    }

    //-----------------------------
    @GetMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("suits", suitsRepository.ListAllByProductName("Garnitur")); //tylko garnitury
        return "suitsDel";
    }

    @GetMapping("/delete/{id}")  //na podstawie book z zajęć warjee29sh
    public String delete(@PathVariable long id) {
        Suits suitsDelId = suitsRepository.findById(id);
        suitsRepository.delete(suitsDelId);
        return "redirect:/suits/delete";
    }

//--------------
    @ModelAttribute("categoryList") //to musi być aby jsp mogło pobrac dane do selecta
    public Collection<Category> categoryList() {
        return this.categoryRepository.getList(); //pobieram listę z bazy categorii ale w Dao uszczupliłem select tylko do name
    }

    @ModelAttribute("AtrybutSuits") //mapping do JSP
    public Collection<Suits> findList() {
        return this.suitsRepository.findAllByProductName("Garnitur"); //pobieram listę z bazy głównej towarów które nie są garniturami
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("suitsList",
                suitsRepository.ListAllByProductName("Garnitur"));
        return "suitsList";
    }

    @GetMapping("/listbysize")
    public String list2(Model model) { //wykorzystanie dwóch zmiennych z dwóch tabel do filtrowania
        model.addAttribute("suitsListbysize",
                suitsRepository.findAllByProductSize("176/48", "Garnitur"));
        return "suitsFindModel";
    }

    //-----------------
    //WYSZUKIWANIE

    /**
     * Jak to zrobiłem:
     * Przekopiowałem rozwiązanie z dodawania garniturów do bazy aby mieć fundament i strukturę
     * Ustawiłem poniższe 3 metody w takiej kolejności jak są wywoływane 1.Get 2. JSP 3.POST
     * Modyfikując rozwiązanie pobierania wartości z kolumny z tabeli do selecta (Category) utworzyłem metodę w Dao która pobiera tylko rozmiawy
     * (Rozmiary te pobieram z bazy głównej ponieważ jeśli jakiegoś rozmiaru nie będzie to od razu wiadomo że garniturów nie ma i nie ma sensu listy wyświetlać)
     * Ostatecznie nie wychodziło mi przeniesienie wyniku do jsp finalnego i widziałem że Binding result jest szary.
     * Zamieniłem go po próbach/testach/i debugowaniu na Model który został utworzyny w pierwszej metodzie
     * Usunąłem @Valid bo tu nie ma co sprawdzać
     * i zadziałało!
     */

    @GetMapping
    @RequestMapping(value = "/search")
    public String searchSuits(Model model) { //trzeba zaimportować klasę Model
        model.addAttribute("suitsSearch", new Suits()); // klucz do jsp
        return "suitsSearch"; //link do jsp który pobiera dane z poniższej metody z atrybutem AtrybutSuitsSizes

        /**
         * Uwaga! Aby zadziałał Distinct i wyświetliła się lista rozwijana przez jsp należało usunąć z jsp
         * itemLabel="pSize"   itemValue="pSize"
         * i zostawić sam path i model attribute
         */

    }

    @ModelAttribute("AtrybutSuitsSizes") //mapping do JSP
    public Collection<Suits> findListSizes() {
        return this.suitsRepository.getSizes("Garnitur"); //pobieram listę z bazy głównej z samymi rozmiarami /posortowaną
            //JAK POBRAĆ UNIKATY TYLKO? - DISTINCT NIE DZIAŁA W TEJ FORMIE
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchSuits( Suits suits,Model model) { //trzeba zaimportować klasę Model

        String selectedSize = suits.getpSize();
        model.addAttribute("SizesList", suitsRepository.ListAllSuitsBySize(selectedSize,1));

        return "suitsFindModel"; //strona bazowa Suits z wyborem Crud
    }

//--------------------


}

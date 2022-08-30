package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.repository.*;
import pl.coderslab.model.Category;
import pl.coderslab.model.Productlist;
import pl.coderslab.model.Suits;

import javax.validation.Valid;
import java.util.Collection;


@Controller
@RequestMapping("/products")

public class ProductsController {

    private final SuitsRepository suitsRepository;

    private final CategoryRepository categoryRepository;

    private final MatchTableRepository MatchTableRepository;

    private final ProductListRepository productListRepository;

    private final ProductsRepository productsRepository;


    public ProductsController(SuitsRepository suitsRepository, CategoryRepository categoryRepository, MatchTableRepository matchTableRepository, ProductListRepository productListRepository, ProductsRepository productsRepository) {
        this.suitsRepository = suitsRepository;
        this.categoryRepository = categoryRepository;
        this.MatchTableRepository = matchTableRepository;
        this.productListRepository = productListRepository;
        this.productsRepository = productsRepository;
    }

    @GetMapping
    @RequestMapping(value = "/add")
    public String saveSuits(Model model) { //trzeba zaimportować klasę Model
        model.addAttribute("suits", new Suits()); // klucz do jsp - aby to działało w produktach musi być również nazwa suits nie products
        return "productsAdd"; //link do jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveSuits(@Valid Suits suits, BindingResult result) { //trzeba zaimportować klasę Model

        if (result.hasErrors()) {
            return "productsAdd"; //do jsp, a formularz zostaje wypełniony i wystarczy skorygowac
        }

        suits.setpAvailable(1); // 1 - dostępny na sprzedarz / na starcie jest 1. na zero można zmnienić w oddzielnej akcji
        suitsRepository.save(suits);
        return "productsCrudSuccess"; //strona bazowa Suits z wyborem Crud
    }

    @GetMapping
    @RequestMapping(value = "/edit")
    public String editProd(Model model) { //trzeba zaimportować klasę Model
        model.addAttribute("productNameList", productsRepository.findAllByProductNameExcept("Garnitur")); //atrybut do productListDuplicate.jsp
        model.addAttribute("suits", new Suits()); // klucz do jsp - musi być klucz PRODUCTS bo inaczej jest błąd bindowania
        return "productsEdit"; //link do jsp
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProd(@Valid Suits suits, BindingResult result) {

        if (result.hasErrors()) {
            return "productsEdit"; //do jsp, a formularz zostaje wypełniony i wystarczy skorygowac
        }

        Suits oldSuit = suitsRepository.findById(suits.getId());
        oldSuit.setpAvailable(oldSuit.getpAvailable());
        oldSuit.setpModel(suits.getpModel());
        oldSuit.setpSize(suits.getpSize());
        oldSuit.setpColor(suits.getpColor());
        oldSuit.setpComposition(suits.getpComposition());
        oldSuit.setpDescription(suits.getpDescription());

        Category catNameEdit = categoryRepository.findById(suits.getCategoryId());

        /**testy*/
        System.out.println("Nowy wpis id " + catNameEdit.getId());
        System.out.println("Stary wpis id " + oldSuit.getCategory().getId());
        System.out.println("Nowy wpis name " + catNameEdit.getName());
        System.out.println("Stary wpis name " + oldSuit.getCategory().getName());

        //nie moge zmieć relacji kategorii podczas eycji

        suitsRepository.update(oldSuit);
        return "productsCrudSuccess";
    }


    //-----------------------------
    @GetMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("products", productsRepository.findAllByProductNameExcept("Garnitur")); //tu musi być FILTR!!!!!!!!!!!!!!!
        return "productsDel";
    }

    @GetMapping("/delete/{id}")  //na podstawie book z zajęć warjee29sh
    public String delete(@PathVariable long id) {
        Suits suitsDelId = productsRepository.findById(id);
        suitsRepository.delete(suitsDelId);
        return "redirect:/products/delete";
    }

    //------------

    @ModelAttribute("AtrybutCategoryList") //mapping do JSP
    public Collection<Category> categoryList() {
        return this.categoryRepository.getList(); //pobieram listę z bazy categorii
    }

    @ModelAttribute("Atrybut") //mapping do JSP
    public Collection<Productlist> findList() { //Użyte w ProductAdd do select po nazwach
        return this.productListRepository.getListExceptSuits(1); //pobieram listę z bazy głównej towarów które nie są garniturami
    }

    @ModelAttribute("AtrybutProductNameList") //mapping do JSP
    public Collection<Productlist> findAllByProductNameExcept() {
        return this.productsRepository.findAllByProductNameExcept("Garnitur"); //pobieram listę z bazy głównej towarów które nie są garniturami
    }

    @ModelAttribute("AtrybutMarynarkiSpodnie") //mapping do JSP
    public Collection<Productlist> findListByProductNameExcept() {
        return this.productsRepository.findListByProductNameExcept("Garnitur"); //pobieram listę z bazy głównej towarów które nie są garniturami
    }

    @GetMapping("/list")
    public String list(Model model) {
        //model.addAttribute("suitsList", suitsDao.getList()); //100% z listy
        model.addAttribute("productNameList", productsRepository.findAllByProductNameExcept("Garnitur"));
        return "productsList";
    }

    //-----------------
    //MACZOWANIE
    /**
     * Maczowanie marynarek i spodni z tego samego modelu do pełnego garnituru /zdejmowanie ze stanu i wstawianie jako garnitur
     * Będzie można maczować spodnie z marynarką ale nie można rozparowac garnituru
     */


}

package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Dao.*;
import pl.coderslab.model.Category;
import pl.coderslab.model.ProductList;
import pl.coderslab.model.Suits;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/products")

public class ProductsController {

    private final SuitsDao suitsDao;

    private final CategoryDao categoryDao;

    private final MatchTableDao MatchTableDao;

    private final ProductListDao productListDao;

    private final ProductsDao productsDao;


    public ProductsController(SuitsDao suitsDao, CategoryDao categoryDao, MatchTableDao matchTableDao, ProductListDao productListDao, ProductsDao productsDao) {
        this.suitsDao = suitsDao;
        this.categoryDao = categoryDao;
        this.MatchTableDao = matchTableDao;
        this.productListDao = productListDao;
        this.productsDao = productsDao;
    }

    @GetMapping
    @RequestMapping(value = "/add")
    public String saveSuits(Model model) { //trzeba zaimportować klasę Model
        model.addAttribute("products", new Suits()); // klucz do jsp
        return "productsAdd"; //link do jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveSuits(@Valid Suits suits, BindingResult result) { //trzeba zaimportować klasę Model

        if (result.hasErrors()) {
            return "productsAdd"; //do jsp, a formularz zostaje wypełniony i wystarczy skorygowac
        }

        suits.setpAvailable(1); // 1 - dostępny na sprzedarz / na starcie jest 1. na zero można zmnienić w oddzielnej akcji
        suitsDao.save(suits);
        return "suitCrudSuccess"; //strona bazowa Suits z wyborem Crud
    }


    //-----------------------------
    @GetMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("products", suitsDao.getList()); //tu musi być FILTR!!!!!!!!!!!!!!!
        return "productsDel";
    }

    @GetMapping("/delete/{id}")  //na podstawie book z zajęć warjee29sh
    public String delete(@PathVariable long id) {
        Suits suitsDelId = suitsDao.findById(id);
        suitsDao.delete(suitsDelId);
        return "redirect:/products/delete";
    }

    //------------

    @ModelAttribute("AtrybutCategoryList") //to musi być aby jsp mogło pobrac dane do selecta
    public Collection<Category> categoryList() {
        return this.categoryDao.getList(); //pobieram listę z bazy categorii ale w Dao uszczupliłem select tylko do name
    }

    @ModelAttribute("AtrybutProductNameList") //to musi być aby jsp mogło pobrac dane do selecta
    public Collection<ProductList> findAllByProductNameExcept() {
        return this.productsDao.findAllByProductNameExcept("Garnitur"); //pobieram listę z bazy głównej towarów które nie są garniturami
    }

    @GetMapping("/list")
    public String list(Model model) {
        //model.addAttribute("suitsList", suitsDao.getList()); //100% z listy
        model.addAttribute("productNameList", productsDao.findAllByProductNameExcept("Garnitur"));
        return "productsList";
    }

    //-----------------
    //MACZOWANIE
    /**
     * Maczowanie marynarek i spodni z tego samego modelu do pełnego garnituru /zdejmowanie ze stanu i wstawianie jako garnitur
     * Będzie można maczować spodnie z marynarką ale nie można rozparowac garnituru
     */


}

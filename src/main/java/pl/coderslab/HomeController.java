package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Dao.ProductDao;
import pl.coderslab.Dao.SoldDao;

@Controller
public class HomeController {

    private final ProductDao productDao;
    private final SoldDao soldDao;

    public HomeController(ProductDao productDao, SoldDao soldDao) {
        this.productDao = productDao;
        this.soldDao = soldDao;
    }


    @GetMapping("/")
    //@ResponseBody // -> jest niepotrzebne bo jest już home czyli home .jsp
    public String hello() {
        return "home";
    }

     @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "Here you can find some details"; }

    @GetMapping("/suits")
    @ResponseBody
    public String suitsMain() {
        return "Wybierz opcje crud garniturów"; }


}


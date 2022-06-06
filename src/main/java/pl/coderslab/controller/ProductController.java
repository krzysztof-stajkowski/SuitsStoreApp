package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Dao.ProductDao;
import pl.coderslab.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/product")
@ResponseBody
public class ProductController {

    private final ProductDao productDao;


    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping("/add")
    public String saveProduct() {
        Product product = new Product();
        product.setpColor("Blue");
        product.setpComposition("Cotton 100%");
        product.setpDescription("Suit");
        product.setpModel("25SS22BU");
        product.setpName("Suit");
        product.setpPrice(new BigDecimal(500)); //bo to obiekt
        product.setpSize("176/54");

        productDao.save(product);
        return "saved";
    }

    @RequestMapping("/edit")
    public String editProduct() {
        Product product = productDao.findById(2l);
        product.setpColor("Yellow");
        productDao.update(product);
        return "edited";
    }

    /**
     * Sprzedaż pomniejszająca stan magazynowy i obliczająca ceny w tabeli SOLD
     * oddzielna metoda sell
     */

    @RequestMapping("/delete")
    public String deleteProduct() {
        Product product = productDao.findById(1l);
        productDao.delete(product);
        return "deleted";
    }

    @RequestMapping("/list")
    public String getProductList() {
        List<Product> list = productDao.getList();
        return list.stream()
                .map(b -> b.getpName())
                .peek(s -> System.out.println(s))
                .collect(Collectors.joining(" ---- "));
    }

}

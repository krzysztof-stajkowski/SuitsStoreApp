package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    //@ResponseBody // -> jest niepotrzebne bo jest już home czyli home .jsp
    public String hello() {
        return "home";
    }

     @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "Here you can find some details"; }

    @GetMapping("/suits") // WWW tu trzeba ustawić stronę po starcie aby przeszło do pierwszego widoku
    public String suitsMain() {
        return "suits"; } //JSP

    @GetMapping("/products") // WWW tu trzeba ustawić stronę po starcie aby przeszło do pierwszego widoku
    public String productsMain() {
        return "products"; } //JSP

    @GetMapping("/findmodel") // WWW tu trzeba ustawić stronę po starcie aby przeszło do pierwszego widoku
    public String findSuitByModel() {
        return "/suits/listbymodel"; } //JSP

}


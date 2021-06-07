package kg.megacom.validation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

//    @GetMapping("/results")
//    public String showResults(PersonForm personForm) {
//        return "results";
//    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        System.out.println(personForm.getArrayList());

        return "redirect:/results";
    }

    @InitBinder // Данная аннотация нужна для чтого чтобы поступающие запросы валидировались через кастомный валидатор. В нашем случае все поступающие запросы "которые имеют отношения" к Date.class" проходят валдиацию через наш собственный валидатор DateEditor.class
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new DateEditor());
    }
}

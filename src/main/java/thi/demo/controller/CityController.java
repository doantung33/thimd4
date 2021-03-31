package thi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thi.demo.model.City;
import thi.demo.model.Country;
import thi.demo.service.city.ICityService;
import thi.demo.service.country.ICountryService;

import java.util.List;

@Controller
@RequestMapping("/citys")
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @GetMapping("")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("c",cityService.findAll());
        return modelAndView;
    }

    @ModelAttribute("listCountry")
    public List<Country> listC(){
        return countryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("c",new City());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute City city){
        ModelAndView modelAndView=new ModelAndView("redirect:/citys");
        cityService.save(city);
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public String formEdit(@PathVariable Long id, Model model){
        model.addAttribute("c",cityService.findById(id));
        return "/edit";
    }

    @PostMapping("edit/{id}")
    public ModelAndView edit(@ModelAttribute City city,@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/citys");
        city.setId(id);
        cityService.save(city);
        return modelAndView;
    }
    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/citys");
        cityService.remove(id);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable long id) {
        ModelAndView modelAndView=new ModelAndView("view");
        modelAndView.addObject("c",cityService.findById(id));
        return modelAndView;
    }


}

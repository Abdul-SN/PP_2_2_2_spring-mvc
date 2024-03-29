package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getFewCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        if (count >= 5) {
            model.addAttribute("cars", carService.getCars());
        } else {
            model.addAttribute("cars", carService.getFewCars(count));
        }
        return "cars";
    }
}

package guest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import guest.dto.testDTO;

@Controller
public class guestController {
 
    @RequestMapping(value= "/bodyTest", method = RequestMethod.GET)
    public @ResponseBody testDTO sayHello(@RequestBody testDTO model) {
    	
        return model;
    }
 
    @RequestMapping(value="/helloagain.do", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }
 
}
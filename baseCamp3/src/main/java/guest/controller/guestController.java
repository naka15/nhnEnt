package guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import guest.dto.testDTO;
import guest.dto.visitDTO;
import guest.service.IGuestService;

@Controller
public class guestController {
	
	@Autowired
	IGuestService guestService;
		
    @RequestMapping(value= "/bodyTest", method = RequestMethod.GET)
    public @ResponseBody testDTO sayHello(@RequestBody testDTO model) {
    	
        return model;
    }
 
    @RequestMapping(value="/add.do", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
    	
    	
        return "add";
    }
    
    //방명록 저장
    @RequestMapping(value="/save.do", method = RequestMethod.POST)
    public String save(HttpServletRequest request) {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String detail = request.getParameter("detail");
        visitDTO param = new visitDTO();
        param.setDetail(detail);
        param.setEmail(email);
        param.setPwd(pwd);
        guestService.save(param);
        
        return "list";
    }
    
    @RequestMapping(value="/main.do", method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request) {
    	
    	List<visitDTO> list = guestService.selectList();
    	ModelAndView mv = new ModelAndView();
    	
    	mv.addObject(list);
    	mv.setViewName("list");
    	
        return mv;
    }
}
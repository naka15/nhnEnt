package guest.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView sayHelloAgain(@RequestParam String email, @RequestParam String detail,  ModelMap model) {
    	
    	ModelAndView mv = new ModelAndView();
    	visitDTO visitObj = new visitDTO();
    	visitObj.setEmail(email);
    	visitObj.setDetail(detail);
    	mv.addObject("visit",visitObj);
    	mv.setViewName("add");
    	
        return mv;
    }
    
    //방명록 저장
    @RequestMapping(value="/save.do", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String detail = request.getParameter("detail");
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";   
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        
        ModelAndView mv = new ModelAndView();
        
        if(m.matches()){
        	visitDTO param = new visitDTO();
            param.setDetail(detail);
            param.setEmail(email);
            param.setPwd(pwd);
            guestService.save(param);
            
            List<visitDTO> list = guestService.selectList();
        	
        	
        	mv.addObject("list",list);
        	mv.setViewName("list");
        	
            return mv;
        }else{
        	mv.addObject("msg", new String("fail"));
        	mv.setViewName("add");
        	return mv;
        }
        
        
        

    }
    
    @RequestMapping(value="/main.do", method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request) {
    	
    	List<visitDTO> list = guestService.selectList();
    	ModelAndView mv = new ModelAndView();
    	
    	mv.addObject("list",list);
    	mv.setViewName("list");
    	
        return mv;
    }
    
/*    @RequestMapping(value="/getList.do", method = RequestMethod.POST)
    public ModelAndView getList(HttpServletRequest request) {
    	
    	List<visitDTO> list = guestService.selectList();
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("list", list);
        return mv;
    }*/
}
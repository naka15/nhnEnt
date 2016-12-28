package com.twoyears.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.dto.Paging;
import com.twoyears.model.dto.RequestDTO;
import com.twoyears.model.request.RequestServiceInterface;

@Controller
public class RequestListController {
	
	@Autowired
	private RequestServiceInterface service;
	
	@RequestMapping("request_notice.do")
	public ModelAndView request(String pageNo, String searchopt, String searchtext){
		String str="request_notice";
		List<RequestDTO> notice=new ArrayList<RequestDTO>();
		ModelAndView mv = new ModelAndView();
		Paging paging = new Paging();
		int totalCount;
		if(pageNo==null){
        paging.setPageNo(1);
		}
		else{
	        paging.setPageNo(Integer.parseInt(pageNo));
		}
		int pagenum=paging.getPageNo();
        int low=(pagenum-1)*10+1;
        int high=low+9;
  
        System.out.println("searchopt--------------"+searchopt);
        
        if(searchopt!=null){
        try {
			searchtext = new String(searchtext.getBytes("8859_1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        System.out.println("searchtext-------------"+searchtext);
        
       
		if(searchopt!=null && searchopt.equals("title")){
								        
			System.out.println("여기 들어왔냐고");
			notice=service.selectByTitle(searchtext,low,high);
			totalCount=service.selectByTitleCount(searchtext);
			mv.addObject("searchopt",searchopt);
			mv.addObject("searchtext",searchtext);
			
		}
		else if(searchopt!=null&&searchopt.equals("content")){
			notice=service.selectByContent(searchtext,low,high);
			totalCount=service.selectByContentCount(searchtext);
			mv.addObject("searchopt",searchopt);
			mv.addObject("searchtext",searchtext);
			
		}
		else if(searchopt!=null&&searchopt.equals("user")){
			notice=service.selectByUser(searchtext,low,high);
			totalCount=service.selectByUserCount(searchtext);
			mv.addObject("searchopt",searchopt);
			mv.addObject("searchtext",searchtext);
			
		}else{
			System.out.println("else로 들어옴");
			notice=service.selectByRownum(low, high);
			totalCount=service.selectCount();
			
		}
		
		paging.setPageSize(10);
        paging.setTotalCount(totalCount);
        
        mv.addObject("request",notice);
        mv.addObject("paging",paging);
		mv.addObject("str",str);
		mv.setViewName("request_notice");
		
		return mv;
	}
	
}

package com.lxt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxt.model.Dictionary;
import com.lxt.service.ServiceException;
import com.lxt.service.DictionaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionrayController extends BaseController{
	@Autowired
    private DictionaryService dictionaryService;

	@RequestMapping("/queryAll")
	public void getDictionary(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Dictionary> list = dictionaryService.queryAll();
			System.out.println(list.size());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
}

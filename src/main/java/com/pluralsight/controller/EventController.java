package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pluralsight.model.Event;

@Controller
@SessionAttributes("event")	//add the name of the object which we want to bound to the session, this will bound the event to the session in the processEvent function argument
public class EventController {

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String displayEventPage(Model model){
		Event event = new Event();
		event.setName("Java User Group");
		model.addAttribute("event", event);
		
		return "event";
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String processEvent(@ModelAttribute("event") Event event){
		System.out.println(event);
		
		//Since event is a SessionAttribute the event will live after the redirect, otherwise It would not
		return "redirect:index.html";	//redirect changes the url in the browser to index.html, forward does not do this
	}
	
}

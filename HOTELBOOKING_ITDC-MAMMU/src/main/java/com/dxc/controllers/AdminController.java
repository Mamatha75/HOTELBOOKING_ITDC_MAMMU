package com.dxc.controllers;

import java.text.ParseException;
import java.util.List;



import javax.servlet.RequestDispatcher;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dxc.pojos.Admin;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.service.AdminService;


@Controller
public class AdminController {
	AdminService adminsevice=new AdminService();
	String msg;
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";

	}
	@RequestMapping("/admin")
	public String adminLogin(@ModelAttribute Admin admin,Model model)
	{
		String aid=admin.getAdminid();
		String apass=admin.getAdminpass();

		boolean b=adminsevice.adminLogin(aid,apass);
		if(b==true) {

			return "adminmenu.jsp";
		}
		else {
			
            msg="ADMIN LOGIN UNSUCCESSFULLY";
			model.addAttribute("msg", msg);
			return "msg.jsp";
		}

	}
@RequestMapping("/addhotel")
public String addHotel(@ModelAttribute Hotel hotel,Model model) {
	
	System.out.println("jjjjjj");
	boolean b=adminsevice.addHotel(hotel);
	if(b==true) {
		msg="ADD HOTEL DETAILS SUCCESS";
	}
	else
	{
		msg="ADD HOTEL DETAILS UNSUCCESS";
	}
	model.addAttribute("msg", msg);
	return "msg.jsp";
	
}
@RequestMapping("/showlisthotel")
public String showHotels(@ModelAttribute Hotel hotel,Model model) {
	System.out.println(">>>>>>>>>");
	List<Document> list=adminsevice.showHotels(hotel);
	model.addAttribute("list", list);
	return "show.jsp";
	
	
	
}
@RequestMapping("/dailybook")
public String dailybooking(@RequestParam String bookeddate,@ModelAttribute Booking booking,Model model) throws ParseException {
	
	List<Document> list=adminsevice.dailybooking(bookeddate,booking);
	model.addAttribute("list", list);
	return "adminbook.jsp";

}

@RequestMapping("/admincancel")
public String cancelOnRequest(@ModelAttribute Booking booking, Model m) {
boolean b = adminsevice.cancelOnRequest(booking);
msg = "ADMIN CANCEL USER BOOKING";
m.addAttribute("msg",msg);
return "msg.jsp";
}


}

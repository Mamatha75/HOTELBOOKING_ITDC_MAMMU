package com.dxc.controllers;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.pojos.User;
import com.dxc.service.AdminService;
import com.dxc.service.UserService;

@Controller
public class UserController {
	UserService usersevice=new UserService();
	Hotel hotel;
	String msg;
	String userid;
	String userrroms;
	String fromdate;
	String todate;
	String bookeddate;
	Booking booking=new Booking();
	
	private String p;
	private String uphn = null;
    private String uname = null;
    private String ro = null;

	@RequestMapping("/newuserlogin")
	public String newuserLogin(@ModelAttribute User user,Model model) {
		this.p=user.getUserphnno();
		System.out.println(user.getUserphnno());
		boolean b=usersevice.userLogin(user);
		if(b==true) {
			msg="NEW USER ADDED SUCCESSFULLY";

		}
		else {
			msg="NEW USER ADDED UNSUCCESSFULLY";
		}
		model.addAttribute("msg", msg);
		return "msg.jsp";


	}
	@RequestMapping("/user")
	public String userLogin(@ModelAttribute User user,Model model,HttpSession session)
	{
		String userphnno=user.getUserphnno();
		session.setAttribute("userphnno", userphnno);
		String userpass=user.getUserpass();
		System.out.println("lllllllllllllllllllllllllllllll");
		boolean b=usersevice.existuserLogin(userphnno,userpass);
		if(b==true) {

			return "userMenu.jsp";
		}
		else {
			msg="USER LOGIN UNSUCCESSFULLY";

			model.addAttribute("msg", msg);
			return "msg.jsp";
		}

	}
	@RequestMapping("/viewhotels")
	public String usershowHotels(@ModelAttribute Hotel hotel,Model model) {
		System.out.println(">>>>>>>>>");
		List<Document> list=usersevice.usershowHotels(hotel);
		model.addAttribute("list", list);
		return "viewhotel.jsp";



	}
	@RequestMapping("/userbookroom")
	public String userbookroom(@ModelAttribute Hotel hotel,Model model) {
		this.hotel=hotel;
		model.addAttribute("hotel", hotel);
		return "bookroom.jsp";


	}
	@RequestMapping("/conformbooking")
	public String userbook(@ModelAttribute User user,@RequestParam String userid,@RequestParam String fromdate,@RequestParam String todate,@RequestParam String bookeddate,@RequestParam String userrroms,Model model) throws ParseException {

		this.userid=userid;
		this.fromdate=fromdate;
		this.todate=todate;
		this.bookeddate=bookeddate;
		this.userrroms=userrroms;
        this.ro=userrroms;
		int givenrooms=Integer.parseInt(userrroms);
		int allrooms=Integer.parseInt(hotel.getHotelrooms());

		booking.setUserid(userid);
		booking.setFromdate(fromdate);
		booking.setTodate(todate);
		booking.setBookeddate(bookeddate);
		booking.setUserrroms(userrroms);
System.out.println(user.getUsername());
System.out.println(user.getUserphnno());

		SimpleDateFormat sdformat = new SimpleDateFormat("MM-dd-yyyy");
		Date from = sdformat.parse(fromdate);
		Date to = sdformat.parse(todate);
		Date sys = sdformat.parse(bookeddate);
		System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
		if (from.compareTo(sys) >= 0 && to.compareTo(sys) >= 0) {
			System.out.println("correct 1");
			if (to.compareTo(from) >= 0) {
				System.out.println("Correct 2");
				if ((givenrooms < allrooms)) {
					model.addAttribute("user", user);
					model.addAttribute("hotel", hotel);
					model.addAttribute("booking", booking);
					return "confirmbooking.jsp";
				} else {
					msg = "THESE MANY ROOMS ARE NOT AVAILABLE ";
					model.addAttribute("msg", msg);
				}
			} else {
				msg = "INVALID TODATE";
				model.addAttribute("msg", msg);
			}
		} else {
			msg = "INVALID FROMDATE";
			model.addAttribute("msg", msg);
		}
		return "msg.jsp";



	}

@RequestMapping("/confirmed")
public String confitmBooking(HttpSession session,@ModelAttribute Booking booking,@ModelAttribute Hotel hotel,@ModelAttribute User user,Model model) {
	String un = uname;
    String id = uphn;
    //String phn=p;
    String r = ro;
    String phn=(String) session.getAttribute("userphnno");
	boolean b=usersevice.confitmBooking(booking,hotel,user,un,id,r,phn);
	if(b==true) {
		
	msg="confirmed booking";
	model.addAttribute("msg", msg);
	}
	return "msg.jsp";
	
}

@RequestMapping("/bookingsHistory")
public String bookingHistory(HttpSession session,@ModelAttribute Booking booking, Model m) {
	 String phn=(String) session.getAttribute("userphnno");
   // String id = uid;
    List<Document> list = usersevice.bookingHistory(booking, phn);
    m.addAttribute("list", list);
    return "BookingHistory.jsp";



}

@RequestMapping("/userGaveCancelRequest")
public String userGaveCancelRequest(@ModelAttribute Booking booking, Model m) {
//	System.out.println("usergave");
//	return "";
	
    boolean b = usersevice.userGaveCancelRequest(booking);
    if(b==true) {
    msg = "Request For Cancellation Successful";
    m.addAttribute("msg", msg);
    }
    return "msg.jsp";
}



}


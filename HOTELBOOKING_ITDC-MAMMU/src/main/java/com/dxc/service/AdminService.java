package com.dxc.service;

import java.text.ParseException;
import java.util.List;



import org.bson.Document;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;


public class AdminService {
	AdminDao adminDao=new AdminDao();

	public boolean adminLogin(String aid, String apass) {
		
		return adminDao.adminLogin(aid,apass);
	}

	public boolean addHotel(Hotel hotel) {
		
		return adminDao.addHotel(hotel);
	}

	
	public List<Document> showHotels(Hotel hotel) {
		return adminDao.showHotels(hotel);
	}

	public List<Document> dailybooking(String bookeddate, Booking booking) throws ParseException {
		
		return adminDao.dailybooking(bookeddate,booking);
	}

	public boolean cancelOnRequest(Booking booking) {
		
		return adminDao.cancelOnRequest(booking);
	}

}

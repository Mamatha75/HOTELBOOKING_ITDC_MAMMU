package com.dxc.service;

import java.util.List;

import org.bson.Document;

import com.dxc.dao.AdminDao;
import com.dxc.dao.UserDao;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.pojos.User;

public class UserService {
	UserDao userDao=new UserDao();

	public boolean userLogin(User user) {
		
		return userDao.userLogin(user);
	}

	public boolean existuserLogin(String userphnno, String userpass) {
		
		return userDao.existuserLogin(userphnno,userpass);
	}

	public List<Document> usershowHotels(Hotel hotel) {
		
		return userDao.usershowHotels(hotel);
	}

	public boolean confitmBooking(Booking booking, Hotel hotel, User user, String un, String id, String r,String phn) {
		
		return userDao.confitmBooking(booking,hotel,user,un,id,r,phn);
	}

	public List<Document> bookingHistory(Booking booking, String phn) {
		
		return userDao.bookingHistory(booking,phn);
	}

	public boolean userGaveCancelRequest(Booking booking) {
		
		return userDao.userGaveCancelRequest(booking);
	}

	

	
}

package com.dxc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ch.qos.logback.core.pattern.ConverterUtil;


public class AdminDao {
	MongoClient mongoclient=new MongoClient("localhost",27017);

	MongoDatabase mongodatabase=mongoclient.getDatabase("itdc");

	public boolean adminLogin(String aid, String apass) {
		MongoCollection<Document>  collection=mongodatabase.getCollection("admin");

		List<Document> list=(List<Document>) collection.find().into(new ArrayList<>());
		//	List<Document> list= collection.find().into(new ArrayList<>());
		for (Document d : list) {
			String u=(String) d.get("adminid");
			String p=(String) d.get("adminpass");
			System.out.println("jaanu");
			if(aid.equals(u)&&apass.equals(p))
			{
				return true;

			}
		}

		return false;
	}

	public boolean addHotel(Hotel hotel) {

		MongoCollection<Document>  collection=mongodatabase.getCollection("hotel");
		List<Document> list= collection.find().into(new ArrayList<>());
		System.out.println("lllllllllllllllll");

		String hotelname=hotel.getHotelname();
		String hoteladdress=hotel.getHoteladdress();
		String hotelphnno=hotel.getHotelphnno();
		String hotelrooms=hotel.getHotelrooms();
		double hotelcost=hotel.getHotelcost();


		System.out.println("hotelname");

		for (Document d : list) {
			Document s1=new Document();
			//String h=(String) s1.get("hotelname");
			s1.append("hotelname", hotelname);
			s1.append("hoteladdress", hoteladdress);
			s1.append("hotelphnno", hotelphnno);
			s1.append("hotelrooms", hotelrooms);
			s1.append("hotelcost", hotelcost);

			collection.insertOne(s1);

			System.out.println("////");
			return true;
		}
		return false;
	}

	public List<Document> showHotels(Hotel hotel) {
		MongoCollection<Document>  collection=mongodatabase.getCollection("hotel");
		//List<Document> list= collection.find().into(new ArrayList<>());
		List<Document> list=new ArrayList<>();
		FindIterable<Document> cursor=collection.find();
		MongoCursor<Document> itr=cursor.iterator();
		while(itr.hasNext()) {
			Document d=itr.next();
			list.add(d);
		}

		return list;
	}

	public List<Document> dailybooking(String bookeddate, Booking booking) throws ParseException {

		Document d1 = new Document();
		d1.append("bookeddate", bookeddate);
		MongoCollection<Document>  collection=mongodatabase.getCollection("booking");
		List<Document> list = (List<Document>) collection.find(d1).into(new ArrayList<>());
		FindIterable<Document> cursor = collection.find();
		MongoCursor<Document> itr = cursor.iterator();
		while(itr.hasNext()) {
			Document d = itr.next();
			String d2 = d.getString("bookeddate");

			if(bookeddate == d2) {
				list.add(d1);
			}
		}

      return list;
	}

	public boolean cancelOnRequest(Booking booking) {
		  MongoCollection<Document> mongoCollection = mongodatabase.getCollection("booking");
	        List<Document> documents = mongoCollection.find().into(new ArrayList<>());

	 

	        System.out.println(" cancel on rqst ------");
	        String status = "cancelled";
	      //  System.out.println(booking.getBookedDate()+" "+booking.getUserid());
	        
	        Document refno = new Document();
	        refno.append("bookeddate", booking.getBookeddate());
	        refno.append("userid", booking.getUserid());
	        refno.append("userphnno", booking.getUserphnno());

	 

	        Document d1 = new Document();
	        d1.append("$set", new Document("status",status));
	        mongoCollection.updateOne(refno,d1);
	        return true;
	}
}


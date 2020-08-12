package com.dxc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.pojos.User;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class UserDao {
	MongoClient mongoclient = new MongoClient("localhost", 27017);

	MongoDatabase mongodatabase = mongoclient.getDatabase("itdc");

	public boolean userLogin(User user) {
		// mongodatabase.createCollection("user");
		// System.out.println("new collection created");
		MongoCollection<Document> collection = mongodatabase.getCollection("user");
		List<Document> list = collection.find().into(new ArrayList<>());

		String userphnno = user.getUserphnno();
		String username = user.getUsername();
		String userpass = user.getUserpass();

		for (Document d : list) {
			String u = (String) d.get("userphnno");
			// for(u=0;u<=d.le)

			if (u.equals(userphnno)) {
				return false;
			}
		}

		Document s1 = new Document();
		s1.append("userphnno", userphnno);
		s1.append("username", username);
		s1.append("userpass", userpass);
		collection.insertOne(s1);
		// mongodatabase.getCollection("user").insertOne(s1);
		return true;
		// }

	}

	public boolean existuserLogin(String userphnno, String userpass) {
		MongoCollection<Document> collection = mongodatabase.getCollection("user");

		List<Document> list = (List<Document>) collection.find().into(new ArrayList<>());
		// List<Document> list= collection.find().into(new ArrayList<>());

		FindIterable<Document> cursor = collection.find();
		MongoCursor<Document> itr = cursor.iterator();
		for (Document d1 : list) {
			while (itr.hasNext()) {
				Document d = itr.next();

				String u = (String) d.get("userphnno");
				System.out.println(u);

				String p = (String) d.get("userpass");
				System.out.println(p);

				if (userphnno.equals(u) && userpass.equals(p)) {
					return true;

				}
			}
		}

		return false;



	}


	public List<Document> usershowHotels(Hotel hotel) {
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

	public boolean confitmBooking(Booking booking, Hotel hotel, User user, String un, String id, String r,String phn) {
		Document d2 = new Document();
		d2.append("hotelrooms", r);
		MongoCollection<Document> collection = mongodatabase.getCollection("hotel");



		List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
		FindIterable<Document> cursor = collection.find();



		MongoCursor<Document> itr = cursor.iterator();
		System.out.println(hotel.getHotelname());
		System.out.println(hotel.getHotelrooms());
		while (itr.hasNext()) {
			Document d = itr.next();
			String dbName = d.getString("hotelname");


			if (hotel.getHotelname().equals(dbName)) {



				int userGivenRooms = Integer.parseInt(r);
				int hotelRooms = Integer.parseInt(d.getString("hotelrooms"));



				int finalRooms = hotelRooms - userGivenRooms;
				String fr = Integer.toString(finalRooms);



				Document o = new Document();
				o.append("hotelname", d.getString("hotelname"));



				Document u = new Document();
				u.append("$set", new Document("hotelrooms", fr));
				collection.updateOne(o, u);
				cursor = collection.find();
				itr = cursor.iterator();
				while (itr.hasNext()) {
					list.add(itr.next());
				}
			}
		}

		MongoCollection<Document> collection1 = mongodatabase.getCollection("booking");

		List<Document> list1 = (List<Document>) collection.find().into(new ArrayList<>());


		//	String user1=user.getUsername();
		String userphn1=phn;
		String userid1=booking.getUserid();
		String userrroms1=booking.getUserrroms();
		String hotelname1=hotel.getHotelname();
		String hoteladdress1=hotel.getHoteladdress();
		String hotelphnno1=hotel.getHotelphnno();
		double totcost1=booking.getHotelcost();
		String fromdate1=booking.getFromdate();
		String todate1=booking.getTodate();
		String bookeddate1=booking.getBookeddate();
		String status="booked";
		Document d1 = new Document();
		//d1.append("username", un);
		d1.append("userphnno", userphn1);
		d1.append("userid", userid1);
		d1.append("userrroms", r);
		d1.append("hotelname", hotelname1);
		d1.append("hoteladdress", hoteladdress1);
		d1.append("hotelphnno", hotelphnno1);
		d1.append("hotelcost", totcost1);
		d1.append("fromdate", fromdate1);
		d1.append("todate", todate1);
		d1.append("bookeddate", bookeddate1);
		d1.append("status", status);

		collection1.insertOne(d1);
		return true;
	}

	public List<Document> bookingHistory(Booking booking, String phn) {
		  Document d2 = new Document();
	        d2.append("userphnno", phn);

	 

	        MongoCollection<Document> collection = mongodatabase.getCollection("booking");

	 

	        List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
	        FindIterable<Document> cursor = collection.find();

	 

	        MongoCursor<Document> itr = cursor.iterator();

	 

	        while (itr.hasNext()) {
	            Document d = itr.next();
	            String d1 = d.getString("userphnno");

	 

	            if (phn == d1) {
	                list.add(d2);
	            }
	        }
	        return list;

	 
	}

	public boolean userGaveCancelRequest(Booking booking) {
		 
               MongoCollection<Document> mongoCollection = mongodatabase.getCollection("booking");
		        List<Document> documents = mongoCollection.find().into(new ArrayList<>());

		 

		        
		        String status = "requested";
		        System.out.println(booking.getBookeddate());
		        
		        Document refno = new Document();
		        refno.append("bookeddate", booking.getBookeddate());
//		        refno.append("userid", booking.getUserid());
                Document d1 = new Document();
		        d1.append("$set", new Document("status",status));
		        mongoCollection.updateOne(refno,d1);
		        return true;
		    }
	}





//"userphnno":"99999",
//"userid":"99999",
//"userrroms":"9",
//"hotelname":"Hotel9",
//"hoteladdress":"add9";
//"hotelphnno":"9999999"
//"hotelcost":50,
//"fromdate":"20-08-2020",
//"todate":"22-08-2020",
//"bookeddate":"20-08-2020"

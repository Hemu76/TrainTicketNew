package ticketBooking;

import java.util.ArrayList;

public class BookingServletFunction {
	public double calFare(String[] age,String cls) {
		double acfare=2000.0;
		double slpfare=1500.0;
		double genfare=1000.0;
		double ofare=0.0;
		for(int i=0;i<age.length;i++) {
			if(cls=="AC" && Integer.parseInt(age[i])<60) {
				acfare=acfare-acfare%20;
				ofare+=acfare;
			}
			else if(cls=="AC" && Integer.parseInt(age[i])>60) {
				acfare=acfare-acfare%40;
				ofare+=acfare;
			}
			else if(cls=="Sleeper" && Integer.parseInt(age[i])<60) {
				slpfare=slpfare-slpfare%20;
				ofare+=slpfare;
			}
			else if(cls=="Sleeper" && Integer.parseInt(age[i])>60) {
				slpfare=slpfare-slpfare%40;
				ofare+=slpfare;
			}
			else if(cls=="General" && Integer.parseInt(age[i])<60) {
				genfare=genfare-genfare%20;
				ofare+=genfare;
			}
			else{
				genfare=slpfare-genfare%40;
				ofare+=genfare;
			}
		}
		return ofare;
	}
	public Ticket tpassList(String from,String to,String train,String cls,String dt,String[] name,String[] age,String[] gender){
		ArrayList<Passengers> app=new ArrayList<>();
		for(int i=0;i<name.length;i++) {
			app.add(new Passengers(name[i],age[i],gender[i]));
		}
		Ticket t = new Ticket(from,to,train,cls,dt,app);
		return t;
	}
}

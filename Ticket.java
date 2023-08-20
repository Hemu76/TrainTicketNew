package ticketBooking;

import java.util.ArrayList;

public class Ticket {
	String from;
	String to;
	String train;
	String cls;
	String date;
	ArrayList<Passengers> ap;

	public Ticket(String from, String to, String train, String cls, String date,ArrayList<Passengers> ap) {
		super();
		this.from = from;
		this.to = to;
		this.train = train;
		this.cls = cls;
		this.date = date;
		this.ap=ap;
	}

	public ArrayList<Passengers> getAp() {
		return ap;
	}

	public void setAp(ArrayList<Passengers> ap) {
		this.ap = ap;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Ticket [from=" + from + ", to=" + to + ", train=" + train + ", cls=" + cls + ", date=" + date + ", ap="
				+ ap + "]";
	}
	
}

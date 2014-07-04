package global;

import java.util.ArrayList;

public class Entrance {
	
	private ArrayList<Meter> meters; //can be 0
	private ArrayList<Apartment> apartments;
	
//================================================================================
// other stuff, dont know nice name
//================================================================================
	@Override
	public String toString() {
		// TODO WORK IN PROGRESS need toString() implementation from atomic classes
		String output = "";
		for (int i = 0; i < apartments.size(); i++) {
			output += "Apartment: Nr." + i;
		}
		return output;
	}
	
//================================================================================
// test functions
//================================================================================
	public boolean add() {
		return true;
	}

	public boolean delete() {
		return true;
	}

	public int[] list(int id) {
		int[] i = null;
		return i;
	}

}
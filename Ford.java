package com.automobile.FourWheeler;

import com.automobile.Vehicle;

public class Ford extends Vehicle {

	@Override
	public String getModeName() {
		return  "roadway1";
	}

	@Override
	public String getReistrationNumber() {
		return "AP653254";
	}

	@Override
	public String getOwnerName() {
		return "Gopi";
	}
	public int getSpeed() {
		return 120;
	}
	
public void tempControl() {
	System.out.println("It provides facility to control the air conditioning device which is available in the car");
}
}
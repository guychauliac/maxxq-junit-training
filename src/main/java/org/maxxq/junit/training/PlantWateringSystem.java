package org.maxxq.junit.training;

public class PlantWateringSystem {

	private int hour;
	private float humidity;

	public boolean plantsNeedWater() {
		return hour >= 19 && humidity < 0.5;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
}

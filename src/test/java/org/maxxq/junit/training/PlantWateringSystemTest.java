package org.maxxq.junit.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlantWateringSystemTest {
	private PlantWateringSystem system;
	private boolean plantsAreWatered;

	@Test
	public void waterPlantsOnOrAfter7PM() {
		when().hourIs(18).andHumidityIs(0).then().plantsAreWatered(false);
		when().hourIs(19).andHumidityIs(0).then().plantsAreWatered(true);
		when().hourIs(20).andHumidityIs(0).then().plantsAreWatered(true);
	}

	@Test
	public void waterPlantsWhenHumidityLessThen50Percent() {
		when().hourIs(20).andHumidityIs(0.51F).then().plantsAreWatered(false);
		when().hourIs(20).andHumidityIs(0.50F).then().plantsAreWatered(false);
		when().hourIs(20).andHumidityIs(0.49F).then().plantsAreWatered(true);
	}

	private PlantWateringSystemTest when() {
		system = new PlantWateringSystem();
		return this;
	}

	private PlantWateringSystemTest hourIs(int hour) {
		this.system.setHour(hour);
		return this;
	}

	private PlantWateringSystemTest andHumidityIs(float humidity) {
		this.system.setHumidity(humidity);
		return this;
	}

	private PlantWateringSystemTest then() {
		this.plantsAreWatered = system.plantsNeedWater();
		return this;
	}

	private PlantWateringSystemTest plantsAreWatered(boolean expected) {
		assertEquals(expected, plantsAreWatered);
		return this;
	}
}

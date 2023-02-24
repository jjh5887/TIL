package chapter01.item03.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcertTest {

	@Test
	void perform() {
		Concert concert = new Concert(new MockElvis());
		concert.perform();

		assertTrue(concert.isLightsOn());
		assertTrue(concert.isMainStateOpen());
	}

}
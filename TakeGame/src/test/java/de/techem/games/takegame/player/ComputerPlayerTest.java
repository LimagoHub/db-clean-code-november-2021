package de.techem.games.takegame.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;
import de.techem.io.Writer;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerTest {

	@InjectMocks
	private ComputerPlayer objectUnderTest;
	
	@Mock
	private Writer writer;
	
	@Test
	void doTurn_divisionsRest0_returns3 () {
		assertEquals(3, objectUnderTest.doTurn(20));
		verify(writer,times(1)).write("Computer nimmt 3 Steine.");
	}
	@Test
	void doTurn_divisionsRest1_returns1() {
		assertEquals(1, objectUnderTest.doTurn(21));
		verify(writer,times(1)).write("Computer nimmt 1 Steine.");
	}

	@Test
	void doTurn_divisionsRest2_returns1() {
		assertEquals(1, objectUnderTest.doTurn(22));
		verify(writer,times(1)).write("Computer nimmt 1 Steine.");
	}

	@Test
	void doTurn_divisionsRest3_returns2() {
		assertEquals(2, objectUnderTest.doTurn(23));
		verify(writer,times(1)).write("Computer nimmt 2 Steine.");
	}

}

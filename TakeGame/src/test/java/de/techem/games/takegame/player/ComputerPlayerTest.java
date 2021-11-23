package de.techem.games.takegame.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
	
	@ParameterizedTest
	@CsvSource({"20,3","21,1","22,1","23,2"})
	void doTurn_divisionsRest0_returns3 (int input, int expected) {

		assertEquals(expected, objectUnderTest.doTurn(input));
		verify(writer,times(1)).write("Computer nimmt "+ expected+ " Steine.");
	}


}

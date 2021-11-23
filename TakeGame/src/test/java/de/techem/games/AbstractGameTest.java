package de.techem.games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import de.techem.games.players.GamePlayer;
import de.techem.io.Writer;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AbstractGameTest {

	
	private boolean gameover;
	private boolean isvalid;
	
	private AbstractGameDummyForTest objectUnderTest;
	private Writer writerMock;
	private GamePlayer<DummyBoard, DummyTurn> playerMock;
	
	@BeforeEach
	public void init() {
		isvalid = true;
		gameover = false;
		
		playerMock = (GamePlayer<DummyBoard, DummyTurn>) mock(GamePlayer.class);
		writerMock = mock(Writer.class);
		
		objectUnderTest = new AbstractGameDummyForTest(writerMock);
		objectUnderTest.addPlayer(playerMock);
		when(playerMock.getName()).thenReturn("MockPlayer");
	}
	
	
	@Test
	void play_WhenGameOver_GameOverMessagePassedToWriter() {
		when(playerMock.doTurn(any(DummyBoard.class))).thenAnswer(a->{
			gameover = true;
			return new DummyTurn();
		});
		objectUnderTest.play();
		//verify(writerMock,times(1)).write("Spieler MockPlayer ist am Zug");
		verify(writerMock,times(1)).write("MockPlayer hat verloren");
	}
	@Test
	void play_WhenUngueltigerZug_ErrorMessageIsPassedToWriter() {
		//Arrange
		isvalid = false;
		when(playerMock.doTurn(any(DummyBoard.class))).thenAnswer(a->{
			gameover = true;
			return new DummyTurn();
		});
		doAnswer((Answer<Void> ) a ->{isvalid = true; return null;}).when(writerMock).write(anyString());
		
		// Act
		objectUnderTest.play();
		
		// Assert
		InOrder inOrder = inOrder(writerMock, playerMock);
		inOrder.verify(writerMock,times(1)).write("Ungueltiger Zug");
		inOrder.verify(writerMock,times(1)).write("MockPlayer hat verloren");
	
		
	}
	
	class AbstractGameDummyForTest extends AbstractGame<DummyBoard, DummyTurn> {

		public AbstractGameDummyForTest(Writer writer) {
			super(writer);
			board = new DummyBoard();
		}

		@Override
		protected boolean isGameOver() {
			return gameover;
		}

		@Override
		protected boolean isTurnValid() {
			
			return isvalid;
		}

		@Override
		protected void updateBoard() {
			// PAL ( Problem anderer Leute )
			
		}
		
	}

}

class DummyBoard {}
class DummyTurn{}

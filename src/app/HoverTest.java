package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HoverTest {

	private Hover hover;
	private Plateau plateau;
	
	@Before
	public void setUp(){
		plateau = new Plateau(5, 5);
	}
	
	@Test
	public void testTurnRight(){
		hover = new Hover(0, 0, Hover.N, plateau);
		hover.commandHover("R");
		assertEquals(Hover.E, hover.getCompass());
	}
	
	@Test
	public void testTurnLeft(){
		hover = new Hover(0, 0, Hover.N, plateau);
		hover.commandHover("L");
		assertEquals(Hover.W, hover.getCompass());
	}
	
	@Test
	public void testMoveNorth(){
		hover = new Hover(0, 0, Hover.N, plateau);
		hover.commandHover("M");
		assertEquals(1, hover.getY());
	}
	
	@Test
	public void testMoveSouth(){
		hover = new Hover(0, 1, Hover.S, plateau);
		hover.commandHover("M");
		assertEquals(0, hover.getY());
	}
	
	@Test
	public void testMoveWest(){
		hover = new Hover(1, 0, Hover.W, plateau);
		hover.commandHover("M");
		assertEquals(0, hover.getX());
	}
	
	@Test
	public void testMoveEast(){
		hover = new Hover(0, 0, Hover.E, plateau);
		hover.commandHover("M");
		assertEquals(1, hover.getX());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLeavePlateau(){
		hover = new Hover(0, 0, Hover.W, plateau);
		hover.commandHover("M");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCommand(){
		hover = new Hover(0, 0, Hover.W, plateau);
		hover.commandHover("J");
	}
	
	@Test
	public void hover1test() {
		hover = new Hover(1, 2, Hover.N, plateau);
		hover.commandHover("LMLMLMLMM");
		assertEquals(1, hover.getX());
		assertEquals(3, hover.getY());
		assertEquals(Hover.N, hover.getCompass());
	}
	
	@Test
	public void hover2test() {
		hover = new Hover(3, 3, Hover.E, plateau);
		hover.commandHover("MMRMMRMRRM");
		assertEquals(5, hover.getX());
		assertEquals(1, hover.getY());
		assertEquals(Hover.E, hover.getCompass());
	}

}

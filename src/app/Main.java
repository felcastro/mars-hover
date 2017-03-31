package app;

public class Main {

	public static void main (String[] args){
		Plateau plateau = new Plateau(5, 5);
		Hover hover1 = new Hover(1, 2, Hover.N, plateau);
		hover1.commandHover("LMLMLMLMM");
		System.out.println("Hover 1 coordinates: " + hover1.toString());
		Hover hover2 = new Hover(3, 3, Hover.E, plateau);
		hover2.commandHover("MMRMMRMRRM");
		System.out.println("Hover 2 coordinates: " + hover2.toString());
	}
}

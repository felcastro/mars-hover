package app;

public class Hover {
	private static final int N = 0;
	private static final int S = 1;
	private static final int E = 2;
	private static final int W = 3;
	
    private int x, y;
    private int compass;
    private Plateau plateau;
	
	public Hover(int x, int y, int compass, Plateau plateau){
		this.x = x;
		this.y = y;
		this.compass = compass;
		this.plateau = plateau;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void commandHover(String command){
		for(int i = 0; i < command.length(); i++){
			commandHover(command.charAt(i));
		}
	}
	
	public void commandHover(char command){
		switch(command){
		case 'L':
			left();
			break;
		case 'R':
			right();
			break;
		case 'M':
			forward();
			break;
		default:
			throw new IllegalArgumentException("Value can only be L, R or M!");
		}
	}

	private void forward() {
		switch(compass){
		case 'N':
			this.y++;
			break;
		case 'S':
			this.y--;
			break;
		case 'E':
			this.x++;
			break;
		case 'W':
			this.x--;
			break;
		default:
			break;
		}
	}

	private void right() {
		if(compass > W){
			compass = N;
		}else {
			compass++;
		}
	}

	private void left() {
		if(compass < N){
			compass = W;
		}else {
			compass--;
		}
	}
	
	public String toString(){
		String str = "X: " + x + "\nY: " + y + "\nFacing: " + compass;
		return str;
	}
}

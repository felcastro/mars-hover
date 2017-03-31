package app;

public class Hover {
	public static final int N = 0;
	public static final int S = 2;
	public static final int E = 1;
	public static final int W = 3;
	
    private int x, y;
    private int compass;
    private Plateau plateau;
	
	public Hover(int x, int y, int compass, Plateau plateau){
		if(x > plateau.getWidth() || x < 0 || y > plateau.getHeight() || y < 0){
			throw new IllegalArgumentException("Can't spawn outside of plateau!");
		}
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
	
	public int getCompass(){
		return compass;
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
		case N:
			if(y + 1 <= plateau.getHeight()){
				this.y++;
			}else {
				throw new IllegalArgumentException("Can't leave plateau!");
			}
			break;
		case S:
			if(y - 1 >= 0){
				this.y--;
			}else {
				throw new IllegalArgumentException("Can't leave plateau!");
			}
			break;
		case E:
			if(x + 1 <= plateau.getWidth()){
				this.x++;
			}else {
				throw new IllegalArgumentException("Can't leave plateau!");
			}
			break;
		case W:
			if(x - 1 >= 0){
				this.x--;
			}else {
				throw new IllegalArgumentException("Can't leave plateau!");
			}
			break;
		default:
			throw new IllegalArgumentException("Something went wrong!");
		}
	}

	private void right() {
		if(compass == W){
			compass = N;
		}else {
			compass++;
		}
	}

	private void left() {
		if(compass == N){
			compass = W;
		}else {
			compass--;
		}
	}
	
	private String compassToS(){
		String str;
		switch(compass){
		case N:
			str = "North";
			break;
		case S:
			str = "South";
			break;
		case W:
			str = "West";
			break;
		case E:
			str = "East";
			break;
		default:
			str = "Fail";
			break;
		}
		return str;
	}
	
	public String toString(){
		String str = "X: " + x + " | Y: " + y + " | Facing: " + compassToS();
		return str;
	}
}

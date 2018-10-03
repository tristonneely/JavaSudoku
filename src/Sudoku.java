
package src;

public class Sudoku{
	private final int width = 9; //define width and height of puzzle
	private final int height = 9;//(in case I need it for some reason, these should be unnecessary)
	static int puzzle[][] = new int[9][9];//create puzzle scenario
	int constraints[][] = new int[9][9];//array to define what numbers are allowed to go where
	/*
	 * I am storing the constraints as binary numbers.
	 * This will allow me to put "multiple" numbers in each cell of the arrays
	 * the numbering convention I will be using will be as follows:
	 * 0b000000000 (no numbers are taken, any number can currently be put here)
	 * 0b111111111 (all numbers are taken, this cell should not be empty at this time)
	 * I will use the far left digit in the constraint number to identify the number 9 in the cell's row, column, or box
	 * I will use the far right digit as the number 1, and will count down between the two
	 * 0b001011101 would allow the cell to be 2, 6, 8, or 9
	 */
	
	public static void main(String[] args){
		//TODO Get original puzzle from user input in GUI
		//TODO Place known puzzle into puzzle variable. Run updateConstraints and compare values to known values
		//Print constraint values to check them
	}
	public void updateConstraints(){ //this function will update the constraints, likely to be moved to new class later
		for(int i = 0; i < 9; i++){ //repeats for each column
			int tempConst = 0b000000000;
			//TODO THIS ONLY UPDATES FOR ROWS AND COLUMNS. THIS WILL NOT CHECK THE CELL'S BOX
			for(int j = 0; j < 9; j++){//repeats for each row
				if(puzzle[i][j] == 1){
					tempConst += 0b1;
				}
				if(puzzle[i][j] == 2){
					tempConst += 0b10;
				}
				if(puzzle[i][j] == 3){
					tempConst += 0b100;
				}
				if(puzzle[i][j] == 4){
					tempConst += 0b1000;
				}
				if(puzzle[i][j] == 5){
					tempConst += 0b10000;
				}
				if(puzzle[i][j] == 6){
					tempConst += 0b100000;
				}
				if(puzzle[i][j] == 7){
					tempConst += 0b1000000;
				}
				if(puzzle[i][j] == 8){
					tempConst += 0b10000000;
				}
				if(puzzle[i][j] == 9){
					tempConst += 0b100000000;
				}
				constraints[i][j] = constraints[i][j] | tempConst;//bitwise or operator keeps any instance of 1 in the constraint binary
			}
		}
	}
}

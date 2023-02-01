package boardgame;

public class Position {

	//Define row/column for piece movement
	private int row;
	private int column;
	
	//Define the class for the position
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	//Defining getters and setters
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setValues(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	//Method to print to screen the row/column
	@Override
	public String toString() {
		return row + " , " + column;
	}
}

package boardgame;

public abstract class Piece {

	//So this is not visible in chess layer
	//lets define it as protected (it's just a matrix position)
	protected Position position;
	
	//to define its position on the board
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	//only classes inside same packages and subclasses can access
	protected Board getBoard() {
		return board;
	}
	
	
}

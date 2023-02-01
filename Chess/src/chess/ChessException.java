package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {
	private static final long serialVersionUID = 1L;

	public ChessException(String msg)
	{
		//To pass the message to the super class constructor
		super(msg);
	}
}

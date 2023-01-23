package fifteenpuzzle;

import java.io.*;
import java.util.*;

public class FifteenPuzzle {
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;

	// size of board
	public final static int SIZE = 4;

	
	/**
	 * @param fileName 
	 * @throws FileNotFoundException if file not found
	 * @throws BadBoardException if the board is incorrectly formatted
	 * Reads a board from file and creates the board
	 */
	public FifteenPuzzle(String fileName) throws IOException, BadBoardException {
		// TODO implement me
	}

	
	/**
	 * Get the number of the tile, and moves it to the specified direction
	 * 
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(int tile, int direction) throws IllegalMoveException {
		// TODO implement me
	}

	
	/**
	 * @return true if and only if the board is solved,
	 * i.e., the board has all tiles in their correct positions
	 */
	public boolean isSolved() {
		// TODO implement me
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// TODO implement me
		return super.toString();
	}
}

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
	protected final static int ROW_LENGTH = 11;			// Row length in chars
	protected final static int SPACE_ASCII_CODE = 32;   // ASCII code for space

	protected int[][] board;

	
	/**
	 * @param fileName 
	 * @throws FileNotFoundException if file not found
	 * @throws BadBoardException if the board is incorrectly formatted
	 * Reads a board from file and creates the board
	 */
	public FifteenPuzzle(String fileName) throws IOException, BadBoardException, InputMismatchException{
		BadBoardException badBoardEx = new BadBoardException("Board is incorrectly formatted");
		int rowIdx = 0;
		boolean isSpace;
		char character;
		int ascii = 0;
		int[] asciiLine  = new int[11];

		File file = new File(fileName);
		Scanner reader = new Scanner(file);

		this.board = new int[SIZE][SIZE];

		while (reader.hasNext()) {					// Go row by row
			int index = 0;

			String line = reader.nextLine();
			if (line.length() != ROW_LENGTH) {		// line is more than 11 chars
				reader.close();
				throw badBoardEx;
			}

			for (int i=0; i < 11; i++) {			// Convert row to array of ascii values
				character = line.charAt(i);

				if (!Character.isWhitespace(character) && (!Character.isDigit(character))) {		// check that only spaces and digits
					reader.close();
					throw badBoardEx;
				}

				ascii = character;
				asciiLine[i] = ascii;
			}

			for (int i=2; i < 11; i+=3) {			// Check for 3 total spaces between digits
				if (asciiLine[i] != 32) {
					reader.close();
					throw badBoardEx;
				}
			}

			for (int i=1; i < 11; i+=3) {
				String strNum = null;
				int num;
				int firstDigit = asciiLine[i-1];
				int secondDigit = asciiLine[i];
				if (firstDigit == SPACE_ASCII_CODE && secondDigit == SPACE_ASCII_CODE) {
					strNum = Character.toString('0');
				} else if (firstDigit == SPACE_ASCII_CODE) {
					strNum = Character.toString(secondDigit);
				} else {
					strNum = Character.toString(firstDigit) + Character.toString(secondDigit);
				}
				num = Integer.parseInt(strNum);

				if (num > 15 || num < 0) {
					reader.close();
					throw badBoardEx;
				}

				this.board[rowIdx][index] = num;
				index += 1;

			}
			rowIdx += 1;						// Count rows

		}

		if (checkDuplicates(this.board)) {
			reader.close();
			throw badBoardEx;
		}

		if (rowIdx > SIZE) {
			reader.close();
			throw badBoardEx;
		}
		reader.close();
	}

	protected static boolean checkDuplicates(int[][] inputBoard) {
		List<Integer> boardNumList = new ArrayList<Integer>();
		for (int i=0; i < inputBoard.length; i++)
			for (int j=0; j < inputBoard[i].length; j++)
				boardNumList.add(inputBoard[i][j]);

		Set<Integer> boardNumSet = new HashSet<Integer>(boardNumList);
		if (boardNumSet.size() < boardNumList.size()) {
			return true;
		}
		return false;
	}

	/**
	 * Get the number of the tile, and moves it to the specified direction
	 * 
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(int tile, int direction) throws IllegalMoveException {
		IllegalMoveException illegalMoveEx = new IllegalMoveException("Illegal Move");
		int columnIdx = 0;
		int rowIdx = 0;

		if (tile > 15 || tile < 1) {		// Tile doesn't exist
			throw illegalMoveEx;
		}

		// Find position of tile
		for (int i=0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (tile == this.board[i][j]) {
					rowIdx = i;
					columnIdx = j;
				}
			}
		}

		if (!isMoveValid(rowIdx, columnIdx, direction)) {
			throw illegalMoveEx;
		}

		if (direction == UP) {
			this.board[rowIdx - 1][columnIdx] = this.board[rowIdx][columnIdx];
			this.board[rowIdx][columnIdx] = 0;
		} else if (direction == DOWN) {
			this.board[rowIdx + 1][columnIdx] = this.board[rowIdx][columnIdx];
			this.board[rowIdx][columnIdx] = 0;
		} else if (direction == RIGHT) {
			this.board[rowIdx][columnIdx + 1] = this.board[rowIdx][columnIdx];
			this.board[rowIdx][columnIdx] = 0;
		} else if (direction == LEFT) {
			this.board[rowIdx][columnIdx - 1] = this.board[rowIdx][columnIdx];
			this.board[rowIdx][columnIdx] = 0;
		}

	}

	protected boolean isMoveValid(int row, int column, int direction) {
		if (direction == UP) {
			if (row == 0) {
				return false;
			}
			if (this.board[row - 1][column] == 0) {
				return true;
			}
		} else if (direction == DOWN) {
			if (row == 3) {
				return false;
			}
			if (this.board[row + 1][column] == 0) {
				return true;
			}
		} else if (direction == RIGHT) {
			if (column == 3) {
				return false;
			}
			if (this.board[row][column + 1] == 0) {
				return true;
			}
		} else if (direction == LEFT) {
			if (column == 0) {
				return false;
			}
			if (this.board[row][column - 1] == 0) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	
	/**
	 * @return true if and only if the board is solved,
	 * i.e., the board has all tiles in their correct positions
	 */
	public boolean isSolved() {
		List<Integer> boardNumList = new ArrayList<Integer>();
		for (int i=0; i < this.board.length; i++)
			for (int j=0; j < this.board[i].length; j++)
				boardNumList.add(this.board[i][j]);

		for (int i=1; i < boardNumList.size() - 1; i++)
			if (boardNumList.get(i-1) != i) {
				return false;
			}
		return true;
	}
	
	@Override
	public String toString() {
		String formattedBoard = "";
		String strToAppend = null;
		int val = 0;
		for (int i=0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				val = this.board[i][j];
				if (val == 0) {
					strToAppend = " " + " " + " ";
				} else if (val < 10) {                // Check if 1 digit
					strToAppend = " " + val + " ";
				} else {                    		  // is 2-digit number
					strToAppend = val + " ";
				}
				formattedBoard += strToAppend;
			}
			formattedBoard = formattedBoard.substring(0, formattedBoard.length()-1);
			formattedBoard += "\n";
		}
		return formattedBoard;
	}
}

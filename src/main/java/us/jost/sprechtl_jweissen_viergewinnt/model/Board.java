package us.jost.sprechtl_jweissen_viergewinnt.model;

import java.util.ArrayList;

public class Board {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int WINDIST = 4;
    private final ArrayList<ArrayList<Cell>> board = new ArrayList<>();
    private Cell previouslyChanged;

    public Board() {
        for (int x = 0; x < COLS; x++) {
            board.add(new ArrayList<>());
            for (int y = 0; y < ROWS; y++) {
                board.get(x).add(new Cell(x, y));
            }
        }
        previouslyChanged = null;
    }

    /**
     * @return If given position is in the boundaries of ROWS/COLS
     */
    private static boolean inArea(int x, int y) {
        return (x < COLS) && (x >= 0) && (y < ROWS) && (y >= 0);
    }

    public boolean checkWin() {
        int winCount = 0;
        PlayerID playerID = previouslyChanged.getState();
        int x = previouslyChanged.getX();
        int y = previouslyChanged.getY();
        int ix;
        int iy;
        boolean isWin;

        //horizontal and vertical
        isWin = isWinHorVer(x, y, playerID) || isWinHorVer(y, x, playerID);

        //left up to right down
        for (ix = initI_negative(x), iy = initI_negative(y); inArea(ix, iy) && !isWin; ix++, iy++) {
            try {
                if (accessCell(ix, iy).getState() == playerID) {
                    winCount++;
                } else {
                    winCount = 0;
                }
            } catch (InvalidPositionException ignored) {
            }
            if (winCount >= WINDIST) {
                isWin = true;
            }
        }

        //left down to right up
        for (ix = initI_negative(x), iy = initI_positive(y); inArea(ix, iy) && !isWin; ix++, iy--) {
            try {
                if (accessCell(ix, iy).getState() == playerID) {
                    winCount++;
                } else {
                    winCount = 0;
                }
            } catch (InvalidPositionException ignored) {
            }
            if (winCount >= WINDIST) {
                isWin = true;
            }
        }

        return isWin;
    }

    private boolean isWinHorVer(int direction, int i, PlayerID playerID) {
        boolean isWin = false;
        int winCount = 0;

        for (direction = initI_negative(direction); inArea(direction, 0) && !isWin; direction++) {
            try {
                if (accessCell(direction, i).getState() == playerID) {
                    winCount++;
                } else {
                    winCount = 0;
                }
            } catch (InvalidPositionException ignored) {
            }
            if (winCount >= WINDIST) {
                isWin = true;
            }
        }

        return isWin;
    }

    /**
     * @return Minimum value to end of area/to the winning number 4/WINDIST from current location
     */
    private int initI_negative(int z) {
        return Math.max(z - WINDIST, 0);
    }

    /**
     * @return Maximum value to end of area/to the winning number 4/WINDIST from current location
     */
    private int initI_positive(int z) {
        return (z + WINDIST >= COLS) ? COLS - 1 : z + WINDIST;
    }

    public boolean checkTie() {
        boolean isTie = true;
        for (int x = 0; x < COLS && isTie; x++) {
            for (int y = 0; y < ROWS && isTie; y++) {
                try {
                    if (accessCell(x, y).getState() == null) {
                        isTie = false;
                    }
                } catch (InvalidPositionException ignored) {
                }
            }
        }
        return isTie;
    }

    /**
     * @return The board without other cell data than its value.
     */
    public ArrayList<ArrayList<PlayerID>> boardToPlayerIDs() {
        ArrayList<ArrayList<PlayerID>> boardIDs = new ArrayList<>();

        for (int x = 0; x < COLS; x++) {
            boardIDs.add(new ArrayList<>());
            for (int y = 0; y < ROWS; y++) {
                try {
                    boardIDs.get(x).add(accessCell(x, y).getState());
                } catch (InvalidPositionException ignored) {
                }
            }
        }

        return boardIDs;
    }

    /**
     * @return next free spot.
     * @throws IllegalArgumentException If row is already full.
     */
    public int getNextFreeRow(int col) throws InvalidPositionException {
        int nextFreeRow = -1;

        for (int y = 0; y < ROWS && nextFreeRow == -1; y++) {
            if (accessCell(col, y).getState() == null) {
                nextFreeRow = y;
            }
        }
        if (nextFreeRow == -1) {
            throw new InvalidPositionException();
        }
        return nextFreeRow;
    }

    public Cell accessCell(int x, int y) throws InvalidPositionException {
        if (!inArea(x, y)) {
            throw new InvalidPositionException();
        }

        return board.get(x).get(y);
    }

    public Cell getPreviouslyChanged() {
        return previouslyChanged;
    }

    public void setPreviouslyChanged(Cell previouslyChanged) {
        this.previouslyChanged = previouslyChanged;
    }
}

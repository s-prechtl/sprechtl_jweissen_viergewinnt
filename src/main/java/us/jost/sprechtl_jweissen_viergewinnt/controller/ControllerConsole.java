package us.jost.sprechtl_jweissen_viergewinnt.controller;

import us.jost.sprechtl_jweissen_viergewinnt.model.Game;
import us.jost.sprechtl_jweissen_viergewinnt.model.InvalidPositionException;
import us.jost.sprechtl_jweissen_viergewinnt.model.PlayerID;
import us.jost.sprechtl_jweissen_viergewinnt.model.UndoNotPossibleException;
import us.jost.sprechtl_jweissen_viergewinnt.view.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

//TODO j-weissen: Klassendiagramm updaten!!!
public class ControllerConsole {
    private static Game game;
    private static BoardView boardView;
    private static PromptView promptView;
    private static MessageView messageView;

    private static Scanner scanner;
    private static Pattern legalAction;

    public static void main(String[] args) {
        initialize();

        char action;
        boolean win, tie, reset;

        do {
            do {
                action = promptAction();
                if (Character.isDigit(action)) {
                    tryPlace(action);
                } else if (action == 'U') {
                    tryUndo();
                } else if (action == 'R') {
                    game.reset();
                }
                win = game.checkWin();
                tie = game.checkTie();
            } while (!(win || tie));

            showResult(win);

            reset = promptReset();
            if (reset) {
                game.reset();
            }
        } while (reset);
    }

    /**
     * versucht einen Spielstein zu platzieren, sollte dies nicht möglich sein,
     * wird eine Error-Message ausgegeben
     * @param action die Spalte, in die gesetzt werden soll
     */
    private static void tryPlace(char action) {
        try {
            game.play(Integer.parseInt(String.valueOf(action)));
            game.switchCurrPlayer();
        } catch (InvalidPositionException ipe) {
            messageView.display(ipe.getMessage());
        }
    }

    /**
     * versucht, den letzten Move rückgängig zu machen, sollte dies nicht möglich sein,
     * wird eine Error-Message ausgegeben
     */
    private static void tryUndo() {
        try {
            game.undo();
            messageView.display("Last move undone!");
        } catch (UndoNotPossibleException unpe) {
            messageView.display(unpe.getMessage());
        }
    }


    /**
     * initialisiert die Attribute der Controller-Klasse
     */
    private static void initialize() {
        scanner = new Scanner(System.in);
        promptView = new PromptViewConsole();
        messageView = new MessageViewConsole();
        initializeGame();
        boardView = new BoardViewConsole(promptPlayingChars());
        legalAction = Pattern.compile("[0-6]|[RU]", Pattern.CASE_INSENSITIVE);
        messageView.display("Let the game begin!");
    }

    /**
     * initialisiert die Game-Klasse, fragt dafür die Spieler nach ihren Namen
     */
    private static void initializeGame() {
        String name1, name2;
        promptView.display("Player0", "Enter your name:");
        name1 = scanner.nextLine();
        do {
            promptView.display("Player1", "Enter your name:");
            name2 = scanner.nextLine();
        } while (Objects.equals(name1, name2));
        game = new Game(name1, name2);
    }

    /**
     * Fragt die Spieler nach ihren Spielsymbolen
     * Wird keine Eingabe getätigt, werden die Standartwerte X und O verwendet
     *
     * @return HashMap der Spieler und ihrer Symbole
     *         kann so an den BoardViewConsole-Konstruktor übergeben werden
     */
    private static HashMap<PlayerID, Character> promptPlayingChars() {
        HashMap<PlayerID, Character> defaultPlayingChars = new HashMap<>();
        defaultPlayingChars.put(PlayerID.Player0, 'X');
        defaultPlayingChars.put(PlayerID.Player1, 'O');

        HashMap<PlayerID, Character> playingChars = new HashMap<>();
        do {
            for (PlayerID playerID : defaultPlayingChars.keySet()) {
                promptView.display(game.getPlayerName(playerID), "Enter your playing character: (Enter for default)");
                String temp = scanner.nextLine();
                if (!Objects.equals(temp, "")) {
                    playingChars.put(playerID, temp.toCharArray()[0]);
                } else {
                    playingChars.put(playerID, defaultPlayingChars.get(playerID));
                }
            }
        } while (playingChars.get(PlayerID.Player0) == playingChars.get(PlayerID.Player1));

        return defaultPlayingChars;
    }

    /**
     * Fragt den currPlayer nach einem Zug / einer Aktion
     * sollte die Eingabe ungültig sein (= nicht auf das legalAction Pattern passen), wird erneut gefragt
     *
     * @return gibt den eingegeben gültigen char zurück
     */
    private static char promptAction() {
        String input;
        boardView.display(game.getPlayerIDBoard());
        do {
            promptView.display(game.getPlayerName(game.getCurrPlayer()), "Enter your action: (0-6, [R]eset, [U]ndo)");
            input = scanner.nextLine();
        } while (!legalAction.matcher(input).matches());
        return input.toUpperCase().toCharArray()[0];
    }

    /**
     * Gibt das Ergebnis des Spieles aus
     * @param win gibt an, ob jemand gewonnen hat oder ob es unentschieden ausging
     */
    private static void showResult(boolean win) {
        boardView.display(game.getPlayerIDBoard());
        if (win) {
            game.switchCurrPlayer();
            messageView.display(game.getPlayerName(game.getCurrPlayer()) + " has won! Congratulations!");
        } else {
            messageView.display("It's a tie!");
        }
    }

    /**
     * fragt nach dem Spielende, ob das spiel neu gestartet werden soll
     * @return ob das spiel neu gestartet werden soll
     */
    private static boolean promptReset() {
        String input;
        messageView.display("Do you want to play again? (y/N)");
        input = scanner.nextLine();
        return Objects.equals(input, "y");
    }
}


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

public class ControllerConsole {
    private static Game game;
    private static BoardView boardView;
    private static PromptView promptView;
    private static MessageView messageView;

    private static Scanner scanner;

    public static void main(String[] args) {
        initialize();

        char action;
        String input;
        boolean win, tie, restart;
        Pattern legalAction = Pattern.compile("[0-6]|[RU]", Pattern.CASE_INSENSITIVE);
        do {
            do {
                boardView.display(game.getPlayerIDBoard());
                do {
                    promptView.display(game.getPlayerName(game.getCurrPlayer()), "Enter your action: (0-6, [R]eset, [U]ndo)");
                    input = scanner.nextLine();
                } while (!legalAction.matcher(input).matches());
                action = input.toUpperCase().toCharArray()[0];

                if (Character.isDigit(action)) {
                    try {
                        game.play(Integer.parseInt(String.valueOf(action)));
                        game.switchCurrPlayer();
                    } catch (InvalidPositionException ipe) {
                        messageView.display(ipe.getMessage());
                    }
                } else if (action == 'U') {
                    try {
                        game.undo();
                        messageView.display("Last move undone!");
                    } catch (UndoNotPossibleException unpe) {
                        messageView.display(unpe.getMessage());
                    }
                } else if (action == 'R') {
                    game.reset();
                }
                win = game.checkWin();
                tie = game.checkTie();
            } while (!(win || tie));

            boardView.display(game.getPlayerIDBoard());
            if (win) {
                game.switchCurrPlayer();
                messageView.display(game.getPlayerName(game.getCurrPlayer()) + " has won! Congratulations!");
            } else {
                messageView.display("It's a tie!");
            }

            messageView.display("Do you want to play again? (y/N)");
            input = scanner.nextLine();
            restart = Objects.equals(input, "y");
            if (restart) {
                game.reset();
            }
        } while (restart);
    }

    private static void initialize() {
        scanner = new Scanner(System.in);
        promptView = new PromptViewConsole();
        messageView = new MessageViewConsole();

        HashMap<PlayerID, Character> defaultPlayingChars = new HashMap<>();
        defaultPlayingChars.put(PlayerID.Player0, 'X');
        defaultPlayingChars.put(PlayerID.Player1, 'O');

        String name1, name2;
        promptView.display("Player0", "Enter your name:");
        name1 = scanner.nextLine();
        do {
            promptView.display("Player1", "Enter your name:");
            name2 = scanner.nextLine();
        } while (Objects.equals(name1, name2));
        game = new Game(name1, name2);

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

        boardView = new BoardViewConsole(playingChars);
        messageView.display("Let the game begin!");
    }
}

package Modul1;

public class Tennis {
    private int player1, player2;

    public Tennis() {
        player1 = 0;
        player2 = 0;
    }

    public String point(int player) {

        if (player == 1) {
            player1 += player1 < 30 ? 15 : 10;
        }
        if (player == 2) {
            player2 += player2 < 30 ? 15 : 10;

        }
        if ((player1 >= 40 && player2 >= 40) || (player1 > 40 || player2 > 40)) {
            int difference = player1 - player2;
            if (difference == 0) {
                return "Deuce";
            } else if (difference == 10) {
                return "player 1 has advantage";
            } else if (difference >= 20) {
                ResetGame();
                return "player 1 has Won the Game";
            } else if (difference == -10) {
                return ("player 2 has advantage");
            } else if (difference <= -20) {
                ResetGame();
                return "player 2 has Won the Game";
            }
        }
        return String.format("%d-%d", player1, player2);
    }

    public void ResetGame() {
        player1 = 0;
        player2 = 0;
        System.out.println("Game Reset");
    }
}
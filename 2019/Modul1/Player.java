package Modul1;

import java.util.Date;

class Player {
    Date Timestarted;
    String name;

        public Player() {
            Timestarted = new java.util.Date();
        }

        public Player(String name, int playerNr) {
            this.name = name;

        }
}

package de.htwg.se.catanishsettlers.modules.mechanic;

import de.htwg.se.catanishsettlers.modules.map.*;

/**
 * Singleton
 * Created by Stephan on 03.04.2015.
 */
public class Turn {
    private static Turn singleton;

    private Player activePlayer;

    private Turn(Player newPlayer) {
        singleton = this;

        // set active player
        activePlayer = newPlayer;

        // offer to play cards

        // roll dice
        DiceRoll roll = new DiceRoll(2);

        if (roll.getValue() == 7) {
            de.htwg.se.catanishsettlers.modules.map.Field chosenField = null;   // TODO: Make player choose field
            Robber.getInstance().moveToField(chosenField);
        } else {
            //distributeResources(dieRoll);
        }
    }

    public static Turn getInstance(Player newPlayer) {
        if (singleton == null) new Turn(newPlayer);
        return singleton;
    }
}

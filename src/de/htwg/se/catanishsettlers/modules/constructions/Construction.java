package de.htwg.se.catanishsettlers.modules.constructions;

import de.htwg.se.catanishsettlers.modules.map.MapObject;
import de.htwg.se.catanishsettlers.modules.mechanic.Investment;
import de.htwg.se.catanishsettlers.modules.mechanic.Player;
import de.htwg.se.catanishsettlers.modules.view.IGenerateMessages;
import de.htwg.se.catanishsettlers.modules.view.Message;

import java.util.ArrayList;

/**
 * Created by Stephan on 01.04.2015.
 */
public abstract class Construction extends Investment implements IGenerateMessages{
    protected Player owner;
    private MapObject position;

    public Construction(Player player, MapObject position) {
        categories.add(Message.Category.CONSTRUCTION);
        owner = player;
        this.position = position;
    }

    public Player getPlayer() {
        return owner;
    }

    public MapObject getPosition() {return position;}

    public Message[] getMessages() {
        ArrayList<Message> messages = new ArrayList<Message>();

        String text;
        Message.Detail detail;

        detail = Message.Detail.LOW;
        text = getClass().getSimpleName();
        messages.add(new Message(text, detail, categories));

        detail = Message.Detail.MEDIUM;
        text = "(TODO: COORDINATES)";
        messages.add(new Message(text, detail, categories));

        detail = Message.Detail.HIGH;
        text = "owned by " + getPlayer().getName();
        messages.add(new Message(text, detail, categories));

        return messages.toArray(new Message[messages.size()]);
    }
}

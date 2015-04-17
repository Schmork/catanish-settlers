package de.htwg.se.catanishsettlers.modules.mechanic;

import de.htwg.se.catanishsettlers.modules.constructions.*;
import de.htwg.se.catanishsettlers.modules.map.Edge;
import de.htwg.se.catanishsettlers.modules.map.MapObject;
import de.htwg.se.catanishsettlers.modules.map.Vertex;
import de.htwg.se.catanishsettlers.modules.resources.Resource;
import de.htwg.se.catanishsettlers.modules.resources.ResourceCollection;
import de.htwg.se.catanishsettlers.modules.view.IGenerateMessages;
import de.htwg.se.catanishsettlers.modules.view.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephan on 31.03.2015.
 */
public class Player implements IGenerateMessages {
    private String name = "unnamed";
    private ArrayList<Card> cards;
    private int knightCount, victoryCardsCount;
    private ResourceCollection resources;
    private List<Building> buildings;
    private List<Road> roads;
    private Game game;

    private boolean hasLargestKnightArmy, hasLongestTradeRoute;

    public Player(String name, Game game) {     // creates new Player and registers the game for him
        this(name);
        this.game = game;
    }

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<Card>();
        buildings = new ArrayList<Building>();
        resources = new ResourceCollection();
    }

    public String getName() {
        return name;
    }

    public boolean playCard(Card.Types cardType) {

        Card foundCard = null;
        for (Card card : cards) {
            if (card.getType() == cardType) {
                foundCard = card;
                break;
            }
        }

        if (foundCard == null) return false;        // player didn't have such a card

        cards.remove(foundCard);
        switch (cardType) {
            case KNIGHT: knightCount++;
                //TODO: reposition robber
                break;
            case VICTORYPOINT: victoryCardsCount++;
                break;
            case PROGRESS_DEVELOPMENT:  //TODO: get 2 resources as requested
                break;
            case PROGRESS_MONOPOLY:     //TODO: get all resources from other players of one requested type
                break;
            case PROGRESS_ROAD_CONSTRUCTION:    //TODO: immediately legally place 2 roads without paying cost
                break;
            default: throw new IllegalStateException();   // this should never happen as there are only 3 card types
        }
        return true;
    }

    public int getScore() {
        int score = 0;
        for (Building building : buildings) {
            score += building.getScore();
        }
        if (hasLargestKnightArmy) score += 2;
        if (hasLongestTradeRoute) score += 2;
        for (Card card : cards) {
            if (card.getType() == Card.Types.VICTORYPOINT) score++;     // victory cards count in hand ...
        }
        score += victoryCardsCount; // ... as well as on the table (there's actually no reason to play them but you can)
        return score;
    }

    public int getKnightCount() {
        // http://www.ludopedia.de/Gr%C3%B6%C3%9Fte_Rittermacht
        return knightCount;
    }

    public void addResources(Resource res) {
        resources.add(res);
    }
    public void addResources(ResourceCollection res) { resources.add(res); }

    public ResourceCollection getResources() {
        return resources;
    }

    public boolean makeInvestment(Class<?> desiredClass, MapObject desiredPlace) {     //TODO: extend parameters by vertex / edge for building / road
        if (!Investment.class.isAssignableFrom(desiredClass)) throw new IllegalArgumentException(); // is investment?

        Investment investment;
        if (desiredClass == Road.class) {
            investment = new Road(this, (Edge)desiredPlace);
        } else if (desiredClass == Settlement.class) {
            investment = new Settlement(this, (Vertex)desiredPlace);
        } else if (desiredClass == City.class) {
            investment = new City(this, (Vertex)desiredPlace);
        } else if (desiredClass == Card.class) {
            investment = game.getTopCard();
        } else {
            investment = new Road(null, null);     // to quiet the compiler who worries about investment initialization
            throw new IllegalArgumentException();       // the desiredClass is no known investment
        }

        if (resources.compareTo(investment.getCost()) < 0) return false;    // player doesn't have enough resources

        //TODO: actually place the building / street

        resources.subtract(investment.getCost());     // pay the price

        if (investment instanceof Building) {
            buildings.add((Building) investment);
        }
        if (investment instanceof Card) {
            cards.add((Card)investment);
        }
        return true;    // player had enough resources
    }

    public Message[] getMessages() {
        List<Message> messages = new ArrayList<Message>();

        String text;
        Message.Detail detail;

        detail = Message.Detail.MEDIUM;
        text = getClass().getSimpleName();
        messages.add(new Message(text, detail, categories));

        detail = Message.Detail.LOW;
        text = name;
        messages.add(new Message(text, detail, categories));

        detail = Message.Detail.MEDIUM;
        text = "(" + getScore() + " points)";
        messages.add(new Message(text, detail, categories));

        detail = Message.Detail.HIGH;
        text = System.lineSeparator() + getResources().toString();
        messages.add(new Message(text, detail, categories));

        return messages.toArray(new Message[messages.size()]);
    }
}

package cards;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import rooms.Room;
import runner.Game;
import utilities.Utilities;
import weapons.Weapon;
import entity.Entity;
import graphics.Assets;

public class Card extends Entity {
	public static final int CARD_WIDTH = 296, CARD_HEIGHT = 376;
	// Fields
	public static ArrayList<PlayerCard> playerCards = new ArrayList<PlayerCard>();
	public static ArrayList<WeaponCard> weaponCards = new ArrayList<WeaponCard>();
	public static ArrayList<RoomCard> roomCards = new ArrayList<RoomCard>();
	protected BufferedImage texture;
	protected boolean choosen;
	protected String name, slogan, interSlogan;

	public Card(Game game, int x, int y, int width, int height, int id) {
		super(game, x, y, width, height, id);
		choosen = false;
	}

	public static void initialize(Game game) {
		String[] temp;
		int rowPadding = 100;
		int colPadding = 0;

		playerCards.clear();
		weaponCards.clear();
		roomCards.clear();

		for (int x = 0; x < Assets.chars.size(); x++) {
			temp = Assets.chars.get(x).split("-");
			playerCards.add(new PlayerCard(game, colPadding, rowPadding,
					CARD_WIDTH, CARD_HEIGHT, x, temp[0], temp[1], temp[2]));

			colPadding += CARD_WIDTH + 25;
			if ((x + 1) % 4 == 0) {
				rowPadding += 25 + CARD_HEIGHT;
				colPadding = 0;
			}
		}// End for

		rowPadding = 100;
		colPadding = 0;

		for (int x = 0; x < Weapon.weapons.size(); x++) {
			weaponCards.add(new WeaponCard(game, colPadding, rowPadding,
					CARD_WIDTH, CARD_HEIGHT, Weapon.weapons.get(x).getId(),
					Weapon.weapons.get(x).getName(), Weapon.weapons.get(x)
							.getSlogan()));

			colPadding += CARD_WIDTH + 25;
			if ((x + 1) % 3 == 0) {
				rowPadding += 25 + CARD_HEIGHT;
				colPadding = 0;
			}
		}// End for

		for (int x = 1; x < Room.rooms.length; x++)
			roomCards.add(new RoomCard(game, 0, 0, CARD_WIDTH, CARD_HEIGHT, x,
					Room.rooms[x].getName()));
		// End for

	}// End method initialize

	public BufferedImage getTexture() {
		return texture;
	}

	public String getName() {
		return name;
	}

	public String getSlogan() {
		return slogan;
	}

	public String getInterSlogan() {
		return interSlogan;
	}

	public boolean isChoosen() {
		return choosen;
	}

	public void choosen() {
		choosen = true;
	}

	public void unChoosen() {
		choosen = false;
	}

	public static void reset() {
		for (int x = 0; x < playerCards.size(); x++)
			playerCards.get(x).unChoosen();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	public static ArrayList<PlayerCard> getPlayerCards() {
		return playerCards;
	}

	public static ArrayList<WeaponCard> getWeaponCards() {
		return weaponCards;
	}

	public static ArrayList<RoomCard> getRoomCards() {
		return roomCards;
	}

	@Override
	public void render(Graphics2D g) {
		if (choosen) {
			g.drawImage(texture,
					(int) (getX() - game.getCamera().getxOffset()),
					(int) (getY() - game.getCamera().getyOffset()), CARD_WIDTH,
					CARD_HEIGHT, null);
			g.setColor(new Color(55, 55, 55, 155));
			g.fillRect((int) (getX() - game.getCamera().getxOffset()),
					(int) (getY() - game.getCamera().getyOffset()), CARD_WIDTH,
					CARD_HEIGHT);
		} else {
			g.drawImage(texture,
					(int) (getX() - game.getCamera().getxOffset()),
					(int) (getY() - game.getCamera().getyOffset()), CARD_WIDTH,
					CARD_HEIGHT, null);
		}
	}

	public static void realignCards(Card[] cards) {
		int rowPadding = 100;
		int colPadding = 0;

		for (int x = 0; x < cards.length; x++) {
			cards[x].setX(colPadding);
			cards[x].setY(rowPadding);

			colPadding += CARD_WIDTH + 25;
			if ((x + 1) % 3 == 0) {
				rowPadding += 25 + CARD_HEIGHT;
				colPadding = 0;
			}
		}// End for
	}

	public static void realignPlayerCards(ArrayList<PlayerCard> cards) {
		int rowPadding = 100;
		int colPadding = 0;

		for (int x = 0; x < cards.size(); x++) {
			cards.get(x).setX(colPadding);
			cards.get(x).setY(rowPadding);

			colPadding += CARD_WIDTH + 25;
			if ((x + 1) % 3 == 0) {
				rowPadding += 25 + CARD_HEIGHT;
				colPadding = 0;
			}
		}// End for
	}

	public static void realignWeaponCards(ArrayList<WeaponCard> cards) {
		int rowPadding = 100;
		int colPadding = 0;

		for (int x = 0; x < cards.size(); x++) {
			cards.get(x).setX(colPadding);
			cards.get(x).setY(rowPadding);

			colPadding += CARD_WIDTH + 25;
			if ((x + 1) % 3 == 0) {
				rowPadding += 25 + CARD_HEIGHT;
				colPadding = 0;
			}
		}// End for
	}

	public String toString() {
		return name + " " + slogan + " " + x + " " + y;
	}
}// End class Card

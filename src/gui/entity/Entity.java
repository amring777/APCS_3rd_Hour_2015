package entity;

import java.awt.Graphics;
import java.util.ArrayList;

import runner.Game;
import tiles.Tile;
import utilities.Utilities;

public abstract class Entity
{
	protected Game game;
	protected int x, y;
	protected int width, height;
	protected int id;


	
	public Entity(Game game, int x, int y, int width, int height, int id)
	{
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
	}//End constructor
	
	public abstract void tick();
	public abstract void render(Graphics g);

	//Getters & Setters
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public int getId(){return id;}
	
	public String toString()
	{
		return String.format("X : %d%nY : %d", getX() / Tile.TILE_WIDTH, getY() / Tile.TILE_HEIGHT);
	}//End toString method
}//End class Entity
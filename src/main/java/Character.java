package main.java;

import processing.core.PApplet;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {

	private MainApplet parent;
	
	private String name;
	private int value;
	private Color c;
	
	private float initX;
	private float initY;
	
	private float centerX;
	private float centerY;
	
	private boolean inNetwork;

	private ArrayList<Character> targets;
	
	public Character(MainApplet parent , String name , float x,float y ){

		this.parent = parent;
		this.name = name;
		this.value = value;
		
		this.initX = x;
		this.initY = y;
		
		this.centerX = this.initX;
		this.centerY = this.initY;
		
		this.targets = new ArrayList<>();
		this.inNetwork = false;
	}

	public void display(){
		this.parent.ellipse(this.centerX, this.centerY, 50, 50);
		this.parent.fill(0);
		
		this.parent.textSize(5);
		this.parent.text(name, centerX+10, centerY+10);
		this.parent.fill(255);
	}
	
	public void setCenterX(float x){
		this.centerX = x;
	}
	
	public float getCenterX(){
		return this.centerX;
	}
	
	public void setCenterY(float y){
		this.centerY = y;
	}
	
	public float getCenterY(){
		return this.centerY;
	}
	
	public void setInNetwork(boolean b){
		this.inNetwork = b;
	}
	
	public boolean getInNetwork(){
		return this.inNetwork;
	}
	
	public String getName(){
		return this.name;
	}
	
	public float getInitX(){
		return this.initX;
	}
	
	public float getInitY(){
		return this.initY;
	}
	
}

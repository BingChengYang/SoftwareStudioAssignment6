package main.java;

import processing.core.PApplet;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {

	private MainApplet parent;
	
	private String name;
	private String color;
	private Color c;
	
	private float initX;
	private float initY;
	
	private float centerX;
	private float centerY;
	
	private boolean inNetwork;

	private ArrayList<Character> targets;
	private int[] value = new int [100];
	
	private int index = 0;
	
	public Character(MainApplet parent , String name ,String color,  float x,float y ){

		this.parent = parent;
		this.name = name;
		this.color = color;
		
		this.initX = x;
		this.initY = y;
		
		this.centerX = this.initX;
		this.centerY = this.initY;
		
		this.targets = new ArrayList<>();
		this.inNetwork = false;
	}

	public void display(){
		this.parent.fill(this.turncolor());
		this.parent.ellipse(this.centerX, this.centerY, 50, 50);
		//System.out.println(this.color.replace("#", ""));
		
	}
	
	public void initial(){
		this.centerX = this.initX;
		this.centerY = this.initY;
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
	
	public String getColor(){
		return this.color;
	}
	
	public float getInitX(){
		return this.initX;
	}
	
	public float getInitY(){
		return this.initY;
	}
	
	public float getDistance(float x,float y){
		float distance = (x-centerX)*(x-centerX) + (y-centerY)*(y-centerY);
		return distance;
	}
	
	public void add(Character ch){
		this.targets.add(ch);
	}
	
	public ArrayList<Character> getTargets(){
		return this.targets;
	}
	
	public int turncolor(){
		int hi = (int) Long.parseLong(this.color.replace("#", ""), 16);
		return hi;
	}
	
	public void setValue(int n){
		this.value[index]=n;
		index++;
	}
	public int getValue(int n){
		return this.value[n];
	}
}
